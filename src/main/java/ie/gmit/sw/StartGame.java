package ie.gmit.sw;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.transform.sax.SAXSource;

/**
 * Servlet implementation class StartGame
 */
@WebServlet("/StartGame")
public class StartGame extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public StartGame() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        int gameScore = (int) session.getAttribute("sGameScore");
        int roundNum = (int) session.getAttribute("sRoundNum");
        String userName = (String) session.getAttribute("sName");

        String uGuess = request.getParameter("userGuess");
        System.out.println("user guess is " + uGuess);

        //UserWordToFile.takeInput(uGuess);

        //int PyScriptResponse = RunPythonScript.run();// run the python script to check the user word against the
        // dictionary API

        //System.out.println("countinueRun pyResp " + PyScriptResponse);
        //if (PyScriptResponse == 1) {

        //boolean wordIsValid = CheckValidWord.check();

        boolean wordIsValid = Dictionary.wordExists(uGuess);
        System.out.println("is the word valid? " + wordIsValid);


        if (wordIsValid == true) {

            // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

//			Scanner sc = new Scanner(new File(
//						"C:\\Users\\Thomas\\Desktop\\CountdownProject\\src\\main\\java\\ie\\gmit\\sw\\output.txt"));

            //Scanner sc = new Scanner(new File("C:\\Data\\CountdownProject\\src\\main\\java\\ie\\gmit\\sw\\output.txt"));

            // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //String userWord = sc.nextLine();

//				//String userWord;
//				try{//if the file is empty set user word to empty string
//					userWord = sc.nextLine();
//				}catch(Exception e){
//					userWord = " ";
//				}


            CompareWordToLetters.compare(uGuess, gameScore);

            int currentScore = RoundsAndScoring.cScore;


            //boolean ChechkedRoundNum = RoundsAndScoring.checkRoundNumLess5(roundNum);

            String uWord = CompareWordToLetters.userWordFinal;

            //sc.close();

            session.setAttribute("sUserWord", uWord);
            session.setAttribute("sRoundNum", roundNum);
            session.setAttribute("sName", userName);
            session.setAttribute("sGameScore", currentScore);

            ServletContext ctx = getServletContext();

            RequestDispatcher dispatcher = ctx.getRequestDispatcher("/result.jsp");
            dispatcher.forward(request, response);

        } // end wordIsvalid

        else {

            //CompareWordToLetters.compare(uGuess, gameScore);

            int currentScore = RoundsAndScoring.cScore;

            //String uWord = CompareWordToLetters.userWordFinal;
            System.out.println();

            session.setAttribute("sUserWord", uGuess);
            session.setAttribute("sRoundNum", roundNum);
            session.setAttribute("sName", userName);
            session.setAttribute("sGameScore", currentScore);
            System.out.println();

            ServletContext ctx = getServletContext();

            RequestDispatcher dispatcher = ctx.getRequestDispatcher("/result.jsp");
            dispatcher.forward(request, response);
        }

    } // end PyScriptResponse
    //}

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
