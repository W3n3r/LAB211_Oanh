/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week1.P0008;

import java.util.HashMap;
import java.util.StringTokenizer;

public class TextAnalyzer {

    
    public static HashMap<String, Integer> countWords(String input) {
        HashMap<String, Integer> wordCount = new HashMap<>();
        StringTokenizer tokenizer = new StringTokenizer(input);
        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        return wordCount;
    }

    
    public static HashMap<Character, Integer> countCharacters(String input) {
        HashMap<Character, Integer> charCount = new HashMap<>();
        for (char c : input.toCharArray()) {
            if (c != ' ') { 
                charCount.put(c, charCount.getOrDefault(c, 0) + 1);
            }
        }
        return charCount;
    }

   
    public static <K, V> void printMap(HashMap<K, V> map) {
        System.out.print("{");
        boolean first = true;
        for (K key : map.keySet()) {
            if (!first) System.out.print(", ");
            System.out.print(key + "=" + map.get(key));
            first = false;
        }
        System.out.println("}");
    }
}