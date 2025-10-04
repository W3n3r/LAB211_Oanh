/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week4.P105;

import java.time.Year;
import java.util.Scanner;

/**
 *
 * @author tothi
 */
public class Person {
    String ID;
    String FullName;
    String PhoneNumber;
    int YearOfBirth;
    String Major;

    public Person(String ID, String FullName, String PhoneNumber, int YearOfBirth, String Major) {
        this.ID = "";
        this.FullName = "";
        this.PhoneNumber = "";
        this.YearOfBirth = 0;
        this.Major = "";
    }
    public Person() {
        this.ID = "ID";
        this.FullName = FullName;
        this.PhoneNumber = PhoneNumber;
        this.YearOfBirth = YearOfBirth;
        this.Major = Major;
    }
    
    public void inputAll(Scanner sc) {
        while (true) {
            System.out.print("ID: ");
            String input = sc.nextLine().trim();
            if (input.matches("\\d{6}")) {
                this.ID = input;
                break;
            } else {
                System.out.println("Data input is invalid");
            }
        }
        while (true) {
            System.out.print("Fullname: ");
            String input = sc.nextLine().trim();
            if (input.matches("[a-zA-Z ]+")) {
                this.FullName = input;
                break;
            } else {
                System.out.println("Data input is invalid");
            }
        }
        while (true) {
            System.out.print("Phone number: ");
            String input = sc.nextLine().trim();
            if (input.matches("\\d{12}")) {
                this.PhoneNumber = input;
                break;
            } else {
                System.out.println("Data input is invalid");
            }
        }
        int currentYear = Year.now().getValue();
        while (true) {
            System.out.print("Year of birth: ");
            try {
                int y = Integer.parseInt(sc.nextLine().trim());
                if (y < currentYear) {
                    this.YearOfBirth = y;
                    break;
                } else {
                    System.out.println("Data input is invalid");
                }
            } catch (NumberFormatException e) {
                System.out.println("Data input is invalid");
            }
        }
        while (true) {
            System.out.print("Major: ");
            String input = sc.nextLine().trim();
            if (input.length() <= 30) {
                this.Major = input;
                break;
            } else {
                System.out.println("Data input is invalid");
            }
        }
    }

    @Override
    public String toString() {
        return ID + " - " + FullName + " - " + PhoneNumber + " - " + YearOfBirth + " - " + Major;
    }

    public String getFullName() { 
        return FullName; 
    }
    public int getYearOfBirth() { 
        return YearOfBirth; 
    }
    
}
