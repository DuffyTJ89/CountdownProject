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

@WebServlet("/FirstRunGame")
public class FirstRunGame extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FirstRunGame() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		int gameScore = (int) session.getAttribute("sGameScore");
		int roundNum = (int) session.getAttribute("sRoundNum");
		String userName = (String) session.getAttribute("sName");

		String uGuess = request.getParameter("userGuess");

		UserWordToFile.takeInput(uGuess);

		int PyScriptResponse = RunPythonScript.run();// run the python script to check the user word against the
															// dictionary API
		
		System.out.println("PyScriptResponse " + PyScriptResponse);

		if (PyScriptResponse == 1) {

			boolean wordIsValid = CheckValidWord.check();

			if (wordIsValid = true) {

				// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//				Scanner sc = new Scanner(new File(
//						"C:\\Users\\Thomas\\eclipse-workspace\\JSPCountdown\\Countdown\\src\\ie\\gmit\\sw\\output.txt"));

				Scanner sc = new Scanner(new File(
						"C:\\Data\\Skola\\GMIT\\Year 4\\Semester 1\\Applied Project and Minor Dissertation\\Project\\CountdownProject-Eclipse\\CountdownProject\\src\\ie\\gmit\\sw\\output.txt"));

				//Scanner sc = new Scanner(new File("output.txt"));

				// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				String userWord = sc.nextLine();

				int lettersUsed = CompareWordToLetters.compare(userWord, gameScore);

				int currentScore = RoundsAndScoring.cScore;

				System.out.println("Round befores : " + roundNum);

				boolean ChechkedRoundNum = RoundsAndScoring.checkRoundNumLess5(roundNum);

				if (ChechkedRoundNum == true) {
					// writer.println("<h3> Round : " + roundNum + "/5 </h3>");

					List<String> randomLetters = GenerateRandomLetters.list();

					String uWord = CompareWordToLetters.userWordFinal;

					session.setAttribute("sUserWord", uWord);

					session.setAttribute("sRoundNum", roundNum);

					session.setAttribute("sName", userName);

					session.setAttribute("sGameScore", currentScore);

					ServletContext ctx = getServletContext();

					RequestDispatcher dispatcher = ctx.getRequestDispatcher("/result.jsp");
					dispatcher.forward(request, response);

				} else {
					// TODO game over
				}

			} // end doPost

		} else {
			System.out.println("word is invalid");
			GenerateRandomLetters.list();
			
			session.setAttribute("sRoundNum", roundNum);
			session.setAttribute("sName", userName);
			int currentScore = 0;
			session.setAttribute("sGameScore", currentScore);
			
			ServletContext ctx = getServletContext();
			RequestDispatcher dispatcher = ctx.getRequestDispatcher("/result.jsp");
			dispatcher.forward(request, response);
		}

		session.setAttribute("sGameScore", gameScore);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
