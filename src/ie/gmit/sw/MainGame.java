package ie.gmit.sw;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

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
@WebServlet("/MainGame")
public class MainGame extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainGame() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
//		request.setAttribute("sRoundNum", roundNum);
//		request.setAttribute("sRandomLetters", randomLetters);
//		request.setAttribute("sName", yourName);
//		request.setAttribute("sGameScore", gameScore);
		int gameScore = (int) session.getAttribute("sGameScore");
		
		
		String uGuess = request.getParameter("userGuess");
			
		PrintWriter writer = response.getWriter();
		
		
		
		writer.println("<body style='background-color:#07205A;'>");
		
		writer.println("<h3 style=\"text-align:center;color:white;\">Word guessed " + uGuess + "</h3>");
		
		UserWordToFile.takeInput(uGuess);
		//System.out.println("Checking if word is valid...");
		writer.println("<h3 style=\"text-align:center;color:white;\">Checking if word is valid... </h3>");
		boolean PyScriptResponse = RunPythonScript.run();// run the python script to check the user word against the dictionary API
		
		if (PyScriptResponse = true)
		{
			//writer.println("<h3 style=\"text-align:center;color:white;\">Waiting on Oxford Dictonary  </h3>");
			//TODO pass the current gamescore
			
			boolean wordIsValid = CheckValidWord.check();
			
			if (wordIsValid = true)
			{
				writer.println("<h3 style=\"text-align:center;color:white;\">Word is valid... </h3>");
				Scanner sc = new Scanner(new File("C:\\Users\\Thomas\\Desktop\\NewCountdown\\ScrabbleProject\\src\\main\\java\\ie\\gmit\\sw\\Game\\output.txt"));
				String userWord = sc.nextLine();
				
				int lettersUsed = CompareWordToLetters.compare(userWord, gameScore);
				
				//System.out.println("Your answer of ' " + userWord + " ' uses  ");
				
				//int lettersUsed = CompareWordToLetters.compare(userWord, gameScore);
				
				writer.println("<h3 style=\"text-align:center;color:white;\">Your Answer of ' " +  userWord + "' uses " + lettersUsed + " letters</h3>");
				
				//System.out.println("Overall game score : " + MainGame.gameScore);
				
				int currentScore = RoundsAndScoring.cScore;
				
				writer.println("<h3 style=\"text-align:center;color:white;\">Current Score' " + currentScore  + " </h3>");

				//RoundLimit.checkRoundNum();//move to the next round
				
				
			}
			else
			{
				writer.println("<h3 style=\"text-align:center;color:white;\">Word is INVALID... </h3>");
				GenerateRandomLetters.list();
			}
			
			 //int roundNum = (int) session.getAttribute("sRoundNum");
			 
			 
			 
			 
//				request.setAttribute("sRoundNum", roundNum);
//				session.setAttribute("sRoundNum",roundNum );
//				request.setAttribute("sRandomLetters", randomLetters);
//				session.setAttribute("sRandomLetters",randomLetters );
//				request.setAttribute("sName", yourName);
//				session.setAttribute("sName",yourName );
//				request.setAttribute("sGameScore", gameScore);
//				session.setAttribute("sGameScore",gameScore );
						
			
		}
		else
		{
			
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
