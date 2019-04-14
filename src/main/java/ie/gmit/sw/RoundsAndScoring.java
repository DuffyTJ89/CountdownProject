package ie.gmit.sw;

public class RoundsAndScoring {

	static int cScore;

	static int setUserRoundNum() {
		int roundNum = 0;
		return roundNum;
	}

	static int setUserGameScore() {
		int gameScore = 0;
		return gameScore;
	}

	static int updateUserRoundNum(int roundNum) {
		roundNum++;
		return roundNum;
	}

	static int updateUserGameScore(int roundScore, int gameScore) {

		cScore = roundScore + gameScore;

		return cScore;
	}

	static boolean checkRoundNumLess5(int roundNum) {

		return roundNum <= 5;
	}
}
