package day4;

//multiple inheritance using interfaces
interface ecommercePayments{
	void makePayment();
}
//abstract class giving the common features
abstract class paymentSystems implements ecommercePayments{
	double amount;
	paymentSystems(double amount){
		this.amount = amount;
	}
	void showSuccessMessage() {
		System.out.println("Payment is Successfull "+amount);
	}
}
//its using multiple inheritance from abstract class
//for debit card
class debitCardPayment extends paymentSystems{
	debitCardPayment(double amount){
		super(amount);
	}
	public void makePayment() {
		System.out.println("Debit card Payment Done");
		showSuccessMessage();
	}
}
//for netbanking
class netBankingPayment extends paymentSystems{
	netBankingPayment(double amount){
		super(amount);
	}
	public void makePayment() {
		System.out.println("Net Banking Payment Done");
		showSuccessMessage();
	}
}
public class PaymentsUsingInterfaces {

	public static void main(String[] args) {
		
		paymentSystems p1 = new debitCardPayment(30000);
		p1.makePayment();
		
		System.out.println();
		
		paymentSystems p2 = new netBankingPayment(55000);
		p2.makePayment();

	}

}