package capgemini.banking.service;

import java.util.Collection;
import java.util.Scanner;

import capgemini.banking.bean.Account;
import capgemini.banking.exception.AccountNotFoundException;

public class Main_AccountService {

	static Scanner sc = new Scanner(System.in);

	public static Account getInputAccount() {
		String accountName = getInput("Enter AccountName:");
		double openingBalance = Double.parseDouble(getInput("Enter Opening Balance:"));
		Account account = new Account(accountName, openingBalance);
		return account;
	}

	public static String getInput(String message) {
		System.out.println(message);
		return sc.next();
	}

	public static void main(String[] args) {
		AccountService accountService = new AccountServiceImpl(5);
		int choice = 0;
		int accountNo;
		double amount;
		Account account;
		do {
			System.out.println("Welcome to World Bank...");
			System.out.println("1.Create Account");
			System.out.println("2.Deposit");
			System.out.println("3.Withdraw");
			System.out.println("4.FundsTransfer");
			System.out.println("5.Show Balance");
			System.out.println("6.PrintTransactions");
			System.out.println("7.Exit");
			System.out.print("Enter Choice:");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.println("\t\t::==>Account Creation in process...");
				account = getInputAccount();
				account = accountService.createAccount(account);
				System.out.println(account);
				System.out.println("\t\t::==>Account Created...");
				break;
			case 2:
				System.out.println("\t\t::==>Account Deposit in process...");
				accountNo = Integer.parseInt(getInput("\nEnter Account No: "));
				amount = Double.parseDouble(getInput("\nEnter Amount: "));
				try {
					accountService.deposit(accountNo, amount);
				} catch (AccountNotFoundException e) {
					System.err.println("Account Deposit:->"+e.getMessage());
				}
				System.out.println("\t\t::==>Account Deposited...");
				break;
			case 3:
				System.out.println("\t\t::==>Account Withdraw in process...");
				accountNo = Integer.parseInt(getInput("\nEnter Account No: "));
				amount = Double.parseDouble(getInput("\nEnter Amount: "));
				try {
					accountService.withdraw(accountNo, amount);
				} catch (AccountNotFoundException e) {
					System.err.println("Account Withdraw:->"+e.getMessage());
				}
				System.out.println("\t\t::==>Account Withdrawn...");
				break;
			case 4:
				break;
			case 5:
				System.out.println("\t\t::==>Account Show Balance in process...");
				accountNo = Integer.parseInt(getInput("\nEnter Account No: "));
				try {
					account = accountService.getBalance(accountNo);
					System.out.println("Current Balance: " + account.getCurrentBalance());
					System.out.println("\t\t::==>Account Balance Shown...");
				} catch (AccountNotFoundException e) {
					e.printStackTrace();
				}
				break;
			case 6:
				System.out.println("\t\t::==>Account Transaction in process...");
				Collection<Account> accounts = accountService.getTransactions();
				accounts.forEach(System.out::println);
				System.out.println("\t\t::==>Account Transaction printed...");
				break;
			default:
				System.out.println("Exit...");
			}
		} while (choice != 7);
	}
}
