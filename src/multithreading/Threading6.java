/*												DAEMON THREAD										*/

package multithreading;

class DaemonThreadTest extends Thread {
	public void run() {
		if (Thread.currentThread().isDaemon()) {
			System.out.println(this.getName() + " is a daemon thread.");
		}
		else {
			System.out.println(this.getName() + " is a user thread.");
		}
	}
}

public class Threading6 {

	public static void main(String[] args) {
		
		Thread t1 = new DaemonThreadTest();
		Thread t2 = new DaemonThreadTest();
		Thread t3 = new DaemonThreadTest();
		
		t1.setDaemon(true);
		
		t1.start();
		t2.start();
		t3.start();
		
		//NOTE: If order of t1, t2, t3 and the order of daemon thread setting is changed, then an IllegalThreadStateException is thrown.
	}

}
