package ie.gmit.sw;

import java.io.File;
import java.io.IOException;
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
 * Servlet implementation class ContinueRunGame
 */
@WebServlet("/ContinueRunGame")
public class ContinueRunGame extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ContinueRunGame() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		HttpSession session = request.getSession();

		int gameScore = (int) session.getAttribute("sGameScore");
		int roundNum = (int) session.getAttribute("sRoundNum");
		String yourName = (String) session.getAttribute("sName");

		String uGuess = request.getParameter("userGuess");

		UserWordToFile.takeInput(uGuess);

		boolean PyScriptResponse = RunPythonScript.run();// run the python script to check the user word against the
															// dictionary API
		
		if (PyScriptResponse = true) {
			// writer.println("<h3 style=\"text-align:center;color:white;\">Waiting on
			// Oxford Dictonary </h3>");
			// TODO pass the current gamescore

			boolean wordIsValid = CheckValidWord.check();
			
			if (wordIsValid = true) {
				
				Scanner sc = new Scanner(new File(
						"C:\\Users\\Thomas\\Desktop\\NewCountdown\\ScrabbleProject\\src\\main\\java\\ie\\gmit\\sw\\Game\\output.txt"));
				String userWord = sc.nextLine();

				int lettersUsed = CompareWordToLetters.compare(userWord, gameScore);
				
				int currentScore = RoundsAndScoring.cScore;
				
				boolean ChechkedRoundNum = RoundsAndScoring.checkRoundNumLess5(roundNum);
				
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

				
			}//end wordIsvalid
			
		}//end PyScriptResponse
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
