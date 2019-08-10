package capgemini.banking.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import capgemini.banking.bean.Account;
import capgemini.banking.exception.AccountNotFoundException;
import capgemini.banking.exception.InSufficientBalanceException;

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
	public void withdraw(int accountNo, double amount) 
			throws AccountNotFoundException, InSufficientBalanceException {
		Account account = map_Account.get(accountNo);
		if(account == null) throw new AccountNotFoundException(accountNo+" does not exists...");
		double currentBalance = account.getCurrentBalance();
		if(currentBalance <= amount) throw new InSufficientBalanceException(accountNo+" balance is less than transfer amount...");
		currentBalance -= amount;
		account.setCurrentBalance(currentBalance);
	}
	
	@Override
	public void fundsTransfer(int accountNoFrom, int accountNoTo, double amount) 
			throws AccountNotFoundException, InSufficientBalanceException {
		Account accountFrom = map_Account.get(accountNoFrom);
		if(accountFrom == null) throw new AccountNotFoundException(accountNoFrom+" does not exists...");
		
		Account accountTo = map_Account.get(accountNoTo);
		if(accountTo == null) throw new AccountNotFoundException(accountNoTo+" does not exists...");

		System.out.println("Account From:"+ accountNoFrom);
		System.out.println("Account To  :"+ accountNoTo);
		
		double accountFromBalance =  accountFrom.getCurrentBalance();
		if(accountFromBalance <= amount) throw new InSufficientBalanceException(accountNoFrom+" balance is less than transfer amount...");
		
		accountFromBalance -= amount;
		accountFrom.setCurrentBalance(accountFromBalance);
		
		double accountToBalance = accountTo.getCurrentBalance();
		accountToBalance += amount;
		
		accountTo.setCurrentBalance(accountToBalance);
		
		System.out.println("Account From:"+ accountNoFrom);
		System.out.println("Account To  :"+ accountNoTo);

	}
	
	@Override
	public double getBalance(int accountNo) throws AccountNotFoundException {
		Account account = map_Account.get(accountNo);
		if(account == null) throw new AccountNotFoundException(accountNo+" does not exists...");
		return map_Account.get(accountNo).getCurrentBalance();
	}

	@Override
	public Collection<Account> getTransactions() {
		return map_Account.values();
	}
}
