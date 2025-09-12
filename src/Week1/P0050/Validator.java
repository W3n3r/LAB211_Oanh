/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week1.P0050;

/**
 *
 * @author tothi
 */
// Validator.java
import java.util.Scanner;

public class Validator {
    static Scanner scanner = new Scanner(System.in);

    public static int checkChoice(String msg) {
        System.out.print(msg);
        while(true) {
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if(choice < 1 || choice > 3) {
                    System.out.print("Please enter 1, 2, or 3: ");
                    continue;
                }
                return choice;
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }
    
    public static double checkDouble(String msg) {
        System.out.print(msg);
        while(true) {
            try {
                double number = Double.parseDouble(scanner.nextLine());
                return number;
            } catch (NumberFormatException e) {
                System.out.print("Please input number: ");
            }
        }
    }
}
