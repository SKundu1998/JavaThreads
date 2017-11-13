/*												INTRO TO THREADS											*/


package multithreading;

class Thread_A extends Thread{
	public void run() {
		System.out.println("This is me, " + Thread.currentThread().getName() + ", running in a thread class extension.");
	}
}

class Thread_B implements Runnable {
	public void run() {
		System.out.println("This is me, " + Thread.currentThread().getName() +", running in an implementation of Runnable.");
	}
}
public class Threading1 {


	public static void main(String[] args) {
		Thread myThread0 = new Thread();
		Thread myThread1 = new Thread_A();
		Thread myThread2 = new Thread(new Thread_B());
		System.out.println("The names of the threads are "+ myThread0.getName() + ", " +myThread1.getName()+ " and " + myThread2.getName());
		//This instance of the default thread ends immediately, without doing anything.
		myThread0.start();
		//This instance of Thread_A, an extension of Thread, displays a message.
		myThread1.start();
		//This instance of Thread_B, an implementation of Runnable, displays a different message.
		myThread2.start();
		Thread myThread3 = new Thread() {
			public void run() {
				System.out.println("Slight addition. This is me, " + Thread.currentThread().getName() + ", running in an anonymous class extension.");
			}
		};
		myThread3.start();
		
	}

}
