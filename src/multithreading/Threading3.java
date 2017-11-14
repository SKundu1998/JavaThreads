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


class MyThread extends Thread{
	  
	NotThreadSafe instance = null;
	
	public MyThread(NotThreadSafe instance){
		System.out.println("Thread " + this.getName() + " constructed");
		this.instance = instance;
		System.out.println(this.getName() + " has received instance.");
	}

	public void run(){
		this.instance.add("some text");
	    System.out.println(instance.builder);
	    System.out.println("Thread "+ this.getName() +" concludes here.");
	}
}

class MyThread1 extends Thread{
	  
	StillNotThreadSafe instance1 = null;
	
	public MyThread1(StillNotThreadSafe instance1){
		System.out.println("Thread " + this.getName() + " constructed");
		this.instance1 = instance1;
		System.out.println(this.getName() + " has received instance.");
	}

	public void run(){
		this.instance1.add("some text");
	    System.out.println("Thread "+ this.getName() +" concludes here.");
	}
}

public class Threading3 {

	public static void main (String[] args) {
		
		NotThreadSafe sharedInstance = new NotThreadSafe();

		Thread threadA = new MyThread(sharedInstance);
		Thread threadB = new MyThread(sharedInstance);
		threadA.start();
		threadB.start();
		//new Thread(new MyRunnable(sharedInstance)).start();
		//new Thread(new MyRunnable(sharedInstance)).start();
		
		StillNotThreadSafe sharedInstance1 = new StillNotThreadSafe();
		
		Thread threadC = new MyThread1(sharedInstance1);
		Thread threadD = new MyThread1(sharedInstance1);
		threadC.start();
		threadD.start();
		//new Thread(new MyRunnable1(sharedinstance1)).start();
		//new Thread(new MyRunnable1(sharedinstance1)).start();
		
		//Spacing lines
		System.out.println("\n\n");
		//Safe version which creates separate instances follows:
		
		Thread threadE = new MyThread(new NotThreadSafe());
		threadE.start();
		Thread threadF = new MyThread(new NotThreadSafe());
		threadF.start();
		//new Thread(new MyRunnable(new NotThreadSafe())).start();
		//new Thread(new MyRunnable(new NotThreadSafe())).start();
		
		Thread threadG = new MyThread1(new StillNotThreadSafe());
		threadG.start();
		Thread threadH = new MyThread1(new StillNotThreadSafe());
		threadH.start();
		//new Thread(new MyRunnable1(new StillNotThreadSafe())).start();
		//new Thread(new MyRunnable1(new StillNotThreadSafe())).start();
		
		//Changing from Runnable to Thread extension allows for getting the name of the thread.
	}
}
