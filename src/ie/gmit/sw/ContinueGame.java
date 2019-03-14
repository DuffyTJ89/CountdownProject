package ie.gmit.sw;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class ContinueGame
 */
@WebServlet("/ContinueGame")
public class ContinueGame extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ContinueGame() {
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
		
		PrintWriter writer = response.getWriter();

		HttpSession session = request.getSession();

		int gameScore = (int) session.getAttribute("sGameScore");
		int roundNum = (int) session.getAttribute("sRoundNum");
		String yourName = (String) session.getAttribute("sName");

		boolean ChechkedRoundNum = RoundsAndScoring.checkRoundNumLess5(roundNum);

		if (ChechkedRoundNum == true) {

			List<String> randomLetters = GenerateRandomLetters.list();
			
			
			session.setAttribute("sRoundNum", roundNum);
			session.setAttribute("sRandomLetters", randomLetters);
			session.setAttribute("sName", yourName);
			session.setAttribute("sGameScore", gameScore);
			
			ServletContext ctx = getServletContext();

			RequestDispatcher dispatcher = ctx.getRequestDispatcher("/newRound.jsp");
			dispatcher.forward(request, response);

		} else {
			writer.println("Game over \n" + "After " + (roundNum - 1) + " rounds. Total Game Score " + gameScore);
		}

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
