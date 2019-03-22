package ie.gmit.sw;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UserWordToFile {

	static void takeInput(String userWord) {

		// take user input for word
		//Scanner sc = new Scanner(System.in);

		//System.out.println("Enter your word : ");
		//String userWord = sc.nextLine();


		// print the user word to a text file, this will be used by the python script to
		// look up the users word in the dictionary API
		BufferedWriter writer = null;
		try {
			
			//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			
			//writer = new BufferedWriter(new FileWriter("C:\\Users\\Thomas\\eclipse-workspace\\JSPCountdown\\Countdown\\src\\ie\\gmit\\sw\\output.txt"));
			
			writer = new BufferedWriter(new FileWriter("C:\\Data\\Skola\\GMIT\\Year 4\\Semester 1\\Applied Project and Minor Dissertation\\Project\\CountdownProject-Eclipse\\CountdownProject\\src\\ie\\gmit\\sw\\output.txt"));
			
			//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			
			writer.write(userWord);
		} catch (IOException e) {
			System.err.println(e);
			System.out.println("ErrorUserWord line 27");
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					System.err.println(e);
				}
			} // end if
		} // end finally

		// ** Move onto the next part **//
		//RunPythonScript.run();// run the python script to check the user word against the dictionary API
		//sc.close();
	}// end takeINput
}// end class userWord
