package ie.gmit.sw;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CheckValidWord {

	static boolean check() {

		try {
			Scanner s = new Scanner(new File(
					"C:\\Users\\Thomas\\eclipse-workspace\\JSPCountdown\\Countdown\\src\\ie\\gmit\\sw\\outputCode.txt"));
			int statusCode = s.nextInt();
			// s.close();

			if (statusCode == 200) {
				// System.out.println("Word is valid");

				return true;

				

			} else {
				System.out.println("Invalid Word, you will be given a new set of letters now");
				// TODO return user to enter word again

				return false;
				// System.exit(0); //Don't let the user continue with an invalid word
			}

			// s.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Can't find status code python file");
		}
		return false;

	}// end check()

}// end CheckValidWord
