/*										USING A SYNCHRONIZE BLOCK									*/

package synchronize;

class SharedObject{
	public void display(String msg) {
		System.out.print("[ " + msg);
		try {
			Thread.sleep(1000);
			//changing the time leads to interesting results.
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.print(" ]\n");
	}
}

class ObjectThread extends Thread {
	String msg;
	SharedObject obj;
	ObjectThread(SharedObject object, String message) {
		this.msg = message;
		this.obj = object;
		start();
		//NOTE: start() can only be used inside class definition when the class extends thread.
	}
	public void run() {
		this.obj.display(msg);		
	}
}

class ObjectThreadSynchronized extends Thread {
	String msg;
	SharedObject obj;
	ObjectThreadSynchronized(SharedObject object, String message) {
		this.msg = message;
		this.obj = object;
		start();
		//NOTE: start() can only be used inside class definition when the class extends thread.
	}
	public void run() {
		synchronized(this.obj) {
			this.obj.display(msg);		
		}
	}
}

public class Synchronize1 {

	public static void main(String[] args) throws InterruptedException {
		SharedObject obj = new SharedObject();
		ObjectThread threadA = new ObjectThread(obj, "Welcome");
		ObjectThread threadB = new ObjectThread(obj, "to");
		ObjectThread threadC = new ObjectThread(obj, "multithreaded");
		ObjectThread threadD = new ObjectThread(obj, "programming,");
		ObjectThread threadE = new ObjectThread(obj, "Rafa.");
		threadA.join();
		threadB.join();
		threadC.join();
		threadD.join();
		threadE.join();
		//note that threads start at different times and thus have strange ordering.
		SharedObject objSynch = new SharedObject();
		ObjectThreadSynchronized threadASynch = new ObjectThreadSynchronized(objSynch, "Welcome");
		threadASynch.join();
		ObjectThreadSynchronized threadBSynch = new ObjectThreadSynchronized(objSynch, "to");
		threadBSynch.join();
		ObjectThreadSynchronized threadCSynch = new ObjectThreadSynchronized(objSynch, "multithreaded");
		threadCSynch.join();
		ObjectThreadSynchronized threadDSynch = new ObjectThreadSynchronized(objSynch, "programming,");
		threadDSynch.join();		
		ObjectThreadSynchronized threadESynch = new ObjectThreadSynchronized(objSynch, "Rafa.");
		threadESynch.join();
		//again, each block is printed just fine, but the blocks are not necessarily in order.
		//using join after each thread initiates, instead of after the block, gives us correct ordering. This also fixes the ordering in the first case, but offers less control.
	}

}
