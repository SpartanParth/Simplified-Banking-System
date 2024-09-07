package Banking.Customer;

public class Bank {
	private int numOfCustomers;
	public Bank(int numOfCustomers) {
		super();
		this.numOfCustomers = numOfCustomers;
	}
	Customer[] customer=new Customer[numOfCustomers];
	
	public void addCustomer(Customer[] customer) {
			this.customer=customer;
	}
	public Customer getCustomer(int accountNumber) {
		Customer customer1=null;
		for(int i=0;i<numOfCustomers;i++) {
			Account account=customer[i].getAccount();
			if(account.getAccountNumber()==accountNumber) {
				customer1= customer[i]; 
				break;
			}
		}
		return customer1;
	}
}
