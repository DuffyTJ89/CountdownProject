package ie.gmit.sw.Game;

//import java.util.Scanner;

import ch.qos.logback.core.net.SyslogOutputStream;

public class Runner {

	static int roundNum = 0;
	static int gameScore = 0;

	public static void main(String[] args) {

		//Scanner sc = new Scanner(System.in);

		roundNum++;



		if(roundNum>=5){
			System.out.println("Game over");
			System.out.println("Total Game Score " + gameScore);
		}
		else {

			System.out.println("Round " + roundNum + " / 5");
			CreateGame.start();// start the game and display the 10 Random letters to the user

			// System.out.println("Play Again?");
			// System.out.println("Y/N");
		}
	}

}
