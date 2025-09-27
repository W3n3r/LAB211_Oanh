/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week3.P0001;

import java.util.Random;

/**
 *
 * @author tothi
 */

public class BubbleSort {
    private final int[] array;

    public BubbleSort(int n) {
        this.array = new int[n];
        generateArray(n);
    }

    public void generateArray(int range) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(range);
        }
    }

    public void displayArray() {
        System.out.print("[");
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if(i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public void displayUnsortedArray() {
        System.out.print("Unsorted array: ");
        displayArray();
    }

    public void displaySortedArray() {
        System.out.print("Sorted array: ");
        displayArray();
    }

    public void bubbleSort() {
        int n = array.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
}