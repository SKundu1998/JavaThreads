/*									EXECUTING PROCESSES WITH RUNTIME CLASS								*/

package runtime;

import java.io.IOException;

public class Runtime1 {

	public static void main(String[] args) throws Exception {
		System.out.println("Opening notepad...");
		Thread.sleep(1000);
		Runtime.getRuntime().exec("notepad");
	}

}
