/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week1.P0010;

import java.util.Random;

/**
 *
 * @author tothi
 */

public class LinearSearch {
    private final int[] array;
    
    public LinearSearch(int n) {
        this.array = new int[n];
    }
    
    public void generateArray(int range) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(range);
        }
    }
    
    public void displayArray() {
        System.out.print("Array: ");
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    
    public int search(int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
