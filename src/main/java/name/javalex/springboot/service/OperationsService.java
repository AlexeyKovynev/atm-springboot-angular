package name.javalex.springboot.service;

import name.javalex.springboot.entity.AccountTransaction;
import name.javalex.springboot.exception.RangeNotSatisfiableException;

import java.util.List;

public interface OperationsService {

    List<AccountTransaction> getAccountTransactions();

    List<Integer> withdraw(Integer amount) throws RangeNotSatisfiableException;
}
