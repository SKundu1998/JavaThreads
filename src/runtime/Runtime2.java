/*									SHUTDOWN/RESTART SYSTEM WITH RUNTIME CLASS							*/

package runtime;

import java.io.IOException;
import java.util.Scanner;

public class Runtime2 {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Type -s for shutdown and -r for restart.");
		System.out.println("Then, after a space, type -t and add the delay time. Use 0 if no delay is needed.");
		System.out.println("For instance, to restart after 10s, use this:");
		System.out.println("-r -t 10");
		boolean exitFlag = false;
		Scanner in = new Scanner(System.in);
		while (!exitFlag) {
			String commandInput = in.nextLine();
			if (commandInput.equals("")) {
				commandInput = null;
				System.out.println("Wrong input.");
			}
			else if(commandInput.length() < 6 && !commandInput.substring(0, 1).equals("q")) {
				commandInput = null;
				System.out.println("Wrong input.");
			}
			else if (commandInput.substring(0, 1).equals("q")) {
				System.out.println("Closing program...");
				Thread.sleep(1000);
				exitFlag = true;
			}
			else if (commandInput.substring(0,6).equals("-r -t ") || commandInput.substring(0,5).equals("-s -t ")){
				try {
					int timeDelay = Integer.parseInt(commandInput.substring(7));
					try {
						Runtime.getRuntime().exec("C:\\Windows\\System32\\shutdown " + commandInput);
					}
					catch (IOException e) {
						System.out.println("Error in executing command.");
						e.printStackTrace();
					}
				}
				catch (NumberFormatException e) {
					System.out.println("Enter a proper delay.");
				}

			}
			else {
				commandInput = null;
				System.out.println("Wrong input.");
			}
		}
		in.close();
	}

}
