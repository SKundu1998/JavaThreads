/*											SHUTDOWN HOOK EXPERIMENT 1									*/

package shutdownHook;

class MyThread extends Thread {
	public void run() {
		System.out.println("shutdown hook task completed.");
	}
}

public class Shutdown1 {

	public static void main(String[] args) throws Exception{
		Runtime r = Runtime.getRuntime();
		r.addShutdownHook(new MyThread());
		
		System.out.println("Now main thread is sleeping... press Ctrl+C to exit.");
		try {
			Thread.sleep(3000);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
