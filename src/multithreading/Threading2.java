/*										A LOOK AT NESTED THREAD EXECUTION									*/

package multithreading;

class Count extends Thread {
	Count() {
		super("counter thread extension");
		System.out.println("this thread is " + this.getName());
		start();
	}
	public void run() {
		try {
			for (int i=0; i<10; i++) {
				System.out.println("Printing the count " + i);
				Thread.sleep(1000);
			}
		}
		catch (InterruptedException e) {
			System.out.println("An error occurred with the thread. Data below.");
			e.printStackTrace();
		}
		System.out.println("The thread " + this.getName() +" has completed.");
	}
}

public class Threading2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Count cnt = new Count();
		try {
			int j = 1;
			while (cnt.isAlive()) {
				System.out.println("Thread " + Thread.currentThread().getName() + " is running. Will check back after 1.5s");
				Thread.sleep(1500);
				System.out.println("Done sleeping. Slept " + j++ + " times.");
			}
		}
		catch (InterruptedException e) {
			System.out.println("An error occurred with this thread. Data coming up.");
			e.printStackTrace();
		}
		System.out.println("The thread " + Thread.currentThread().getName() + " has completed.");
	}

}
