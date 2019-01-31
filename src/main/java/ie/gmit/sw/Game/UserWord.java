package ie.gmit.sw.Game;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UserWord {

	static void takeInput() {

		// take user input for word
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter your word : ");
		String userWord = sc.nextLine();


		// print the user word to a text file, this will be used by the python script to
		// look up the users word in the dictionary API
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter("C:\\Users\\Thomas\\Desktop\\NewCountdown\\ScrabbleProject\\src\\main\\java\\ie\\gmit\\sw\\Game\\output.txt"));
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
		RunPythonScript.run();// run the python script to check the user word against the dictionary API
		sc.close();
	}// end takeINput
}// end class userWord
