/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week4.P0021;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author tothi
 */
public class StudentManagement {
    List<Student> studentList = new ArrayList();
    Scanner sc = new Scanner(System.in);
    
    public void createStudent() {
        int count = 0;
        while (true) {
            System.out.print("Enter ID: ");
            String id = sc.nextLine();
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Semester: ");
            String semester = sc.nextLine();
            System.out.print("Enter Course (Java/.Net/C/C++): ");
            String course = sc.nextLine();

            studentList.add(new Student(id, name, semester, course));
            count++;

            if (count >= 3) {
                System.out.print("Do you want to continue (Y/N)? ");
                String choice = sc.nextLine();
                if (choice.equalsIgnoreCase("N")) {
                    break;
                }
            }
        }
    }

    // 2. Find and Sort
    public void findAndSort() {
        if (studentList.isEmpty()) {
            System.out.println("No students in the list.");
            return;
        }

        System.out.print("Enter name to search: ");
        String keyword = sc.nextLine().toLowerCase();

        List<Student> result = new ArrayList<>();
        for (Student s : studentList) {
            if (s.getName().toLowerCase().contains(keyword)) {
                result.add(s);
            }
        }

        if (result.isEmpty()) {
            System.out.println("No student found!");
        } else {
            Collections.sort(result, Comparator.comparing(Student::getName));
            System.out.println("Result:");
            for (Student s : result) {
                System.out.println(s.getName() + " | " + s.getSemester() + " | " + s.getCourse());
            }
        }
    }

    // 3. Update/Delete
    public void updateOrDelete() {
        if (studentList.isEmpty()) {
            System.out.println("No students to update/delete.");
            return;
        }

        System.out.print("Enter student ID: ");
        String id = sc.nextLine();

        Student found = null;
        for (Student s : studentList) {
            if (s.getId().equalsIgnoreCase(id)) {
                found = s;
                break;
            }
        }

        if (found == null) {
            System.out.println("Student not found!");
            return;
        }

        System.out.print("Do you want to update (U) or delete (D)? ");
        String choice = sc.nextLine();

        if (choice.equalsIgnoreCase("U")) {
            System.out.print("Enter new name: ");
            found.setName(sc.nextLine());
            System.out.print("Enter new semester: ");
            found.setSemester(sc.nextLine());
            System.out.print("Enter new course: ");
            found.setCourse(sc.nextLine());
            System.out.println("Student updated!");
        } else if (choice.equalsIgnoreCase("D")) {
            studentList.remove(found);
            System.out.println("Student deleted!");
        } else {
            System.out.println("Invalid choice.");
        }
    }  
    public void reportStudent(){
        Map<String, Integer> report = new HashMap<>();
        for (Student student : studentList) {
            String key = student.getId()+"|"+student.getSemester()+"|"+student.getCourse();
            report.put(key, report.getOrDefault(key, 0) +1);
        }
        for (Map.Entry<String, Integer> student : report.entrySet()) {
            System.out.println(student.getKey()+ "|"+student.getValue());
            
        }
    }
}
