/*											USING THREADLOCAL VARIABLES										*/

package multithreading;

class MyThreadLocalRunnable implements Runnable {
	
	private ThreadLocal <Integer> threadLocal = new ThreadLocal <Integer> ();
	public void run() {
		System.out.println(Thread.currentThread().getName() + " created.");
		threadLocal.set((int)(Math.random()*1000));
		try {
			System.out.println(Thread.currentThread().getName() + " is going to sleep.");
			Thread.sleep(2000);
			System.out.println(Thread.currentThread().getName() + " has slept long enough.");
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(threadLocal.get() + ". Gift from " + Thread.currentThread().getName() + ". Happy now?");
	}
}

public class Threading5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThreadLocalRunnable sharedRunnableInstance = new MyThreadLocalRunnable();
		
		Thread threadA = new Thread(sharedRunnableInstance);
		Thread threadB = new Thread(sharedRunnableInstance);
		
		threadA.start();
		threadB.start();
		
		try { threadA.join(); }
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		try { threadB.join(); }
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
