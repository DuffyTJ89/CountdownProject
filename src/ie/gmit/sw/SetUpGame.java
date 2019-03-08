//Resources:
// https://www.codejava.net/coding/java-servlet-and-jsp-hello-world-tutorial-with-eclipse-maven-and-apache-tomcat

package ie.gmit.sw;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/newGame")
public class SetUpGame extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	//static String roundNumString = "";
	boolean ChechkedRoundNum;
	
	

	public SetUpGame() {
		super();
	}// end NewGam()

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//HttpSession sessionRoundNum = request.getSession();
		//HttpSession sessionRandletters = request.getSession();
		//HttpSession session3 = request.getSession(false);
		
		String yourName = request.getParameter("userName");
		PrintWriter writer = response.getWriter();
		
		writer.println("<body style='background-color:#07205A;'>");
		
		writer.println("<h1>Hello " + yourName + "</h1>");
		

		//Runner.main(null);
		
		int roundNum = RoundsAndScoring.setUserRoundNum();//Initialize the user's round number to zero
		int gameScore = RoundsAndScoring.setUserGameScore();
		
		
		roundNum = RoundsAndScoring.updateUserRoundNum(roundNum);
		ChechkedRoundNum = RoundsAndScoring.checkRoundNumLess5(roundNum);
		
		if (ChechkedRoundNum == true)
		{
			//writer.println("<h3> Round : " + roundNum + "/5 </h3>");
			
			List<String> randomLetters = GenerateRandomLetters.list();
			
			//writer.println("<h3> Here are your random letters : " + randomLetters +" </h3>");
			
			//pass round num, randletters
			
			//sessionRoundNum.setAttribute("sRoundNum", roundNum);
			//sessionRandletters.setAttribute("sRandLetters", randomLetters);
			
			//String id = "123";
			//response.sendRedirect("toNexturl.jsp?id="+id);
			
			request.setAttribute("sRoundNum", roundNum);
			request.setAttribute("sRandomLetters", randomLetters);
			request.setAttribute("sName", yourName);
			
			ServletContext ctx = getServletContext();
			
			RequestDispatcher dispatcher = ctx.getRequestDispatcher("/NewGame.jsp");
			dispatcher.forward(request, response);
			
			//response.sendRedirect("NewGame.jsp");
			//request.getRequestDispatcher("NewGame.jsp").forward(request, response);
		
		   
			
			//System.out.println("Here");
			
			//UserWord.takeInput();
			
			//CheckValidWord.check(gameScore);
			
			
			
		
		}
		else {
			writer.println("Game over \n" + "After " + (roundNum - 1) + " rounds. Total Game Score " + gameScore);
		}
		
		//String test = "testing";
		
		//writer.println("<h2>Hello " + test + "</h2>");
		
		writer.close();
	}// end doPost
	
	/*
	static void RanLet(String randLet) {
		PrintWriter write = new PrintWriter(randLet);
		write.println("<h1>Hello " + randLet + "</h1>");
	}
	 */
}// end class NewGame
