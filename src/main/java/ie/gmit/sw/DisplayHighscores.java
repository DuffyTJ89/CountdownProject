package ie.gmit.sw;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/DisplayHighscores")
public class DisplayHighscores extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("we are in servlet");




        request.getAttribute("name", userName);
        request.getAttribute("score", gameScore);
        request.getAttribute("date", date);

        //display database results
        try {
            request.setAttribute("listScores", MongoDBUtil.displayResults(userName, gameScore, date));
            //request.setAttribute("listScores", new MongoDBUtil().displayResults(userName, gameScore, date));
            //MongoDBUtil.displayResults(userName, gameScore, date);
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
