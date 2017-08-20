package name.javalex.springboot.controller;

import jdk.nashorn.internal.objects.NativeJSON;
import name.javalex.springboot.exception.RangeNotSatisfiableException;
import name.javalex.springboot.model.Withdrawal;
import name.javalex.springboot.service.ATMService;
import name.javalex.springboot.service.OperationsService;
import name.javalex.springboot.service.UserService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import name.javalex.springboot.entity.AccountTransaction;

import java.util.List;

@RestController
@RequestMapping("/operations")
public class OperationsController {

    private static final Logger LOG = LoggerFactory.getLogger(OperationsController.class);

    private OperationsService operationsService;
    private ATMService atmService;
    private UserService userService;

    @Autowired
    public OperationsController(OperationsService operationsService, ATMService atmService, UserService userService) {
        this.operationsService = operationsService;
        this.atmService = atmService;
        this.userService = userService;
    }

    @RequestMapping(value = "/transactions", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('USER')")
    public List<AccountTransaction> getAccountTransactions() {
        return operationsService.getAccountTransactions();

    }

    @RequestMapping(value = "/balance", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('USER')")
    public Integer getAccountBalance() {
        return userService.getAccountBalance();
    }

    @RequestMapping(value = "/denominations", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('USER')")
    public List<Integer> getDenominations() {
        return atmService.getDenominations();
    }

    @RequestMapping(value = "/withdraw", method = RequestMethod.POST, consumes = {"application/json"})
    @PreAuthorize("hasAuthority('USER')")
    public List<Integer> withdraw(@RequestBody Withdrawal withdrawal) throws RangeNotSatisfiableException {
        LOG.info("Amount: {}", withdrawal);
        return operationsService.withdraw(Integer.valueOf(withdrawal.getAmount()));
    }

}
