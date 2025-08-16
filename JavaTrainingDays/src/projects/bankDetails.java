package projects;

class bankAccount{
	private String accountHolder;
	private double balance;
	
	public bankAccount(String accountHolder,double balance) {
		this.accountHolder = accountHolder;
		this.balance = balance;
	}
	public void deposit(double amount) {
		balance += amount;
		System.out.println("Amount Deposited :"+amount+"  New balance: "+balance);
	}
	public void withdraw(double amount) {
		if(amount > balance) {
			System.out.println("Insufficient Balance");
		}else {
			balance -= amount;
			System.out.println("Amount Withdrawn :"+amount+"  New balance: "+balance);
			
		}
	}
	public void displayDetails() {
		System.out.println("Account Holder Name :"+accountHolder+"  New balance: "+balance);
	}
}

public class bankDetails {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		bankAccount account = new bankAccount("Amit",1000);
		account.deposit(500);
		account.withdraw(300);
		account.displayDetails();	
	}
}
