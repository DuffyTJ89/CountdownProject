package ie.gmit.sw;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/DisplayScores")
public class DisplayScores extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("we are in servlet");

        try {
            List<GameResult> topTen = MongoDBUtil.getTopTen();
            request.setAttribute("topTen", topTen);
            //MongoDBUtil.getTopTen();
            System.out.println("Data displayed successfully");
        } catch (Throwable throwable) {
            System.out.println("Data displayed failed");
            throwable.printStackTrace();
        }
        ServletContext ctx = getServletContext();
        RequestDispatcher dispatcher = ctx.getRequestDispatcher("/highScores.jsp");
        dispatcher.forward(request, response);

    }
}
