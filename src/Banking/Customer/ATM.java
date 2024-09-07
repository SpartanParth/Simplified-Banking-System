package Banking.Customer;

public class ATM {
	private int atmId;
	private String atmLocation;
	public ATM(int atmId, String atmLocation) {
		super();
		this.atmId = atmId;
		this.atmLocation = atmLocation;
	}
	public int getAtmId() {
		return atmId;
	}
	public String getAtmLocation() {
		return atmLocation;
	}
	public void checkBalance(Account account) {
		System.out.println(account.getBalance());
	}
	public void deposit(Account account,double amount) {
		account.deposit(amount);
	}
	public void withdraw(Account account,double amount) {
		account.withdraw(amount);
	}
	public void validatePIN(Account account, int enteredPIN) {
		account.validatePin(enteredPIN);
	}
}
