package PhidgetsScrapped;
// package compsci20finalproject;

//import com.phidget22.*;
import java.util.*;

import Reader;
import StopWatch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TugOfWarPhidgetsScrapped implements Game {
   
    public final int players = 2;
   
    Reader inputReader = new Reader();
   
    public int grnPresses = 0;
    public int redPresses = 0;
    // private DigitalInput redBtn;
    // private DigitalInput grnBtn;
    // private DigitalOutput redLED;
    // private DigitalOutput grnLED;

    @Override
    public void run(/*DigitalInput redBtn, DigitalInput grnBtn, DigitalOutput redLED, DigitalOutput grnLED*/) throws Exception {

        // this.redBtn = redBtn;
        // this.grnBtn = grnBtn;
        // this.redLED = redLED;
        // this.grnLED = grnLED;

        checkPress(/*redBtn, grnBtn, redLED, grnLED*/);
    }

    public void checkPress(/*DigitalInput redBtn, DigitalInput grnBtn, DigitalOutput redLED, DigitalOutput grnLED*/) throws Exception {
       
        StopWatch stopWatch1 = new StopWatch();
       
        /*redBtn.addStateChangeListener(
                (DigitalInputStateChangeEvent e) -> {
                    if (e.getState() == true) {
                        redPresses++;
                        System.out.println("Green: "+redPresses);
                    }
                }
        );*/

        /*grnBtn.addStateChangeListener(
                (DigitalInputStateChangeEvent e) -> {
                    if (e.getState() == true) {
                        grnPresses++;
                        System.out.println("Red: "+grnPresses);
                    }
                }
        );*/
       
        
       
        while(stopWatch1.getTime() < 5000){
           
        }
        endGame();
       
    }
   
    @Override
    public void endGame(){
        System.out.println("Final Scores:");
        System.out.println("Green: "+redPresses);
        System.out.println("Red: "+grnPresses);
       
        if(redPresses == grnPresses){
            System.out.println("There was a tie");
        }
        else if(redPresses > grnPresses){
            System.out.println("Red won by "+ (redPresses-grnPresses) +" points!");
        }
        else{
            System.out.println("Green won by "+ (grnPresses-redPresses) +" points!");
        }
        System.out.println("Would you like to play again or try a different game?\n"
                + "Press the green button to play again, red to exit, or type 'continue' to continue, or 'exit' to exit");
        exit();
    }
   
    @Override
    public void exit(){
       
        Reader inputReader = new Reader();
       
        while(true){
            String enterString = inputReader.nextLine();
            if(enterString.equals("exit")){
                System.out.println("exiting...");
                StopWatch stopWatchExiting = new StopWatch();
                while(stopWatchExiting.getTime() < 5000){

                }
                System.out.println("Thank you for using the application!");
                break;
            }
            else if(enterString.equals("continue")){

                break;
            }
            else{
               System.out.println("Please input one of the options provided");
            }
        }
    }
}
