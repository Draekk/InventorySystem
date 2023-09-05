package Operators;
import java.util.Scanner;

public class Operators {

    //Converters
    public int toInt(String value){
        while (true){
            try{
                int result = Integer.parseInt(value);
                return result;
            } catch (Exception ex){
                System.out.println("Format error: " + ex.getMessage());
                Scanner sc = new Scanner(System.in);
                System.out.println("Try again...");
                value = sc.nextLine();
            }
        }
    }

    public float toFloat(String value){
        while (true){
            try{
                float result = Float.parseFloat(value);
                return result;
            } catch (Exception ex){
                System.out.println("Format error: " + ex.getMessage());
                Scanner sc = new Scanner(System.in);
                System.out.println("Try again...");
                value = sc.nextLine();
            }
        }
    }

}
