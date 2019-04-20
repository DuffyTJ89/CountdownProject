//Resources: https://www.codejava.net/coding/java-servlet-and-jsp-hello-world-tutorial-with-eclipse-maven-and-apache-tomcat
package ie.gmit.sw;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/NewGame")
public class NewGame extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getSession().setAttribute(AttributeKeys.SESSION_TOTAL_SCORE, 0);
        request.getSession().setAttribute(AttributeKeys.SESSION_ROUND_NUM, 1);

        GamePlay.nextRound(request, response, getServletContext());
    }

}
