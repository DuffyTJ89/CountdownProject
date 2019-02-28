package ie.gmit.sw;

public class RoundLimit {
	
//	static int gameScore = 0;
//	static int roundNum = 0;

	
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
