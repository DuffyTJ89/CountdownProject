package ie.gmit.sw;

import java.util.HashSet;
import java.util.Set;

public class CompareWordToLetters {

	static String wordString = "";
	static String userGuessWordFinal = "";

	public static void listToString(String noListString) {

		wordString = noListString;
	}

	static int countRoundScore(String userGuessWord) {

		userGuessWord = userGuessWord.toUpperCase();

		// TODO print this line to the results page
		System.out.println("Your word ' " + userGuessWord + " ' uses  ");

		// source:
		// https://stackoverflow.com/questions/30662384/accept-2-strings-and-display-common-chars-in-them
		// check how many letter the user uses

		Set<Character> set1 = new HashSet<Character>();
		Set<Character> set2 = new HashSet<Character>();

		int roundScore = 0;

		for (char c : wordString.toCharArray()) {
			set1.add(c);
		}
		for (char c : userGuessWord.toCharArray()) {
			set2.add(c);
		}

		set1.retainAll(set2); // the letter that are the same

		for (char c : set1) {
			System.out.println(" " + c);

			switch (c) {
				case 'A':
					roundScore += 1;
					break;
				case 'B':
					roundScore += 3;
					break;
				case 'C':
					roundScore += 3;
					break;
				case 'D':
					roundScore += 2;
					break;
				case 'E':
					roundScore += 1;
					break;
				case 'F':
					roundScore += 4;
					break;
				case 'G':
					roundScore += 2;
					break;
				case 'H':
					roundScore += 4;
					break;
				case 'I':
					roundScore += 1;
					break;
				case 'J':
					roundScore += 8;
					break;
				case 'K':
					roundScore += 5;
					break;
				case 'L':
					roundScore += 1;
					break;
				case 'M':
					roundScore += 3;
					break;
				case 'N':
					roundScore += 1;
					break;
				case 'O':
					roundScore += 1;
					break;
				case 'P':
					roundScore += 3;
					break;
				case 'Q':
					roundScore += 10;
					break;
				case 'R':
					roundScore += 1;
					break;
				case 'S':
					roundScore += 1;
					break;
				case 'T':
					roundScore += 1;
					break;
				case 'U':
					roundScore += 1;
					break;
				case 'V':
					roundScore += 4;
					break;
				case 'W':
					roundScore += 4;
					break;
				case 'X':
					roundScore += 8;
					break;
				case 'Y':
					roundScore += 4;
					break;
				case 'Z':
					roundScore += 10;
					break;
			}

		}
		int lettersUsed = set1.size();

		// *************************//
		// add the user score up
		System.out.println("Total score for this round: " + roundScore);

		return roundScore;

	}

}
