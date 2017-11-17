/*									FINDING THE NUMBER OF AVAILABLE PROCESSORS							*/

package runtime;

class MyThread extends Thread {
	private int input;
	MyThread(int input) {
		this.input = input;
	}
	public void setInputTo(int input) {
		this.input = input;
	}
	public void run() {
		while (this.input!=0) {
			System.out.println("Process running...");
			System.out.println(Runtime.getRuntime().availableProcessors());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

public class Runtime3 {
	public static void main(String[] args) throws InterruptedException {
		System.out.println(Runtime.getRuntime().availableProcessors());
		MyThread t1 = new MyThread(13);
		t1.start();
		MyThread t2 = new MyThread(33);
		t2.start();
		Thread.sleep(10000);
		t1.setInputTo(0);
		t2.setInputTo(0);
		System.gc();
		System.out.println(Runtime.getRuntime().availableProcessors());
	}
}

//As output shows, number of processors available = no of threads processor can run simultaneously.
