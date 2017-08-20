package name.javalex.springboot.service.impl;

import name.javalex.springboot.entity.AccountTransaction;
import name.javalex.springboot.entity.User;
import name.javalex.springboot.exception.RangeNotSatisfiableException;
import name.javalex.springboot.repository.AccountTransactionRepository;
import name.javalex.springboot.service.ATMService;
import name.javalex.springboot.service.OperationsService;
import name.javalex.springboot.service.SecurityContextService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OperationsServiceImpl implements OperationsService {
    private static final Logger LOG = LoggerFactory.getLogger(OperationsServiceImpl.class);

    private final SecurityContextService securityContextService;
    private final AccountTransactionRepository accountTransactionRepository;
    private ATMService atmService;

    @Autowired
    public OperationsServiceImpl(SecurityContextService securityContextService,
                                 AccountTransactionRepository accountTransactionRepository,
                                 ATMService atmService) {
        this.securityContextService = securityContextService;
        this.accountTransactionRepository = accountTransactionRepository;
        this.atmService = atmService;
    }

    @Override
    public List<AccountTransaction> getAccountTransactions() {
        Optional<User> optional = securityContextService.currentUser();
        if (optional.isPresent()) {
            return accountTransactionRepository.findAllByUser_Id(optional.get().getId());
        }
        return new ArrayList<>();
    }

    @Override
    public List<Integer> withdraw(Integer amount) throws RangeNotSatisfiableException {
        User user = securityContextService.currentUser().get();
        List<Integer> denomination = atmService.getDenominations();
        if (user.getBalance() >= amount && isSuitableDenominationsAvailable(amount, denomination)) {
            return performWithdrawalTransaction(amount, user, denomination);
        }
        throw new RangeNotSatisfiableException("Incorrect amount requested");
    }

    private boolean isSuitableDenominationsAvailable(Integer amount, List<Integer> denomination) throws RangeNotSatisfiableException {
        for (Integer currentDenomination : denomination) {
            if (amount % currentDenomination == 0) {
                return true;
            }
        }
        return false;
    }

    private List<Integer> performWithdrawalTransaction(Integer amount, User user, List<Integer> denomination) {
        List<Integer> requiredBanknotes = new ArrayList<>();
        int nominalCounter = 0;
        while (amount >= 1) {
            int currValue = denomination.get(nominalCounter);
            if (currValue <= amount) {
                requiredBanknotes.add(currValue);
                amount -= currValue;
            } else {
                nominalCounter++;
            }
        }
        LOG.info("Remainder of amount: {}, Required banknotes: {}", amount, requiredBanknotes);
        return requiredBanknotes;
    }
}
