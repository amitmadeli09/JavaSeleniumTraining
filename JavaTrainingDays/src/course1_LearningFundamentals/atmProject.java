package course1_LearningFundamentals;
import java.util.Scanner;


public class atmProject {
	private double balance;
	private Scanner scanner;
	
	public atmProject() {
		balance = 1000.0; //Initial Balance
		scanner = new Scanner(System.in);
	}
	public void displayMenu() {
		System.out.println("Welcome Amit ! How can we help you");
		System.out.println("1: Check Balance");
		System.out.println("2 : Deposit Money");
		System.out.println("3: Withdraw Money");
		System.out.println("4: Exit");
	}
	public void checkBalance() {
		System.out.println("Your Current balance is Rs."+balance);
	}
	public void deposit() {
		System.out.print("Enter an amount you want to deposit : Rs. ");
		double amount = scanner.nextDouble();
		
		if(amount >= 100) {
			balance += amount;
			System.out.println("You New Balance is :"+balance);
		}else if(amount <100 && amount >0){
			System.out.println("The minimum amount should be Rs.100");
		}
	}
	
	public void withdraw() {
		System.out.print("Enter an amount you want to withdraw :");
		double amount = scanner.nextDouble();
		
		if(balance < amount) {
			System.out.println("You New Balance is :"+balance);
		}else {
			balance -= amount;
			System.out.println("You New Balance is :"+balance);
		}
	}

	public static void main(String[] args) {
		atmProject atm = new atmProject();
		
		while(true) {
			atm.displayMenu();
			System.out.print("Enter your choice: ");
			int choice = atm.scanner.nextInt();
			
			switch(choice) {
			case 1:
				atm.checkBalance();
				break;
			case 2:
				atm.deposit();
				break;
			case 3:
				atm.withdraw();
				break;
			case 4:
				System.out.println("Thank you for using ATM, Good Bye !");
				System.exit(0);
			case 5:
				System.out.println("Please select a valid choice");
			}
			
		}
	
	}

}
