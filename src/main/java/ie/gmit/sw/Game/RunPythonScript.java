package ie.gmit.sw.Game;

import java.io.IOException;

public class RunPythonScript {

	static void run() {

		//path: C:\Users\Thomas\Desktop\NewCountdown\ScrabbleProject\src\main\java\ie\gmit\sw\Game\DictionaryAPI.py
		String command = "C:\\Users\\Thomas\\Desktop\\NewCountdown\\ScrabbleProject\\src\\main\\java\\ie\\gmit\\sw\\Game\\";
		String pyName = "DictionaryAPI";
		try {

			Runtime.getRuntime().exec("python " + command + pyName + ".py"); // command to run the script
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("Can't run python script to check word");
		} // end catch

		// ** Move onto the next part ** //
		CheckValidWord.check(); // check the response from the python script to see if it is valid or not
	}// end run()

}// end class RunPythonScript
