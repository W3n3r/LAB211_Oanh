/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week1.P0011;

/**
 *
 * @author tothi
 */

import java.util.Scanner;

public class Validator {
    static Scanner scanner = new Scanner(System.in);

    public static int checkChoice(String msg, int min, int max) {
        System.out.print(msg);
        while(true) {
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if(choice < min || choice > max) {
                    System.out.print("Please enter " + min + "-" + max + ": ");
                    continue;
                }
                return choice;
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }
    
    public static String checkNumberByBase(String msg, int base) {
        System.out.print(msg);
        while(true) {
            String input = scanner.nextLine().trim().toUpperCase();
            if(isValidNumber(input, base)) {
                return input;
            }
            System.out.print("Invalid number for base " + base + ". Try again: ");
        }
    }
    
    public static boolean isValidNumber(String input, int base) {
        if (input.isEmpty()) return false;
        
        String validChars;
        switch (base) {
            case 2: validChars = "01"; break;
            case 10: validChars = "0123456789"; break;
            case 16: validChars = "0123456789ABCDEF"; break;
            default: return false;
        }
        
        for (char c : input.toCharArray()) {
            if (validChars.indexOf(c) == -1) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean checkContinue(String msg) {
        System.out.print(msg);
        String choice = scanner.nextLine().trim().toUpperCase();
        return choice.equals("Y") || choice.equals("YES");
    }
}
