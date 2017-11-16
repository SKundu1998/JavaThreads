package garbageCollection;

public class TestGarbage {

	public static void main(String[] args) {
		Garbage g1 = new Garbage(18);
		System.out.println(g1.getStorage());
		Garbage g2 = new Garbage(22);
		System.out.println(g2.getStorage());
		g1 = null;
		g2 = null;
		System.gc(); //Calls garbage collector on entire thread.
	}

}
