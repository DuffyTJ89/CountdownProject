package ie.gmit.sw;

import java.io.*;
import java.util.Scanner;

public class CheckValidWord {

    static boolean check() {

        try {

            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//            String url = System.getProperty("user.dir");
//            System.out.println("user.dir" + url);
//
//            String url2 = System.getProperty("user.home");
//            System.out.println("user.home" + url2);


            Scanner sc = new Scanner(new File("C:\\Data\\CountdownProject\\src\\main\\java\\ie\\gmit\\sw\\outputCode.txt"));

            //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

            System.out.println("in check");
            int statusCode = sc.nextInt();
            // s.close();

            if (statusCode == 200) {
                System.out.println("Word is valid in check");


                return true;



            } else {
                System.out.println("Invalid Word, you will be given a new set of letters now");
                // TODO return user to enter word again

                return false;
                // System.exit(0); //Don't let the user continue with an invalid word
            }

            // s.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Can't find status code python file");
        }
        return false;

    }// end check()

}// end CheckValidWord
