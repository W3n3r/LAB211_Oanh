/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week3.P0001;

import java.util.Scanner;

/**
 *
 * @author tothi
 */

public class Validator {
    static Scanner scanner = new Scanner(System.in);

    public static int checkNumber(String msg){
        System.out.print(msg);
        while(true) {
            try {
                int num = Integer.parseInt(scanner.nextLine());
                if(num < 1){
                    System.out.print("Please enter a positive number: ");
                    continue;
                }
                return num;
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }
}
