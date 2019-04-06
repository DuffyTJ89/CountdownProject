package ie.gmit.sw;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GenerateRandomLetters {

	static List<String> list() {

		// source :
		// https://stackoverflow.com/questions/32043539/how-to-randomly-select-7-lettersa-to-z-in-java
		// create 10 random letters for the user to use
		String[] abArr = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
				"S", "T", "U", "V", "W", "X", "Y", "Z" };
		List<String> abList = Arrays.asList(abArr);
		Collections.shuffle(abList);

		List<String> randLetters = abList.subList(0, 10);

		String noListString = String.join("", randLetters); // change from list to normal string to compare

		CompareWordToLetters.listToString(noListString);

		System.out.println("Here are your random letters : " + randLetters);
		
		

		// ** Move onto the next part **//
		//UserWord.takeInput(); // take the user submitted word into a variable for use
		return randLetters;

		// ** Add for later if reached **//

		// return noListString;

	}
}
