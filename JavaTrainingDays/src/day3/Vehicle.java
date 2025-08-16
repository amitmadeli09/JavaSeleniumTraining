package day3;

class Vehicle1 {

	void start() {
		System.out.println("Vehicle is started");
	}

}
class Car extends Vehicle1 {
	
	void drive() {
		System.out.println("Car is driving");
	}
	
}

public class Vehicle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car c = new Car();
		c.start();
		c.drive();

	}

}
