/*											THREAD GROUP DEFINITION										*/

package threadGroup;

public class MyThreadGroup implements Runnable{
	public void run() {
		System.out.println(Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//will print name of thread, while inside the ThreadGroup, and stay on for some time. Allows threads to stay awake till the list() method is called.
	}
}