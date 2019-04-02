package ie.gmit.sw;

import java.io.IOException;

public class RunPythonScript {

	static int run() {

		System.out.println("Checking if word is valid...");

		// boolean response = true;

		// path:
		// C:\Users\Thomas\Desktop\NewCountdown\ScrabbleProject\src\main\java\ie\gmit\sw\Game\DictionaryAPI.py

		// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

		// String command =
		// "C:\\Users\\Thomas\\eclipse-workspace\\JSPCountdown\\Countdown\\src\\ie\\gmit\\sw\\";

		String command = "C:\\Data\\Skola\\GMIT\\Year 4\\Semester 1\\Applied Project and Minor Dissertation\\Project\\CountdownProject-Eclipse\\CountdownProject\\src\\ie\\gmit\\sw\\";

		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

		String pyName = "DictionaryAPI";
		try {

			Runtime.getRuntime().exec("python " + command + pyName + ".py"); // command to run the script
			System.out.println("Script Run");

			try // make the java code wait so that the python script has time to run
			{
				Thread.sleep(5000);
				// response = ("Waiting for Oxford dictionary result...");
				System.out.println("in sleep");
				return 1;
				// return response;
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
			}

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();

			// return response;
		} // end catch

		// ** Move onto the next part ** //

		return 0;
		// CheckValidWord.check(); // check the response from the python script to see
		// if it is valid or not
	}// end run()

}// end class RunPythonScript
