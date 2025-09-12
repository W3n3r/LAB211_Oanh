/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week1.P0011;

/**
 *
 * @author tothi
 */

public class Main {
    public static void main(String[] args) {
        BaseConverter converter = new BaseConverter();
        
        while (true) {
            converter.displayMenu();
            
            int inputChoice = Validator.checkChoice("Choose input base (1-3): ", 1, 3);
            int outputChoice = Validator.checkChoice("Choose output base (1-3): ", 1, 3);
            
            int inputBase = converter.getBaseValue(inputChoice);
            int outputBase = converter.getBaseValue(outputChoice);
            
            String number = Validator.checkNumberByBase("Enter number: ", inputBase);
            
            String result = converter.convertBase(number, inputBase, outputBase);
            
            System.out.println("\n----- Result -----");
            System.out.println(number + " (" + converter.getBaseName(inputChoice) + 
                             ") = " + result + " (" + converter.getBaseName(outputChoice) + ")");
            
            if (!Validator.checkContinue("Continue? (Y/N): ")) {
                break;
            }
        }
        
        System.out.println("Thank you for using Base Converter!");
    }
}