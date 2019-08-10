package capgemini.banking.service;

import java.util.Collection;

import capgemini.banking.bean.Account;
import capgemini.banking.exception.AccountNotFoundException;

public interface AccountService {
	public Account createAccount(Account account);
	public void deposit(int accountNo, double amount) throws AccountNotFoundException;
	public void withdraw(int accountNo, double amount) throws AccountNotFoundException;
	//public void fundsTransfer(Account fromAccount, Account toAcctount, double amount) throws AccountNotFoundException;
	public Account getBalance(int accountNo) throws AccountNotFoundException;
	public Collection<Account> getTransactions();
}
