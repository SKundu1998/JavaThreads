/*										   DRIVER CLASS FOR THREADGROUP								  	  */

package threadGroup;

public class DriverThreadGroup {

	public static void main(String[] args) {
		MyThreadGroup runnable = new MyThreadGroup();
		
		ThreadGroup tg1 = new ThreadGroup("Parent Threadgroup");
		
		Thread t1 = new Thread(tg1, runnable, "one");
		t1.start();
		Thread t2 = new Thread(tg1, runnable, "two");
		t2.start();
		Thread t3 = new Thread(tg1, runnable, "three");
		t3.start();
		
		System.out.println("ThreadGroupName: " + tg1.getName());
		
		tg1.list();
		//This command lists all info relevant to the ThreadGroup instance tg1.
		//NOTE: as execution order keeps changing, so does output of tg1.list() method.
	}

}
