// package compsci20finalproject;
import java.util.*;

public class StopWatch {
    private static Date time1 = new Date();
   
    public static int getTime(){
        int elapsed = (int) (new Date().getTime() - time1.getTime());
       
        return elapsed;
    }
}