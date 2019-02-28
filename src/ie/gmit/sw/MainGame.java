//Resources:
// https://www.codejava.net/coding/java-servlet-and-jsp-hello-world-tutorial-with-eclipse-maven-and-apache-tomcat

package ie.gmit.sw;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/newGame")
public class MainGame extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static int roundNum = 0;
	static int gameScore = 0;
	//static String roundNumString = "";
	boolean ChechkedRoundNum;
	

	public MainGame() {
		super();
	}// end NewGam()

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String yourName = request.getParameter("userName");
		PrintWriter writer = response.getWriter();
		writer.println("<h1>Hello " + yourName + "</h1>");
		

		//Runner.main(null);
		
		ChechkedRoundNum = RoundLimit.checkRoundNumLess5(roundNum);
		
		if (ChechkedRoundNum == true)
		{
			writer.println("<h3> Round : " + roundNum + "/5 </h3>");
			
			List<String> randomLetters = GenerateRandomLetters.list();
			
			writer.println("<h3> Here are your random letters : " + randomLetters +" </h3>");
			
			
			
		
		}
		else {
			writer.println("Game over \n" + "After " + (roundNum - 1) + " rounds. Total Game Score " + gameScore);
		}
		
		String test = "testing";
		
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
