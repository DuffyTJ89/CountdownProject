package ie.gmit.sw;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GamePlay
 */
@WebServlet("/GamePlay")
public class GamePlay extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        int gameScore = (int) session.getAttribute("sCurrentTotalScore");
        int roundNum = (int) session.getAttribute("sRoundNum");
        String userName = (String) session.getAttribute("sName");

        String uGuess = request.getParameter("userGuessWord");
        System.out.println("user guess word: " + uGuess);

        boolean wordIsValid = Dictionary.wordExists(uGuess);
        System.out.println("word valid: " + wordIsValid);


        if (wordIsValid == true) {

            CompareWordToLetters.compare(uGuess, gameScore);

            int currentTotalScore = RoundsAndScoring.cScore;

            String guessWord = CompareWordToLetters.userGuessWordFinal;

            //sc.close();

            session.setAttribute("sUserGuessWord", guessWord);
            session.setAttribute("sRoundNum", roundNum);
            session.setAttribute("sName", userName);
            session.setAttribute("sCurrentTotalScore", currentTotalScore);

            ServletContext ctx = getServletContext();
            RequestDispatcher dispatcher = ctx.getRequestDispatcher("/result.jsp");
            dispatcher.forward(request, response);

        } // end wordIsvalid

        else {

            int currentTotalScore = RoundsAndScoring.cScore;

            session.setAttribute("sUserGuessWord", uGuess);
            session.setAttribute("sRoundNum", roundNum);
            session.setAttribute("sName", userName);
            session.setAttribute("sCurrentTotalScore", currentTotalScore);
            System.out.println();

            ServletContext ctx = getServletContext();
            RequestDispatcher dispatcher = ctx.getRequestDispatcher("/result.jsp");
            dispatcher.forward(request, response);
        }

    }//doGet

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
