package capgemini.banking.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import capgemini.banking.bean.Account;
import capgemini.banking.exception.AccountNotFoundException;

public class AccountServiceImpl implements AccountService 
{
	Map<Integer, Account> map_Account;
	
	public AccountServiceImpl(int size) {
		map_Account = new HashMap<Integer, Account>(size);
	}

	@Override
	public Account createAccount(Account account) {
		return map_Account.put(account.getAccountNo(), account);
	}

	@Override
	public void deposit(int accountNo, double amount) throws AccountNotFoundException {
		Account account = map_Account.get(accountNo);
		if(account == null) throw new AccountNotFoundException(accountNo+" does not exists...");
		double currentBalance = account.getCurrentBalance();
		currentBalance += amount;
		account.setCurrentBalance(currentBalance);
		//map_Account.put(account.getAccountNo(), account);
	}

	@Override
	public void withdraw(int accountNo, double amount) throws AccountNotFoundException {
		Account account = map_Account.get(accountNo);
		if(account == null) throw new AccountNotFoundException(accountNo+" does not exists...");		
		double currentBalance = account.getCurrentBalance();
		currentBalance -= amount;
		account.setCurrentBalance(currentBalance);
	}
	
	@Override
	public Account getBalance(int accountNo) throws AccountNotFoundException {
		Account account = map_Account.get(accountNo);
		if(account == null) throw new AccountNotFoundException(accountNo+" does not exists...");
		return map_Account.get(accountNo);
	}

	@Override
	public Collection<Account> getTransactions() {
		return map_Account.values();
	}
}
