package Banking.Customer;

public class Customer {
	private String name;
	private Account account;
	public Customer(String name, Account account) {
		super();
		this.name = name;
		this.account=account;
	}
	public String getName() {
		return this.name;
	}
	public Account getAccount() {
		return this.account;
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", account=" + account + "]";
	}
	
}
