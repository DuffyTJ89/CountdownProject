package ie.gmit.sw;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UserWordToFile {

	static void takeInput(String userWord) {
		// print the user word to a text file, this will be used by the python script to
		// look up the users word in the dictionary API
		BufferedWriter writer = null;
		try {

			// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

//			writer = new BufferedWriter(new FileWriter(
//					"C:\\Users\\Thomas\\Desktop\\MajoCountdown\\CountdownProject\\src\\ie\\gmit\\sw\\output.txt"));

			writer = new BufferedWriter(new FileWriter(
					"C:\\Data\\Skola\\GMIT\\Year 4\\Semester 1\\Applied Project and Minor Dissertation\\Project\\CountdownProject-Eclipse\\CountdownProject\\src\\main\\java\\ie\\gmit\\sw\\output.txt"));

			// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

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
	}// end takeINput
}// end class userWord
