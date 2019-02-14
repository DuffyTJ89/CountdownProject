package ie.gmit.sw.Game;


public class Runner {

	static int roundNum = 0;
	static int gameScore = 0;

	public static void main(String[] args) {

		//Scanner sc = new Scanner(System.in);

		roundNum++;



		if(roundNum>5){
			System.out.println("Game over");
			System.out.println("After " + (roundNum -1)+ " rounds. Total Game Score " + gameScore);

			//TODO let the player play again
			// System.out.println("Play Again?");
			// System.out.println("Y/N");
		}
		else {

			System.out.println("Round " + roundNum+ " / 5");
			CreateGame.start();// start the game and display the 10 Random letters to the user
		}
	}

}
