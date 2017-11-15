/*											THREAD GROUP DEFINITION										*/

package threadGroup;

public class MyThreadGroup implements Runnable{
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}
}