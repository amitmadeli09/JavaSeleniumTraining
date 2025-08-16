package day5;

interface SystemDetails{
	void system();
	void speed();
}

class Desktop implements SystemDetails{
	public void system() {
		System.out.print("Desktop: ");
	}
	public void speed() {
		System.out.println("The code is Faster");
	}
}

class Laptop implements SystemDetails{
	public void system() {
		System.out.print("Laptop: ");
	}
	public void speed() {
		System.out.println("The Code is little slower");
	}
}

public class WiproDeviceInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SystemDetails system1 = new Desktop();
		system1.system();
		system1.speed();
		
		SystemDetails system2 = new Laptop();
		system2.system();
		system2.speed();
	}

}
