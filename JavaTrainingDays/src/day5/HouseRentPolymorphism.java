package day5;

class Rent{
	int rent;
	int expense;
	double electricity;
	
	//function overloading, compile time polymorphism
	//overload 1
	public void rentMoney(int rent,int expense) {
		this.rent = rent;
		this.expense = expense;
		int total = rent + expense;
		System.out.println("The Expenditure of Rent & Expense :Rs."+total);
	}
	//overload 2
	public int totalExpenditure(int rent,int expense,int electricity) {
		this.rent = rent;
		this.expense = expense;
		this.electricity = electricity;
		int total =(int) rent + expense + electricity;
		return total;
	}
	//overload 3
	public void rentMoney(int rent,double electricity) {
		this.rent = rent;
		this.electricity = electricity;
		int total = (int) electricity + rent;
		System.out.println("The Expenditure of Rent & Electricty: Rs."+total);
	}
}
public class HouseRentPolymorphism {

	public static void main(String[] args) {
		//created a object
		Rent house = new Rent();
		house.rentMoney(5000, 2000);//test overload 1
		house.rentMoney(5000, 1000.0); //test overload 3
		System.out.println("The Total Expenditure(Rent,Electricity & Expense): Rs."+house.totalExpenditure(5000, 2000, 1000));//test overload 2
		
	}
}
