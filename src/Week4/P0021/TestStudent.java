/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week4.P0021;


/**
 *
 * @author tothi
 */

import java.util.Scanner;

public class TestStudent {
    public static void main(String[] args) {
        StudentManagement manager = new StudentManagement();
        Scanner sc = new Scanner(System.in);
        
        int choice;

        while (true) {
            System.out.println("WELCOME TO STUDENT MANAGEMENT");
            System.out.println("1. Create");
            System.out.println("2. Find and Sort");
            System.out.println("3. Update/Delete");
            System.out.println("4. Report");
            System.out.println("5. Exit");
            System.out.print("Please choose 1 to Create, 2 to Find and Sort, 3 to Update/Delete, 4 to Report and 5 to Exit program: ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> manager.createStudent();
                case 2 -> manager.findAndSort();
                case 3 -> manager.updateOrDelete();
                case 4 -> manager.reportStudent();
                case 5 -> {
                    System.out.println("Exiting program...");
                    return;
                }
                default -> System.out.println("Invalid choice! Please choose 1-5.");
            }
        }
    }
}
