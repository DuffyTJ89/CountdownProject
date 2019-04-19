package ie.gmit.sw;

import java.io.IOException;
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
 * Servlet implementation class GamePlay
 */
@WebServlet("/GamePlay")
public class GamePlay extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        nextRound(request, response, getServletContext());
    }

    public static void nextRound(HttpServletRequest request, HttpServletResponse response, ServletContext ctx)
            throws ServletException, IOException {
        List<String> randomLetters = GenerateRandomLetters.list();
        String randomLettersStr = String.join(" ", randomLetters);

        request.setAttribute("randLetters", randomLettersStr);

        RequestDispatcher dispatcher = ctx.getRequestDispatcher("/nextRound.jsp");
        dispatcher.forward(request, response);
    }

}
