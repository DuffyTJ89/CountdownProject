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

	public ContinueRunGame() {
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

		System.out.println("countinueRun pyResp " + PyScriptResponse);
		if (PyScriptResponse == 1) {

			boolean wordIsValid = CheckValidWord.check();

			if (wordIsValid = true) {

				// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

				Scanner sc = new Scanner(new File(
						"C:\\Users\\Thomas\\Desktop\\MajoCountdown\\CountdownProject\\src\\ie\\gmit\\sw\\output.txt"));

//				Scanner sc = new Scanner(new File(
//						"C:\\Data\\Skola\\GMIT\\Year 4\\Semester 1\\Applied Project and Minor Dissertation\\Project\\CountdownProject-Eclipse\\CountdownProject\\src\\ie\\gmit\\sw\\output.txt"));

				// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				//String userWord = sc.nextLine();
				
				String userWord;
				try{//if the file is empty set user word to empty string
					userWord = sc.nextLine();
				}catch(Exception e){
					userWord = " ";
				}

				int lettersUsed = CompareWordToLetters.compare(userWord, gameScore);

				int currentScore = RoundsAndScoring.cScore;

				boolean ChechkedRoundNum = RoundsAndScoring.checkRoundNumLess5(roundNum);

				String uWord = CompareWordToLetters.userWordFinal;

				sc.close();

				session.setAttribute("sUserWord", uWord);
				session.setAttribute("sRoundNum", roundNum);
				session.setAttribute("sName", userName);
				session.setAttribute("sGameScore", currentScore);

				ServletContext ctx = getServletContext();

				RequestDispatcher dispatcher = ctx.getRequestDispatcher("/result.jsp");
				dispatcher.forward(request, response);

			} // end wordIsvalid

		} // end PyScriptResponse
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
