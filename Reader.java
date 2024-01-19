// package compsci20finalproject;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Reader {
   
    BufferedReader buffer;
    StringTokenizer tokenizer;
   
    public Reader(){
        buffer = new BufferedReader(new InputStreamReader(System.in));
    }
   
    public String next(){
        //makeReader();
        while (tokenizer == null || !tokenizer.hasMoreElements()){
            try{
                if(buffer.readLine() == null){
                    break;
                }
                tokenizer = new StringTokenizer(buffer.readLine());
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
        return tokenizer.nextToken();
    }
   
    int nextInt() { return Integer.parseInt(next()); }
   
    long nextLong() { return Long.parseLong(next()); }
   
    double nextDouble(){return Double.parseDouble(next());}
   
    public String nextLine(){
        String str = "";
        try{
            str = buffer.readLine();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return str;
    }
}