package ie.gmit.sw;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CheckValidWord {

	static void check(int gameScore) {

		try {
			Scanner s = new Scanner(new File("C:\\Users\\Thomas\\Desktop\\NewCountdown\\ScrabbleProject\\src\\main\\java\\ie\\gmit\\sw\\Game\\outputCode.txt"));
			int statusCode = s.nextInt();
			//s.close();

			if (statusCode == 200) {
				System.out.println("Word is valid");
				
				Scanner sc = new Scanner(new File("C:\\Users\\Thomas\\Desktop\\NewCountdown\\ScrabbleProject\\src\\main\\java\\ie\\gmit\\sw\\Game\\output.txt"));
				String userWord = sc.nextLine();
				
				CompareWordToLetters.compare(userWord, gameScore); 
				
			} else {
				System.out.println("Invalid Word, you will be given a new set of letters now");
				// TODO return user to enter word again
				GenerateRandomLetters.list();
				//System.exit(0); //Don't let the user continue with an invalid word
			}

			s.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Can't find status code python file");
		}


	}// end check()

}// end CheckValidWord
