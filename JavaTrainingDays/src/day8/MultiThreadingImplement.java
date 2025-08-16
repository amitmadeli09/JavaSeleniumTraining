package day8;

class Multi1 implements Runnable{
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
class Multi2 implements Runnable {
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

public class MultiThreadingImplement {

	public static void main(String[] args) {
		
		Runnable obj1 = new Multi1();
		Runnable obj2 = new Multi2();
		
//		System.out.println(obj1.getPriority());
//		obj1.setPriority(Thread.MAX_PRIORITY);
		
		Thread t1 = new Thread(obj1);
		Thread t2 = new Thread(obj2);
		
		t1.start();
		
		t2.start();


	}

}
