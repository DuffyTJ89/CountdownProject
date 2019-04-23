package ie.gmit.sw;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class UserSignUp
 */
@WebServlet("/UserSignUp")
public class UserSignUp extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String login = req.getParameter("login_id");
        String pwd = req.getParameter("login_pwd");

        if (login == null || pwd == null || login.trim().length() == 0 || pwd.trim().length() == 0) {
            req.setAttribute("login_error", AttributeKeys.USER_LOGIN_EMPTY);
            req.getRequestDispatcher("/signUp.jsp").forward(req, resp);
        } else {

            try {
                boolean isUserFound = MongoDBUtil.searchUserByName(login);
                if (isUserFound) {
                    req.setAttribute("login_error", AttributeKeys.USER_EXISTS);
                    req.getRequestDispatcher("/signUp.jsp").forward(req, resp);
                    System.out.println("User with this name already exists");
                } else {
                    MongoDBUtil.userSignedUp(login, pwd);
                    req.getSession().setAttribute(AttributeKeys.SESSION_USER_NAME, login);
                    req.getRequestDispatcher("/welcome.jsp").forward(req, resp);
                    System.out.println("User Sign Up Successful");
                }
            } catch (Throwable e) {
                req.setAttribute("connection_error", AttributeKeys.DATABASE_CONNECTION_ERROR);
                req.getRequestDispatcher("/index.jsp").forward(req, resp);
                System.out.println("Database Connection Error");
                e.printStackTrace();
            }
        }
    }// doPost
}// UserSignUp
