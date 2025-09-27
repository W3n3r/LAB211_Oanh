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
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of array: ");
        int n = scanner.nextInt();
        
        while(n <= 0) {
            System.out.print("Please enter a positive number: ");
            n = scanner.nextInt();
        }

        
        BubbleSort bubbleSort = new BubbleSort(n);
           
        bubbleSort.displayUnsortedArray();
        bubbleSort.bubbleSort();
        bubbleSort.displaySortedArray();
        
        scanner.close();
    }
}
