package day8;

class A extends Thread{
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("Morning");
			try {
				Thread.sleep(10);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
class B extends Thread {
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("Night");
			try {
				Thread.sleep(10);
			}catch(InterruptedException e) {
				e.printStackTrace();
				}	
		}
	}
}

public class MultiThreadingExtend {

	public static void main(String[] args) {
		
		A obj1 = new A();
		B obj2 = new B();
		
//		System.out.println(obj1.getPriority());
//		obj1.setPriority(Thread.MAX_PRIORITY);
		
		obj1.start();
		try {
			Thread.sleep(5);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		obj2.start();

	}

}
