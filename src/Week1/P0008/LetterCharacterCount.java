/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week1.P0008;

import java.util.HashMap;
import java.util.Scanner;

public class LetterCharacterCount {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.println("Enter your content:");
        String input = scanner.nextLine();

        
        HashMap<String, Integer> wordCount = TextAnalyzer.countWords(input);
        System.out.println("Word count:");
        TextAnalyzer.printMap(wordCount);

        
        HashMap<Character, Integer> charCount = TextAnalyzer.countCharacters(input);
        System.out.println("Character count:");
        TextAnalyzer.printMap(charCount);

        scanner.close();
    }
}
