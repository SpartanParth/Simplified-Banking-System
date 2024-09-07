package Banking.Customer;

public class Account {
	private int accountNumber;
	private double balance;
	private int pin;
	public Account(int accountNumber, double balance, int pin) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.pin = pin;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public double getBalance() {
		return balance;
	}
	public int getPin() {
		return pin;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public void deposit(double amount) {
		this.balance+=amount;
		System.out.println("Total balance in your account is: "+this.balance);
	}
	public void withdraw(double amount) {
		try {
			if(this.balance>=amount) {
				this.balance-=amount;
				System.out.println("Dear Customer, your account is debited INR "+amount);
				System.out.println("Total Account Balance is:"+this.balance);
			}else {
				System.out.println("***********Insufficient Balance**************");
			}
			
		}catch(Exception e) {
			System.out.println("***********Insufficient Balance**************");
			e.getStackTrace();
		}
	}
	public void validatePin(int pin) {
		if(this.pin==pin) {
			System.out.println("Welcome to the Banking System");
		}
		else {
			System.out.println("Entered PIN is not Correct");
			
		}
	}
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", balance=" + balance + ", pin=" + pin + "]";
	}
	
}
