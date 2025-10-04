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
public class Student extends Person {
    
    private int yearOfAdmission;
    private int entranceEnglishScore;

    public Student() {
        super();
        this.yearOfAdmission = 0;
        this.entranceEnglishScore = 0;
    }

    @Override
    public void inputAll(Scanner sc) {
        super.inputAll(sc);
        int currentYear = Year.now().getValue();

        while (true) {
            System.out.print("Year of admission: ");
            try {
                int y = Integer.parseInt(sc.nextLine().trim());
                if (y >= YearOfBirth && y <= currentYear) {
                    this.yearOfAdmission = y;
                    break;
                } else {
                    System.out.println("Data input is invalid");
                }
            } catch (NumberFormatException e) {
                System.out.println("Data input is invalid");
            }
        }
        while (true) {
            System.out.print("Entrance English score: ");
            try {
                int s = Integer.parseInt(sc.nextLine().trim());
                if (s >= 0 && s <= 100) {
                    this.entranceEnglishScore = s;
                    break;
                } else {
                    System.out.println("Data input is invalid");
                }
            } catch (NumberFormatException e) {
                System.out.println("Data input is invalid");
            }
        }
    }

    @Override
    public String toString() {
        return super.toString() + " - " + yearOfAdmission + " - " + entranceEnglishScore;
    }

    public int getYearOfAdmission() { return yearOfAdmission; }
}
    
