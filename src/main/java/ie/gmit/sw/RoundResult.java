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
 * Servlet implementation class RoundResult
 */
@WebServlet("/RoundResult")
public class RoundResult extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public static final int NO_OF_ROUNDS = 5;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        resolveRound(request); //need to be always resolved regardless if it is a last round or not

        int lastRoundNum = (int) request.getSession().getAttribute(AttributeKeys.SESSION_ROUND_NUM);
        if (isGameFinished(lastRoundNum)) {
            finishGame(request, response, getServletContext());
        } else {
            showResults(request, response, getServletContext());
            incrementRoundNum(request);
        }
    }

    private static void resolveRound(HttpServletRequest request) throws IOException {

        HttpSession session = request.getSession();

        int currentTotalScore = (int) session.getAttribute(AttributeKeys.SESSION_TOTAL_SCORE);
        String uGuess = request.getParameter(AttributeKeys.USER_GUESS_WORD);

        int roundScore = 0; //0 explicitly - if wrong guessing

        if (Dictionary.wordExists(uGuess)) {
            System.out.println("Word is valid.");
            roundScore = CompareWordToLetters.countRoundScore(uGuess);
        }
        // else - not needed as the values are already initialized for this case

        request.setAttribute(AttributeKeys.USER_ROUND_SCORE, roundScore);
        session.setAttribute(AttributeKeys.SESSION_TOTAL_SCORE, currentTotalScore + roundScore);
    }

    private static boolean isGameFinished(int lastRoundNum) {
        return lastRoundNum == NO_OF_ROUNDS;
    }

    private static void finishGame(HttpServletRequest request, HttpServletResponse response, ServletContext ctx)
            throws ServletException, IOException {
        // Saving the score to database
        HttpSession session = request.getSession();
        try {
            MongoDBUtil.saveResult(
                    (String) session.getAttribute(AttributeKeys.SESSION_USER_NAME),
                    (int) session.getAttribute(AttributeKeys.SESSION_TOTAL_SCORE));
            System.out.println("Data saved successfully");
            session.setAttribute("data_save_success", AttributeKeys.DATA_SAVE_SUCCESS);

        } catch (Throwable e) {
            System.out.println("Data Save Failed");
            session.setAttribute("data_save_fail", AttributeKeys.DATA_SAVE_FAIL);

            e.printStackTrace();
        }

        RequestDispatcher dispatcher = ctx.getRequestDispatcher("/finalResult.jsp");
        dispatcher.forward(request, response);
    }

    private static void showResults(HttpServletRequest request, HttpServletResponse response, ServletContext ctx)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = ctx.getRequestDispatcher("/result.jsp");
        dispatcher.forward(request, response);
    }

    private static void incrementRoundNum(HttpServletRequest request) {
        HttpSession session = request.getSession();
        int lastRoundNum = (int) session.getAttribute(AttributeKeys.SESSION_ROUND_NUM);
        session.setAttribute(AttributeKeys.SESSION_ROUND_NUM, lastRoundNum + 1);
    }
}