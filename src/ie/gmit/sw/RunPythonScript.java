package ie.gmit.sw;

import java.io.IOException;

public class RunPythonScript {

	static boolean run() {

        System.out.println("Checking if word is valid...");
        
        boolean response = false;

		//path: C:\Users\Thomas\Desktop\NewCountdown\ScrabbleProject\src\main\java\ie\gmit\sw\Game\DictionaryAPI.py
		String command = "C:\\Users\\Thomas\\eclipse-workspace\\JSPCountdown\\Countdown\\src\\ie\\gmit\\sw\\";
		String pyName = "DictionaryAPI";
		try {

			Runtime.getRuntime().exec("python " + command + pyName + ".py"); // command to run the script
			System.out.println("Script Run");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			response = false;
			//return response;
		} // end catch

		// ** Move onto the next part ** //

        try //make the java code wait so that the python script has time to run
        {
            Thread.sleep(5000);
            //response = ("Waiting for Oxford dictionary result...");
            response = true;
            //return response;
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
        
        return response;
		//CheckValidWord.check(); // check the response from the python script to see if it is valid or not
	}// end run()

}// end class RunPythonScript
