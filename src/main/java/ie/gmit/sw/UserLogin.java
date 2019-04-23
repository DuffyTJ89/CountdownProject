//source: https://examples.javacodegeeks.com/software-development/mongodb/mongodb-and-jsp-servlet-example/
package ie.gmit.sw;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// This method is called by the servlet container to process a 'post' request
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		// Reading post parameters from the request
		String login = req.getParameter("login_id");
		String pwd = req.getParameter("login_pwd");

		// Checking for null and empty values
		if (login == null || pwd == null || login.trim().length() == 0 || pwd.trim().length() == 0) {
			req.setAttribute("login_error", AttributeKeys.USER_LOGIN_EMPTY);
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		} else {

			try {
				boolean isUserFound = MongoDBUtil.searchUserInDb(login, pwd);
				if (isUserFound) {
					req.getSession().setAttribute(AttributeKeys.SESSION_USER_NAME, login);
					req.getRequestDispatcher("/welcome.jsp").forward(req, resp);
					System.out.println("User Login Successful");
				} else {
					req.setAttribute("login_error", AttributeKeys.USER_INCORRECT_LOGIN);
					req.getRequestDispatcher("/index.jsp").forward(req, resp);
					System.out.println("User Incorrect Login");
				}
			} catch (Throwable e) {
				req.setAttribute("connection_error", AttributeKeys.DATABASE_CONNECTION_ERROR);
				req.getRequestDispatcher("/index.jsp").forward(req, resp);
				System.out.println("Database Connection Error");
				e.printStackTrace();
			}
		}
	}// doPost

}// UserLogin
