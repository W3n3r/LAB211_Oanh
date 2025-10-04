/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week4.P105;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author tothi
 */
public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static List<Teacher> teachers = new ArrayList<>();
    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n*** Information Management ***");
            System.out.println("1. Teacher");
            System.out.println("2. Student");
            System.out.println("3. Person");
            System.out.println("4. Exit");
            System.out.print("You choose: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1" -> teacherMenu();
                case "2" -> studentMenu();
                case "3" -> personMenu();
                case "4" -> {
                    System.out.println("BYE AND SEE YOU NEXT TIME"); return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private static void teacherMenu() {
        OUTER:
        while (true) {
            System.out.println("\n*** Teacher Management ***");
            System.out.println("1. Input");
            System.out.println("2. Print");
            System.out.println("3. Exit");
            System.out.print("You choose: ");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    Teacher t = new Teacher();
                    t.inputAll(sc);
                    teachers.add(t);
                    break;
                case "2":
                    teachers.sort((a,b) -> b.getYearInProfession() - a.getYearInProfession());
                    System.out.println(" - ID - Fullname - Phone - Year - Major - YearInProfession - Contract - Salary");
                    int i=1;
                    for (Teacher teacher : teachers) {
                        System.out.println(i++ + " - " + teacher);
                    }   break;
                case "3":
                    break OUTER;
                default:
                    break;
            }
        }
    }

    private static void studentMenu() {
        while (true) {
            System.out.println("\n*** Student Management ***");
            System.out.println("1. Input");
            System.out.println("2. Print");
            System.out.println("3. Exit");
            System.out.print("You choose: ");
            String choice = sc.nextLine();

            if (choice.equals("1")) {
                Student s1 = new Student();
                s1.inputAll(sc);
                students.add(s1);
            } else if (choice.equals("2")) {
                students.sort(Comparator.comparing(Student::getYearOfAdmission));
                System.out.println("# - ID - Fullname - Phone - Year - Major - YearAdmission - EnglishScore");
                int i=1;
                for (Student s : students) {
                    System.out.println(i++ + " - " + s);
                }
            } else if (choice.equals("3")) break;
        }
    }

    private static void personMenu() {
        while (true) {
            System.out.println("\n*** Person Management ***");
            System.out.println("1. Search");
            System.out.println("2. Print all");
            System.out.println("3. Exit");
            System.out.print("You choose: ");
            String choice = sc.nextLine();

            if (choice.equals("1")) {
                System.out.print("Name: ");
                String key = sc.nextLine().toLowerCase();
                List<Person> all = new ArrayList<>();
                all.addAll(teachers);
                all.addAll(students);
                List<Person> result = new ArrayList<>();
                for (Person p : all) {
                    if (p.getFullName().toLowerCase().contains(key)) result.add(p);
                }
                if (result.isEmpty()) {
                    System.out.println("Result: not found");
                } else {
                    System.out.println("Result:");
                    System.out.println("# - ID - Fullname - Phone - Year - Major");
                    int i=1;
                    for (Person p : result) {
                        System.out.println(i++ + " - " + p.ID + " - " + p.FullName + " - " + p.PhoneNumber + " - " + p.YearOfBirth + " - " + p.Major);    
                    }
                }
            } else if (choice.equals("2")) {
                List<Person> all = new ArrayList<>();
                all.addAll(teachers);
                all.addAll(students);
                all.sort((a,b) -> b.getYearOfBirth() - a.getYearOfBirth());
                System.out.println("# - ID - Fullname - Phone - Year - Major");
                int i=1;
                for (Person p : all) {
                    System.out.println(i++ + " - " + p.ID + " - " + p.FullName + " - " + p.PhoneNumber + " - " + p.YearOfBirth + " - " + p.Major);
                }
            } else if (choice.equals("3")) break;
        }
    }    
}
