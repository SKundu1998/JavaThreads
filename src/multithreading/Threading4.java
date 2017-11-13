/*											USING SYNCHRONIZED METHODS/BLOCKS										*/

package multithreading;

class Counter {
	long count = 0;
	public synchronized void add(long value) {
		this.count += value;
	}
}

class CounterThread extends Thread {
	Counter counter = null;
	public CounterThread(Counter counter) {
		this.counter = counter;
	}
	public void run() {
		for (int i=0; i<10; i++) {
			counter.add(i);
			System.out.println(i + " operations done. Counter at " + this.counter.count + ". This is " + Thread.currentThread().getName() +".");
		}
		System.out.println(this.counter.count);
	}
}

public class Threading4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Counter counter = new Counter();
		Thread threadA = new CounterThread(counter);
		Thread threadB = new CounterThread(counter);
		threadA.start();
		threadB.start();
	}

}

//Notice that the output has threads running in parallel. Including a line to print out the final counter value fucks up this alternation since it gets printed first of all, instead of last.