package ie.gmit.sw;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class UserWordToFile {

	static void takeInput(String userWord) {
		// print the user word to a text file, this will be used by the python script to
		// look up the users word in the dictionary API
		BufferedWriter writer = null;
		try {

			// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

			writer = new BufferedWriter(new FileWriter(
					"C:\\Users\\Thomas\\Desktop\\CountdownProject\\src\\main\\java\\ie\\gmit\\sw\\output.txt"));

//			writer = new BufferedWriter(new FileWriter("C:\\Data\\CountdownProject\\src\\main\\java\\ie\\gmit\\sw\\output.txt"));

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
