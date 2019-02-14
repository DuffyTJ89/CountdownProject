package ie.gmit.sw.Game;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class CountdownTimer {
    static Thread timer = new Thread();
    public static void main(String[] args) {

        Thread thread1 = new Thread() {
            public void run() {

                try {
                    FileInputStream fs = new FileInputStream("C:\\Users\\Thomas\\Desktop\\NewCountdown\\ScrabbleProject\\src\\main\\java\\ie\\gmit\\sw\\Game\\CountdownClock.mp3");
                    Player player = new Player(fs);
                    player.play();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (JavaLayerException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        };

        Thread thread2 = new Thread() {

            public void run() {
                for (int i = 30; i >= 1; i--) {

                    try {
                        timer.sleep(1000);
                        System.out.println("time remaining : " + i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        // Start the threads.
        thread1.start();
        thread2.start();

        // Wait for them both to finish
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
