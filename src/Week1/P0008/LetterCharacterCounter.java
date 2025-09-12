/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week1.P0008;

/**
 *
 * @author tothi
 */
import java.util.StringTokenizer;

public class LetterCharacterCounter {
    private String inputString;
    
    public LetterCharacterCounter(String input) {
        this.inputString = input;
    }
    
    public int countCharacters() {
        return inputString.length();
    }
    
    public int countLetters() {
        int letterCount = 0;
        for (char c : inputString.toCharArray()) {
            if (Character.isLetter(c)) {
                letterCount++;
            }
        }
        return letterCount;
    }
    
    public int countWords() {
        if (inputString.trim().isEmpty()) {
            return 0;
        }
        StringTokenizer tokenizer = new StringTokenizer(inputString);
        return tokenizer.countTokens();
    }
    
    public int countSpaces() {
        int spaceCount = 0;
        for (char c : inputString.toCharArray()) {
            if (Character.isWhitespace(c)) {
                spaceCount++;
            }
        }
        return spaceCount;
    }
    
    public void displayResults() {
        System.out.println("\n----- Analysis Results -----");
        System.out.println("Input string: \"" + inputString + "\"");
        System.out.println("Total characters: " + countCharacters());
        System.out.println("Letters only: " + countLetters());
        System.out.println("Words: " + countWords());
        System.out.println("Spaces: " + countSpaces());
        
        // Additional analysis
        displayDetailedAnalysis();
    }
    
    private void displayDetailedAnalysis() {
        int digits = 0;
        int specialChars = 0;
        int upperCase = 0;
        int lowerCase = 0;
        
        for (char c : inputString.toCharArray()) {
            if (Character.isDigit(c)) {
                digits++;
            } else if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
                specialChars++;
            }
            
            if (Character.isUpperCase(c)) {
                upperCase++;
            } else if (Character.isLowerCase(c)) {
                lowerCase++;
            }
        }
        
        System.out.println("\n----- Detailed Analysis -----");
        System.out.println("Uppercase letters: " + upperCase);
        System.out.println("Lowercase letters: " + lowerCase);
        System.out.println("Digits: " + digits);
        System.out.println("Special characters: " + specialChars);
    }
    
    public void displayTokens() {
        if (inputString.trim().isEmpty()) {
            System.out.println("No tokens found in empty string.");
            return;
        }
        
        System.out.println("\n----- Word Tokens -----");
        StringTokenizer tokenizer = new StringTokenizer(inputString);
        int tokenIndex = 1;
        
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            System.out.println("Token " + tokenIndex + ": \"" + token + "\"");
            tokenIndex++;
        }
    }
}
