//source : https://stackoverflow.com/questions/32043539/how-to-randomly-select-7-lettersa-to-z-in-java
package ie.gmit.sw;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GenerateRandomLetters {

	static List<String> list() {
		// create 10 random letters for the user to use
		String[] alphabetArr = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
				"S", "T", "U", "V", "W", "X", "Y", "Z" };
		List<String> alphabetList = Arrays.asList(alphabetArr);
		Collections.shuffle(alphabetList);

		List<String> randLetters = alphabetList.subList(0, 10);

		String noListString = String.join("", randLetters); // change from list to normal string to compare

		CompareWordToLetters.listToString(noListString);

		System.out.println("Here are your random letters : " + randLetters);

		return randLetters;

	}
}
