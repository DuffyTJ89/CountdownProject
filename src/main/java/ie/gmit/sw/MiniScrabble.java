package ie.gmit.sw;

import java.util.*;

public class MiniScrabble {
	public static void main(String[] args) {

		//source : https://stackoverflow.com/questions/32043539/how-to-randomly-select-7-lettersa-to-z-in-java
		// create 10 random letters for the user to use
		String[] abArr = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
				"S", "T", "U", "V", "W", "X", "Y", "Z" };
		List<String> abList = Arrays.asList(abArr);
		Collections.shuffle(abList);

		List<String> randLetters = abList.subList(0, 10);
		String noListString = String.join("", randLetters); // change from list to normal string to compare

		System.out.println("Here are your random letters : " + randLetters);

		// ****************************//
		// take user input for word
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter your word : ");
		String userWord = sc.nextLine();
		sc.close();
		
		//****************//
		//Check if valid word
		userWord = userWord.toLowerCase();
		System.out.println(userWord);
		
		
		//https://stackoverflow.com/questions/453607/best-spell-checking-api-for-java
		
		//continue if valid
		userWord = userWord.toUpperCase();

		System.out.println("Your answer of ' " + userWord + " ' uses  ");

		// System.out.println("without list "+ noListString);

		// **************************//
		//source: https://stackoverflow.com/questions/30662384/accept-2-strings-and-display-common-chars-in-them
		// check how many letter the user uses

		Set<Character> set1 = new HashSet<Character>();
		Set<Character> set2 = new HashSet<Character>();

		int userScore = 0;

		for (char c : noListString.toCharArray()) {
			set1.add(c);
		}
		for (char c : userWord.toCharArray()) {
			set2.add(c);
		}

		set1.retainAll(set2); // the letter that are the same

		for (char c : set1) {
			System.out.println(" " + c);

			switch (c) {
			case 'A':
				userScore += 1;
				break;
			case 'B':
				userScore += 3;
				break;
			case 'C':
				userScore += 3;
				break;
			case 'D':
				userScore += 2;
				break;
			case 'E':
				userScore += 1;
				break;
			case 'F':
				userScore += 4;
				break;
			case 'G':
				userScore += 2;
				break;
			case 'H':
				userScore += 4;
				break;
			case 'I':
				userScore += 1;
				break;
			case 'J':
				userScore += 8;
				break;
			case 'K':
				userScore += 5;
				break;
			case 'L':
				userScore += 1;
				break;
			case 'M':
				userScore += 3;
				break;
			case 'N':
				userScore += 1;
				break;
			case 'O':
				userScore += 1;
				break;
			case 'P':
				userScore += 3;
				break;
			case 'Q':
				userScore += 10;
				break;
			case 'R':
				userScore += 1;
				break;
			case 'S':
				userScore += 1;
				break;
			case 'T':
				userScore += 1;
				break;
			case 'U':
				userScore += 1;
				break;
			case 'V':
				userScore += 4;
				break;
			case 'W':
				userScore += 4;
				break;
			case 'X':
				userScore += 8;
				break;
			case 'Y':
				userScore += 4;
				break;
			case 'Z':
				userScore += 10;
				break;

			}

		}

		System.out.println("\nTotal number of used letters : " + set1.size());

		// *************************//
		// add the user score up
		System.out.println("Total score is : " + userScore);

	}// end main

}// end class
