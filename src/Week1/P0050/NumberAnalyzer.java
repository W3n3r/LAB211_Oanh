/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week1.P0050;

/**
 *
 * @author tothi
 */

import java.util.ArrayList;
import java.util.List;

public class NumberAnalyzer {
    
    public boolean isOdd(double number) {
        return number == (int)number && (int)number % 2 != 0;
    }
    
    public boolean isEven(double number) {
        return number == (int)number && (int)number % 2 == 0 && number != 0;
    }
    
    public boolean isPerfectSquare(double number) {
        if (number < 0 || number != (int)number) return false;
        int sqrt = (int)Math.sqrt(number);
        return sqrt * sqrt == (int)number;
    }
    
    public void analyzeNumbers(double... numbers) {
        List<Double> oddNumbers = new ArrayList<>();
        List<Double> evenNumbers = new ArrayList<>();
        List<Double> perfectSquares = new ArrayList<>();
        
        for (double number : numbers) {
            if (isOdd(number)) oddNumbers.add(number);
            if (isEven(number)) evenNumbers.add(number);
            if (isPerfectSquare(number)) perfectSquares.add(number);
        }
        
        displayNumbers(oddNumbers, "Odd Number(s)");
        displayNumbers(evenNumbers, "Number is Even");
        displayNumbers(perfectSquares, "Number is Perfect Square");
    }
    
    private void displayNumbers(List<Double> numbers, String label) {
        if (!numbers.isEmpty()) {
            System.out.print(label + ": ");
            for (int i = 0; i < numbers.size(); i++) {
                System.out.print(numbers.get(i));
                if (i < numbers.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }
}
