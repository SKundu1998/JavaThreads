package garbageCollection;

public class Garbage {
	private int storage;
	Garbage(Integer storage) {
		this.storage = storage;
	}
	public int getStorage() {
		return this.storage;
	}
	public void finalize() {
		System.out.println("Object is garbage collected.");
	}
}
