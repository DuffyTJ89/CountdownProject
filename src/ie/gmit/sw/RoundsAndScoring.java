package ie.gmit.sw;

public class RoundsAndScoring {

	static int setUserRoundNum() {

		int roundNum = 0;
		
		System.out.println("Round should be 0 : " + roundNum);

		return roundNum;
	}

	static int setUserGameScore() {

		int gameScore = 0;

		return gameScore;
	}
	
	static int updateUserRoundNum(int roundNum) {

		roundNum++;
		
		System.out.println("Round shoule be 1 :" + roundNum);

		return roundNum;
	}

	static int updateUserGameScore(int roundScore, int gameScore) {

		gameScore = roundScore + gameScore;

		return gameScore;
	}
	

	static boolean checkRoundNumLess5(int roundNum) {

		roundNum++;

		if (roundNum < 5) {
//			System.out.println("Game over");
//			System.out.println("After " + (roundNum - 1) + " rounds. Total Game Score " + gameScore);
//			
//			String res = ("Game over \n" + "After " + (roundNum - 1) + " rounds. Total Game Score " + gameScore);

			return true;

			// TODO let the player play again
			// System.out.println("Play Again?");
			// System.out.println("Y/N");
		} // end if
		else {

//			System.out.println("Round " + roundNum + " / 5");
//			String res = ("Round " + roundNum + " / 5");
//			CreateGame.start();// start the game and display the 10 Random letters to the user

			return false;
		} // end else

	}

}