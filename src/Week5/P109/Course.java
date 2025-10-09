/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week5.P109;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author tothi
*/
public class Course {
    protected String courseID;
    protected String courseName;
    protected int credits;

    public Course() {
        this.courseID = "";
        this.courseName = "";
        this.credits = 0;
    }

    public Course(String courseID, String courseName, int credits) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.credits = credits;
    }

    public String getCourseID() { return courseID; }
    public void setCourseID(String courseID) { this.courseID = courseID; }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public int getCredits() { return credits; }
    public void setCredits(int credits) { this.credits = credits; }

    public String basicInfo() {
        return courseID + " - " + courseName + " - " + credits;
    }

    @Override
    public String toString() {
        return basicInfo();
    }

    public void InputAll(Scanner sc, ArrayList<Course> list) {
        while (true) {
            System.out.print("Course ID: ");
            String id = sc.nextLine().trim();
            if (id.isEmpty()) {
                System.out.println("Data input is invalid");
                continue;
            }
            boolean exists = false;
            for (Course c : list) {
                if (c.getCourseID().equals(id)) {
                    exists = true;
                    break;
                }
            }
            if (exists) {
                System.out.println("Data input is invalid, ID must be unique");
                continue;
            }
            this.courseID = id;
            break;
        }

        while (true) {
            System.out.print("Course name: ");
            String name = sc.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Data input is invalid");
                continue;
            }
            boolean exists = false;
            for (Course c : list) {
                if (c.getCourseName().equalsIgnoreCase(name)) {
                    exists = true;
                    break;
                }
            }
            if (exists) {
                System.out.println("Data input is invalid");
                continue;
            }
            this.courseName = name;
            break;
        }

        while (true) {
            System.out.print("Credits: ");
            String s = sc.nextLine().trim();
            try {
                int cr = Integer.parseInt(s);
                if (cr <= 0) {
                    System.out.println("Data input is invalid");
                    continue;
                }
                this.credits = cr;
                break;
            } catch (Exception e) {
                System.out.println("Data input is invalid");
            }
        }
    }
}
