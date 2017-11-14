/*									RUNNABLE FOR USE IN THREADPOOL									*/

package threadPool;

public class WorkerThread implements Runnable{
	private String message;
	public WorkerThread(String s) {
		this.message = s;
	}
	private void processmessage() {
		try {
			Thread.sleep(2000);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void run() {
		System.out.println(Thread.currentThread().getName() + "(Start) message = " + this.message);
		processmessage();
		System.out.println(Thread.currentThread().getName() + " (End)");
	}
}
