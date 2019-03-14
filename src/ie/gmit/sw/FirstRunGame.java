package ie.gmit.sw;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MainGame
 */
@WebServlet("/FirstRunGame")
public class FirstRunGame extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FirstRunGame() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

//		request.setAttribute("sRoundNum", roundNum);
//		request.setAttribute("sRandomLetters", randomLetters);
//		request.setAttribute("sName", yourName);
//		request.setAttribute("sGameScore", gameScore);
		int gameScore = (int) session.getAttribute("sGameScore");
		int roundNum = (int) session.getAttribute("sRoundNum");
		String yourName = (String) session.getAttribute("sName");

		String uGuess = request.getParameter("userGuess");

		PrintWriter writer = response.getWriter();

		writer.println("<body style='background-color:#07205A;'>");

		writer.println("<h3 style=\"text-align:center;color:white;\">Word guessed " + uGuess + "</h3>");

		UserWordToFile.takeInput(uGuess);
		// System.out.println("Checking if word is valid...");
		writer.println("<h3 style=\"text-align:center;color:white;\">Checking if word is valid... </h3>");
		boolean PyScriptResponse = RunPythonScript.run();// run the python script to check the user word against the
															// dictionary API

		if (PyScriptResponse = true) {
			// writer.println("<h3 style=\"text-align:center;color:white;\">Waiting on
			// Oxford Dictonary </h3>");
			// TODO pass the current gamescore

			boolean wordIsValid = CheckValidWord.check();

			if (wordIsValid = true) {
				writer.println("<h3 style=\"text-align:center;color:white;\">Word is valid... </h3>");
				Scanner sc = new Scanner(new File(
						"C:\\Users\\Thomas\\Desktop\\NewCountdown\\ScrabbleProject\\src\\main\\java\\ie\\gmit\\sw\\Game\\output.txt"));
				String userWord = sc.nextLine();

				int lettersUsed = CompareWordToLetters.compare(userWord, gameScore);

				// System.out.println("Your answer of ' " + userWord + " ' uses ");

				// int lettersUsed = CompareWordToLetters.compare(userWord, gameScore);

				writer.println("<h3 style=\"text-align:center;color:white;\">Your Answer of ' " + userWord + "' uses "
						+ lettersUsed + " letters</h3>");

				// System.out.println("Overall game score : " + MainGame.gameScore);

				int currentScore = RoundsAndScoring.cScore;

				writer.println(
						"<h3 style=\"text-align:center;color:white;\">Current Score' " + currentScore + " </h3>");

				System.out.println("Round refore : " + roundNum);
				// RoundLimit.checkRoundNum();//move to the next round
				
				//TODO add to continue instead
				//roundNum = RoundsAndScoring.updateUserRoundNum(roundNum);

				boolean ChechkedRoundNum = RoundsAndScoring.checkRoundNumLess5(roundNum);

				if (ChechkedRoundNum == true) {
					// writer.println("<h3> Round : " + roundNum + "/5 </h3>");

					//List<String> randomLetters = GenerateRandomLetters.list();

					// writer.println("<h3> Here are your random letters : " + randomLetters +"
					// </h3>");

					// pass round num, randletters

					// sessionRoundNum.setAttribute("sRoundNum", roundNum);
					// sessionRandletters.setAttribute("sRandLetters", randomLetters);

					// String id = "123";
					// response.sendRedirect("toNexturl.jsp?id="+id);

					// HttpSession session = request.getSession();
					
					String uWord = CompareWordToLetters.userWordFinal;
					
					session.setAttribute("sUserWord", uWord);

					request.setAttribute("sRoundNum", roundNum);
					session.setAttribute("sRoundNum", roundNum);
					//request.setAttribute("sRandomLetters", randomLetters);
					//session.setAttribute("sRandomLetters", randomLetters);
					request.setAttribute("sName", yourName);
					session.setAttribute("sName", yourName);
					request.setAttribute("sGameScore", currentScore);
					session.setAttribute("sGameScore", currentScore);

					ServletContext ctx = getServletContext();

					RequestDispatcher dispatcher = ctx.getRequestDispatcher("/result.jsp");
					dispatcher.forward(request, response);

					// response.sendRedirect("NewGame.jsp");
					// request.getRequestDispatcher("NewGame.jsp").forward(request, response);

					// System.out.println("Here");

					// UserWord.takeInput();

					// CheckValidWord.check(gameScore);

				} else {
					writer.println(
							"Game over \n" + "After " + (roundNum - 1) + " rounds. Total Game Score " + gameScore);
				}

				// String test = "testing";

				// writer.println("<h2>Hello " + test + "</h2>");

				writer.close();
			} // end doPost

		} else {
			writer.println("<h3 style=\"text-align:center;color:white;\">Word is INVALID... </h3>");
			GenerateRandomLetters.list();
		}

		// int roundNum = (int) session.getAttribute("sRoundNum");

//				request.setAttribute("sRoundNum", roundNum);
//				session.setAttribute("sRoundNum",roundNum );
//				request.setAttribute("sRandomLetters", randomLetters);
//				session.setAttribute("sRandomLetters",randomLetters );
//				request.setAttribute("sName", yourName);
//				session.setAttribute("sName",yourName );
//				request.setAttribute("sGameScore", gameScore);
//				session.setAttribute("sGameScore",gameScore );

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
