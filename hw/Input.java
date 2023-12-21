package hw;
import java.util.Scanner;

/**
 * Input
 */
public class Input{
    Scanner c = new Scanner(System.in);


    @Override
    protected void finalize(){
        c.close();
    }
}
