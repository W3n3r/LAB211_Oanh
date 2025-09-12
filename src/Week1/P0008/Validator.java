
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week1.P0008;
/**
 *
 * @author tothi
 */
import java.util.Scanner;

public class Validator {
    static Scanner scanner = new Scanner(System.in);

    public static String checkString(String msg) {
        System.out.print(msg);
        String input = scanner.nextLine();
        return input;
    }
    
    public static boolean checkContinue(String msg) {
        System.out.print(msg);
        String choice = scanner.nextLine().trim().toUpperCase();
        return choice.equals("Y") || choice.equals("YES");
    }
}
