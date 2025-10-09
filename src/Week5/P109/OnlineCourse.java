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
public class OnlineCourse extends Course {
    private String platform;
    private String instructors;
    private String note;

    public OnlineCourse() {
        super();
        this.platform = "";
        this.instructors = "";
        this.note = "";
    }

    public OnlineCourse(String courseID, String courseName, int credits,
                        String platform, String instructors, String note) {
        super(courseID, courseName, credits);
        this.platform = platform;
        this.instructors = instructors;
        this.note = note;
    }

    public String getPlatform() { return platform; }
    public void setPlatform(String platform) { this.platform = platform; }

    public String getInstructors() { return instructors; }
    public void setInstructors(String instructors) { this.instructors = instructors; }

    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }

    @Override
    public String toString() {
        return courseID + " - " + courseName + " - " + credits + " - " +
               platform + " - " + instructors + " - " + note;
    }

    @Override
    public void InputAll(Scanner sc, ArrayList<Course> list) {
        super.InputAll(sc, list);

        while (true) {
            System.out.print("Platform: ");
            String p = sc.nextLine().trim();
            if (p.isEmpty()) {
                System.out.println("Data input is invalid");
                continue;
            }
            this.platform = p;
            break;
        }

        System.out.print("Instructors: ");
        this.instructors = sc.nextLine().trim();

        while (true) {
            System.out.print("Note: ");
            String n = sc.nextLine().trim();
            if (n.isEmpty()) {
                System.out.println("Data input is invalid");
                continue;
            }
            this.note = n;
            break;
        }
    }
}