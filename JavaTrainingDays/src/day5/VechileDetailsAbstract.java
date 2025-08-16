package day5;

abstract class Vechile {
	abstract void speed();
	abstract void brand();
}

class Bike extends Vechile{
	void speed() {
		System.out.println("The speed is 80 km/hr");
	}
	void brand() {
		System.out.println("Brand : Kawasaki");
	}
}
class Car extends Vechile{
	void speed() {
		System.out.println("The speed is 100 km/hr");
	}
	void brand() {
		System.out.println("Brand : Audi");
	}
}

public class VechileDetailsAbstract{
	public static void main(String[] args) {
		Vechile bike1 = new Bike();
		bike1.speed();
		bike1.brand();
		
		Vechile car1 = new Car();
		car1.speed();
		car1.brand();
	}
}