//Resources:
// https://www.codejava.net/coding/java-servlet-and-jsp-hello-world-tutorial-with-eclipse-maven-and-apache-tomcat
package ie.gmit.sw;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SetUpGame")
public class SetUpGame extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// static String roundNumString = "";
	boolean ChechkedRoundNum;

	public SetUpGame() {
		super();
	}// end NewGam()

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("userName");
	
		int roundNum = RoundsAndScoring.setUserRoundNum();// Initialize the user's round number to zero
		int gameScore = RoundsAndScoring.setUserGameScore();

		roundNum = RoundsAndScoring.updateUserRoundNum(roundNum);
		ChechkedRoundNum = RoundsAndScoring.checkRoundNumLess5(roundNum);

		if (ChechkedRoundNum == true) {


			List<String> randomLetters = GenerateRandomLetters.list();

			HttpSession session = request.getSession();


			session.setAttribute("sRoundNum", roundNum);

			session.setAttribute("sRandomLetters", randomLetters);

			session.setAttribute("sName", userName);

			session.setAttribute("sCurrentTotalScore", gameScore);

			ServletContext ctx = getServletContext();

			RequestDispatcher dispatcher = ctx.getRequestDispatcher("/nextRound.jsp");
			dispatcher.forward(request, response);

		} else {
			
			System.out.println("GameOver");
		}

	}// end doPost

}// end class SetUpGame
