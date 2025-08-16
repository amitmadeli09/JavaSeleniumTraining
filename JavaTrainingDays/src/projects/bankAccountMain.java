package projects;

public class bankAccountMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		bankAccount b = new bankAccount("Amit",1000);
		b.deposit(500);
		b.displayDetails();
		b.withdraw(300);
		b.displayDetails();

	}

}
