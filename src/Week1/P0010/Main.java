/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week1.P0010;

/**
 *
 * @author tothi
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("========= Linear Search Program =========");
        
        int size = Validator.checkNumber("Enter number of array: ");
        LinearSearch linearSearch = new LinearSearch(size);

        int range = Validator.checkNumber("Enter range of random numbers: ");
        linearSearch.generateArray(range);

        linearSearch.displayArray();

        int searchNum = Validator.checkNumber("Enter search number: ");
        int result = linearSearch.search(searchNum);

        if (result >= 0) {
            System.out.println("Found " + searchNum + " at index: " + result);
        } else {
            System.out.println(searchNum + " not found in array");
        }
    }
}