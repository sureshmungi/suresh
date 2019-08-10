package capgemini.banking.bean;

public class Account {

	static int ACCOUNT_NUMBER_SEQUENCE=100;
	private	int accountNo;
	private String accountName;
	private double openingBalance; 
	private	double currentBalance;
	
	public Account(String accountName, double openingBalance) {
		super();
		ACCOUNT_NUMBER_SEQUENCE++;
		setAccountNo(ACCOUNT_NUMBER_SEQUENCE);
		setAccountName(accountName);
		setOpeningBalance(openingBalance);
		setCurrentBalance(openingBalance);
	}

	public int getAccountNo() {
		return accountNo;
	}

	public String getAccountName() {
		return accountName;
	}
	
	public double getOpeningBalance() {
		return openingBalance;
	}

	public double getCurrentBalance() {
		return currentBalance;
	}

	private void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	private void setAccountName(String accountName) {
		this.accountName=accountName;
	}

	private void setOpeningBalance(double openingBalance) {
		this.openingBalance = openingBalance;
	}

	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}

	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", accountName=" + accountName + ", openingBalance=" + openingBalance
				+ ", currentBalance=" + currentBalance + "]";
	}
	
}
