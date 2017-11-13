/*										RACE CONDITIONS AND THREAD SAFETY									*/

package multithreading;

class NotThreadSafe{
    
	StringBuilder builder = new StringBuilder();

    public void add(String text){
        this.builder.append(text);
    }
}

class StillNotThreadSafe{
    
	StringBuilder builder = new StringBuilder();

    public void add(String text){
        this.builder.append(text);
        System.out.println(builder);
    }
}


class MyRunnable implements Runnable{
	  
	NotThreadSafe instance = null;
	
	public MyRunnable(NotThreadSafe instance){
		System.out.println("Thread " + Thread.currentThread().getName() + " constructed");
		this.instance = instance;
		System.out.println(Thread.currentThread().getName() + " has received instance.");
	}

	public void run(){
		this.instance.add("some text");
	    System.out.println(instance.builder);
	    System.out.println("Thread "+ Thread.currentThread().getName() +" concludes here.");
	}
}

class MyRunnable1 implements Runnable{
	  
	StillNotThreadSafe instance1 = null;
	
	public MyRunnable1(StillNotThreadSafe instance1){
		System.out.println("Thread " + Thread.currentThread().getName() + " constructed");
		this.instance1 = instance1;
		System.out.println(Thread.currentThread().getName() + " has received instance.");
	}

	public void run(){
		this.instance1.add("some text");
	    System.out.println("Thread "+ Thread.currentThread().getName() +" concludes here.");
	}
}

public class Threading3 {

	public static void main (String[] args) {
		NotThreadSafe sharedInstance = new NotThreadSafe();

		MyRunnable r1 = new MyRunnable(sharedInstance);
		MyRunnable r2 = new MyRunnable(sharedInstance);
		Thread threadA = new Thread(r1);
		Thread threadB = new Thread(r2);
		threadA.start();
		threadB.start();
		//new Thread(new MyRunnable(sharedInstance)).start();
		//new Thread(new MyRunnable(sharedInstance)).start();
		
		StillNotThreadSafe sharedInstance1 = new StillNotThreadSafe();
		
		Thread threadC = new Thread(new MyRunnable1(sharedInstance1));
		Thread threadD = new Thread(new MyRunnable1(sharedInstance1));
		threadC.start();
		threadD.start();
		//new Thread(new MyRunnable1(sharedinstance1)).start();
		//new Thread(new MyRunnable1(sharedinstance1)).start();
		
		//Spacing lines
		System.out.println("\n\n");
		//Safe version which creates separate instances follows:
		
		Thread threadE = new Thread(new MyRunnable(new NotThreadSafe()));
		threadE.start();
		Thread threadF = new Thread(new MyRunnable(new NotThreadSafe()));
		threadF.start();
		//new Thread(new MyRunnable(new NotThreadSafe())).start();
		//new Thread(new MyRunnable(new NotThreadSafe())).start();
		
		Thread threadG = new Thread(new MyRunnable1(new StillNotThreadSafe()));
		threadG.start();
		Thread threadH = new Thread(new MyRunnable1(new StillNotThreadSafe()));
		threadH.start();
		//new Thread(new MyRunnable1(new StillNotThreadSafe())).start();
		//new Thread(new MyRunnable1(new StillNotThreadSafe())).start();
	}
}
