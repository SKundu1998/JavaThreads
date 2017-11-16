/*									SHUTDOWN HOOK THROUGH ANONYMOUS CLASS								*/

package shutdownHook;

public class Shutdown2 {

	public static void main(String[] args) throws InterruptedException {
		Runtime r = Runtime.getRuntime();
		r.addShutdownHook(new Thread() {
			public void run() {
				System.out.println("shut down hook task completed.");
			}
		});
		// Used anonymous class here.
		System.out.println("Main thread now sleeping... Press Ctrl+C to exit.");
		Thread.sleep(3000);
	}

}
