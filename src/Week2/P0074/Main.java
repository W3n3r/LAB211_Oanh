/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week2.P0074;

import java.util.Scanner;

/**
 *
 * @author tothi
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("========= Calculator Program =========");
            System.out.println("1. Addition Matrix");
            System.out.println("2. Subtraction Matrix");
            System.out.println("3. Multiplication Matrix");
            System.out.println("4. Quit");
            System.out.print("Your choice ");

            int choice;
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
            } else {
                System.out.println("Value of matrix is digit");
                sc.next();
                continue;
            }

            if (choice == 4) {
                System.out.println("Exit the program...");
                break;
            }

            System.out.print("Enter Row Matrix 1:");
            int rowA = sc.nextInt();
            System.out.print("Enter Column Matrix 1:");
            int colA = sc.nextInt();
            Matrix A = new Matrix(rowA, colA);
            A.input(sc, "Matrix1");

            System.out.print("Enter Row Matrix 2:");
            int rowB = sc.nextInt();
            System.out.print("Enter Column Matrix 2:");
            int colB = sc.nextInt();
            Matrix B = new Matrix(rowB, colB);
            B.input(sc, "Matrix2");

            try {
                Matrix result = null;
                String op = "";
                switch (choice) {
                    case 1:
                        result = A.additionMatrix(B);
                        op = "+";
                        break;
                    case 2:
                        result = A.subtractionMatrix(B);
                        op = "-";
                        break;
                    case 3:
                        result = A.multiplicationMatrix(B);
                        op = "*";
                        break;
                    default:
                        System.out.println("Invalid choice, please select 1-4");
                }

                if (result != null) {
                    System.out.println("-------- Result --------");
                    A.display();
                    System.out.println(op);
                    B.display();
                    System.out.println("=");
                    result.display();
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        sc.close();
    }
}
