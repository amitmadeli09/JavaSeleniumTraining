package day4;

abstract class payments{
	double amount;
	
	payments(double amount){
		this.amount = amount;
	}
	abstract void makePayment();
	
	void showSuccessMessage() {
		System.out.println("Rs:"+amount+" Payment Successfull");
	}
}
//credit card payment 
class creditCardPayment extends payments{
	creditCardPayment(double amount){
		super(amount);
	}
	void makePayment() {
		System.out.println("Credit Card Payment Done Successfully");
	}
}
//UPI payment
class upiPayment extends payments{
	upiPayment(double amount){
		super(amount);
	}
	void makePayment() {
		System.out.println("UPI Payment Done Successfully");
	}
}
public class PaymentsUsingAbstraction {
	public static void main(String [] args) {
		payments p1 = new creditCardPayment(4000);
		p1.makePayment();
		p1.showSuccessMessage();
		System.out.println("Credit Card Payment Process is completed");
		
		payments p2 = new upiPayment(3000);
		p2.makePayment();
		p2.showSuccessMessage();
		System.out.println("UPI Payment Process is completed");
		
	}
}
