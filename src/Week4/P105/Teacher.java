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
public class Teacher extends Person {
    private int yearInProfession;
    private String contractType;
    private double salaryCoefficient;

    public Teacher() {
        super();
        this.yearInProfession = 0;
        this.contractType = "";
        this.salaryCoefficient = 0;
    }

    /**
     *
     * @param sc
     */
    @Override
    public void inputAll(Scanner sc) {
        super.inputAll(sc);
        int age = Year.now().getValue() - YearOfBirth;

        while (true) {
            System.out.print("Year in the profession: ");
            try {
                int y = Integer.parseInt(sc.nextLine().trim());
                if (y >= 0 && y < age) {
                    this.yearInProfession = y;
                    break;
                } else {
                    System.out.println("Data input is invalid");
                }
            } catch (NumberFormatException e) {
                System.out.println("Data input is invalid");
            }
        }
        while (true) {
            System.out.print("Contract type (Long/Short): ");
            String input = sc.nextLine().trim();
            if (input.equalsIgnoreCase("Long") || input.equalsIgnoreCase("Short")) {
                this.contractType = input;
                break;
            } else {
                System.out.println("Data input is invalid");
            }
        }
        while (true) {
            System.out.print("Salary coefficient: ");
            try {
                double s = Double.parseDouble(sc.nextLine().trim());
                if (s >= 0) {
                    this.salaryCoefficient = s;
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
        return super.toString() + " - " + yearInProfession + " - " + contractType + " - " + salaryCoefficient;
    }

    public int getYearInProfession() { return yearInProfession; }
}