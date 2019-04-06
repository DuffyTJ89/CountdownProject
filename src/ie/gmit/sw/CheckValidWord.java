package ie.gmit.sw;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CheckValidWord {

	static boolean check() {

		try {
			
			//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

			
			Scanner sc = new Scanner(new File(
					"C:\\Users\\Thomas\\Desktop\\MajoCountdown\\CountdownProject\\src\\ie\\gmit\\sw\\outputCode.txt"));
			
			
//			Scanner sc = new Scanner(new File(
//					"C:\\Data\\Skola\\GMIT\\Year 4\\Semester 1\\Applied Project and Minor Dissertation\\Project\\CountdownProject-Eclipse\\CountdownProject\\src\\ie\\gmit\\sw\\outputCode.txt"));
//			
			//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			
			System.out.println("in check");
			int statusCode = sc.nextInt();
			// s.close();

			if (statusCode == 200) {
			 System.out.println("Word is valid in check");
				

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
