package Banking.Customer;
import java.util.Scanner;

public class Main {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		ATM atm=new ATM(101,"Delhi");
		System.out.println("How many customers you want to Add to the Bank?");
		int customerCount=sc.nextInt();
		Account[] account=new Account[customerCount];
		Customer[] customer=new Customer[customerCount];
		Bank hdfc=new Bank(customerCount);
		for(int i=0;i<customerCount;i++) {
			System.out.println("Enter Name of customer "+(i+1)+":");
			String name=sc.next();
			System.out.println("Enter Account Number of customer "+(i+1)+":");
			int acNum=sc.nextInt();
			System.out.println("Enter Balance of customer "+(i+1)+":");
			double bal=sc.nextDouble();
			System.out.println("Enter PIN of customer "+(i+1)+":");
			int pin=sc.nextInt();
			account[i]=new Account(acNum,bal,pin);
			customer[i]=new Customer(name,account[i]);
		}
		hdfc.addCustomer(customer);
		Main.validation(customer,customerCount,hdfc,atm);
	}
	public static void validation(Customer[] customer,int customerCount,Bank hdfc,ATM atm) {
		while(true) {
			System.out.println("*****To Access ATM Services verify yourself*****");
			System.out.println("Enter your Account Number:");
			int acNum=sc.nextInt();
			System.out.println("Enter your Account PIN:");
			int pin=sc.nextInt();
			
			boolean validCustomerFound=false;
			
			for(int i=0;i<customerCount;i++) {
				if(customer[i].getAccount().getAccountNumber()==acNum && customer[i].getAccount().getPin()==pin) {
					validCustomerFound=true;
					Main.atmServices(customer[i].getAccount(), customer[i], hdfc, atm);
					break;
				}
			}
			
			if(!validCustomerFound){
				System.out.println("***Enter VALID credentials***");
				System.out.println("If you want to verify again Press 1");
				System.out.println("If you want to EXIT Press 2");
				int input=sc.nextInt();
				if(input==2) {
					System.exit(0);
				}else if(input!=1) {
					throw new IllegalArgumentException("Unexpected value: " + input);
				}
			}else {
				break;
			}
		}
	}
	public static void atmServices(Account account, Customer customer, Bank hdfc, ATM atm) {
		System.out.println("********ATM Services***********");
		System.out.println();
		System.out.println("1. Customer Information");
		System.out.println("2. Balance Enquiry");
		System.out.println("3. Deposit Money");
		System.out.println("4. Withdraw Money");
		System.out.println("5. Logout");
		System.out.println("Enter your choice: ");
		int input=sc.nextInt();
		switch (input) {
		case 1: {
			Customer customer1=hdfc.getCustomer(account.getAccountNumber());
			System.out.println(customer1.getName());
			System.out.println(customer1.getAccount().getAccountNumber());
			Main.continuousServices(account, customer1, hdfc, atm);
			break;
		}
		case 2: {
			atm.checkBalance(account);
			Main.continuousServices(account, customer, hdfc, atm);
			break;
		}
		case 3: {
			System.out.println("Enter Amount to be deposited:");
			double amtInput=sc.nextDouble();
			atm.deposit(account, amtInput);
			System.out.println(amtInput+" Credited successfully");
			Main.continuousServices(account, customer, hdfc, atm);
			break;
		}
		case 4: {
			System.out.println("Enter Amount to be withdrawn");
			double amtInput=sc.nextDouble();
			atm.withdraw(account, amtInput);
			Main.continuousServices(account, customer, hdfc, atm);
			break;
		}
		case 5: {
			System.exit(0);
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + input);
		}
	}
	public static void continuousServices(Account account, Customer customer, Bank hdfc, ATM atm) {
		System.out.println("To go back to Main menu Press 1");
		System.out.println("To LOGOUT Press 2");
		int input=sc.nextInt();
		if(input==1) {
			Main.atmServices(account, customer, hdfc, atm);
		}else if(input==2) {
			System.exit(0);
		}else {
			throw new IllegalArgumentException("Unexpected value: " + input);
		}
	}
}
