package ie.gmit.sw;

import java.io.IOException;

public class RunPythonScript {

	static int run() {

		System.out.println("Checking if word is valid...");

		// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

		String command = "C:\\Users\\Thomas\\Desktop\\MajoCountdown\\CountdownProject\\src\\ie\\gmit\\sw\\";

//		String command = "C:\\Data\\Skola\\GMIT\\Year 4\\Semester 1\\Applied Project and Minor Dissertation\\Project\\CountdownProject-Eclipse\\CountdownProject\\src\\ie\\gmit\\sw\\";

		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

		String pyName = "DictionaryAPI.py";
		try {

			Runtime.getRuntime().exec("python " + command + pyName); // command to run the script
			System.out.println("Script Run");

			try // make the java code wait so that the python script has time to run
			{
				System.out.println("in sleep");
				Thread.sleep(5000);
				// response = ("Waiting for Oxford dictionary result...");
				return 1;
				// return response;
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} // end catch
		return 0;
	}// end run()
}// end class RunPythonScript
