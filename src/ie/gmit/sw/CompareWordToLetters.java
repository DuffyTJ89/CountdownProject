package ie.gmit.sw;

import java.util.HashSet;
import java.util.Set;

public class CompareWordToLetters {
	
	static String wordString="";
	
	public static void listToString(String noListString) {
		// TODO Auto-generated method stub
		
		wordString = noListString; 
		
	}
	
	static int compare(String userWord, int gameScore){
		
		userWord = userWord.toUpperCase();

		System.out.println("Your answer of ' " + userWord + " ' uses  ");

		// System.out.println("without list "+ noListString);

		// **************************//
		//source: https://stackoverflow.com/questions/30662384/accept-2-strings-and-display-common-chars-in-them
		// check how many letter the user uses

		Set<Character> set1 = new HashSet<Character>();
		Set<Character> set2 = new HashSet<Character>();

		int roundScore = 0;

		for (char c : wordString.toCharArray()) {
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

		//System.out.println("\nTotal number of used letters : " + set1.size());
		int lettersUsed = set1.size();

		// *************************//
		// add the user score up
		System.out.println("Total score for this round is : " + roundScore);
		
		//MainGame.gameScore += userScore; //update the overall game score with the round score
		
		RoundsAndScoring.updateUserGameScore(roundScore, gameScore);
		
		return lettersUsed;
		//System.out.println("Overall game score : " + MainGame.gameScore);

		//RoundLimit.checkRoundNum();//move to the next round
		
	}

	

}
