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

/**
 * Servlet implementation class GameResults
 */
@WebServlet("/GameResults")
public class GameResults extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		int gameScore = (int) session.getAttribute("sCurrentTotalScore");
		int roundNum = (int) session.getAttribute("sRoundNum");
		String userName = (String) session.getAttribute("sName");
		String date = (String) session.getAttribute("sDate");

		roundNum = RoundsAndScoring.updateUserRoundNum(roundNum);

		boolean CheckedRoundNum = RoundsAndScoring.checkRoundNumLess5(roundNum);

		session.setAttribute("sRoundNum", roundNum);

		session.setAttribute("sName", userName);
		session.setAttribute("sCurrentTotalScore", gameScore);
		session.setAttribute("sDate", date);

		//initialize database saving messages
		session.setAttribute("db_save_success", "");
		session.setAttribute("db_save_error", "");

		if (CheckedRoundNum == true) {

			List<String> randomLettersList = GenerateRandomLetters.list();
			String randomLetters = String.join(" ", randomLettersList);

			request.setAttribute("sRandomLetters", randomLetters);

			ServletContext ctx = getServletContext();

			RequestDispatcher dispatcher = ctx.getRequestDispatcher("/nextRound.jsp");
			dispatcher.forward(request, response);

		} else {

			ServletContext ctx = getServletContext();

			// Saving the score to database
			try {
				MongoDBUtil.saveResult(userName, gameScore, date);
				System.out.println("Data saved successfully");
				session.setAttribute("db_save_success", "Data saved successfully");

			} catch (Throwable e) {
				System.out.println("Database Save Error");
				session.setAttribute("db_save_error", "Database Save Error");

				e.printStackTrace();
			}

			RequestDispatcher dispatcher = ctx.getRequestDispatcher("/finalResult.jsp");
			dispatcher.forward(request, response);
		}

		//display database results
		try {
			request.setAttribute("listScores", MongoDBUtil.displayResults(userName, gameScore, date));
			//request.setAttribute("listScores", new MongoDBUtil().displayResults(userName, gameScore, date));
			//MongoDBUtil.displayResults(userName, gameScore, date);
			System.out.println("Data displayed successfully");
		} catch (Throwable throwable) {
			System.out.println("Data displayed failed");
			throwable.printStackTrace();
		}
		ServletContext ctx = getServletContext();
		RequestDispatcher dispatcher = ctx.getRequestDispatcher("/highScores.jsp");
		dispatcher.forward(request, response);

	}//doGet

}//GameResults
