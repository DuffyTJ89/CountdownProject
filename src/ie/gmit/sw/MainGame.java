package ie.gmit.sw;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
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
			//CheckValidWord.check();
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
