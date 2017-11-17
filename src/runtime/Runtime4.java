package runtime;

class MemoryFiller extends Thread{
	private int stored;
	MemoryFiller(int stored) {
		this.stored = stored;
	}
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class Runtime4 {
	
	public static void main(String[] args) {
		
		Runtime r=Runtime.getRuntime();  
		System.out.println("Total Memory: "+r.totalMemory());  
		System.out.println("Free Memory: "+r.freeMemory());  
		MemoryFiller m1[] = new MemoryFiller[10000];
		
		for (int i = 0; i < 10000; i++) {
			m1[i] = new MemoryFiller(i);
			m1[i].start();
		}
		
		System.out.println("After creating 10000 instance, Free Memory: "+r.freeMemory());

		System.gc();
		System.out.println("After gc(), Free Memory: "+r.freeMemory());
	}

}

//As this example shows, free memory changes drastically with usage patterns.
