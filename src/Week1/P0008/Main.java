/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week1.P0008;

/**
 *
 * @author tothi
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("========= Letter and Character Counter =========");
        
        while (true) {
            String input = Validator.checkString("Enter your content: ");
            
            LetterCharacterCounter counter = new LetterCharacterCounter(input);
            
            // Display main results
            counter.displayResults();
            
            // Display tokens
            counter.displayTokens();
            
            // Ask if user wants to continue
            if (!Validator.checkContinue("\nDo you want to analyze another string? (Y/N): ")) {
                break;
            }
        }
        
        System.out.println("Thank you for using Letter and Character Counter!");
    }
}