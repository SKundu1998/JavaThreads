/*											THREADPOOL TEST PROGRAM										*/

package threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DriverThreadPool {
	public static void main(String[] args) {
		int threadcount = 5;
		ExecutorService executor = Executors.newFixedThreadPool(threadcount);
		for (int i = 0; i <(threadcount*threadcount); i++) {
			Runnable worker = new WorkerThread("" + i);
			executor.execute(worker);
		}
		executor.shutdown();
		while(!executor.isTerminated()) {
			try {
				System.out.println("Threads are running. Putting " + Thread.currentThread().getName() + " to sleep for 1.5s.");
				Thread.sleep(1500);
				// This puts the main execution thread to sleep, not the thread pool.
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Finished all threads");
	}
}
