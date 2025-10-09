/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week5.P109;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author tothi
 */

public class OfflineCourse extends Course {
    private LocalDate begin;
    private LocalDate end;
    private String campus;
    private String instructors; // teacher name

    public OfflineCourse() {
        super();
        this.begin = LocalDate.now();
        this.end = LocalDate.now();
        this.campus = "";
        this.instructors = "";
    }

    public OfflineCourse(String courseID, String courseName, int credits,
                         LocalDate begin, LocalDate end, String campus, String instructors) {
        super(courseID, courseName, credits);
        this.begin = begin;
        this.end = end;
        this.campus = campus;
        this.instructors = instructors;
    }

    public LocalDate getBegin() { return begin; }
    public void setBegin(LocalDate begin) { this.begin = begin; }

    public LocalDate getEnd() { return end; }
    public void setEnd(LocalDate end) { this.end = end; }

    public String getCampus() { return campus; }
    public void setCampus(String campus) { this.campus = campus; }

    public String getInstructors() { return instructors; }
    public void setInstructors(String instructors) { this.instructors = instructors; }

    @Override
    public String toString() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("d/M/yyyy");
        return courseID + " - " + courseName + " - " + credits + " - " +
               begin.format(f) + " - " + end.format(f) + " - " + campus + " - " + instructors;
    }

    @Override
    public void InputAll(Scanner sc, ArrayList<Course> list) {
        super.InputAll(sc, list);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("d/M/yyyy");
        LocalDate today = LocalDate.now();
        while (true) {
            System.out.print("Begin (d/M/yyyy): ");
            String bStr = sc.nextLine().trim();
            System.out.print("End (d/M/yyyy): ");
            String eStr = sc.nextLine().trim();
            LocalDate b, e;
            try {
                b = LocalDate.parse(bStr, fmt);
                e = LocalDate.parse(eStr, fmt);
            } catch (Exception ex) {
                System.out.println("Data input is invalid");
                continue;
            }
            if (!b.isAfter(today) || !e.isAfter(today)) {
                System.out.println("Data input is invalid");
                continue;
            }
            if (!b.isBefore(e)) {
                System.out.println("Data input is invalid, end must be after begin");
                continue;
            }
            this.begin = b;
            this.end = e;
            break;
        }

        while (true) {
            System.out.print("Campus: ");
            String c = sc.nextLine().trim();
            if (c.isEmpty()) {
                System.out.println("Data input is invalid");
                continue;
            }
            this.campus = c;
            break;
        }

        while (true) {
            System.out.print("Teacher (instructors): ");
            String t = sc.nextLine().trim();
            if (t.isEmpty()) {
                System.out.println("Data input is invalid");
                continue;
            }
            this.instructors = t;
            break;
        }
    }
}