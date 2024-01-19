package PhidgetsScrapped;
// package phidgets;

// import com.phidget22.DigitalInput;
// import com.phidget22.DigitalOutput;


public interface Game {
   
    public void run(/*DigitalInput redBtn, DigitalInput grnBtn, DigitalOutput redLED, DigitalOutput grnLED*/)throws Exception;
   
    public void endGame();
   
    public void exit();
   
}