/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week5.P109;

/**
 *
 * @author tothi
 */
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    private static final Scanner sc = new Scanner(System.in);
    private static final ArrayList<Course> courses = new ArrayList<>();
    private static final DateTimeFormatter DATE_FMT = DateTimeFormatter.ofPattern("d/M/yyyy");

    public static void main(String[] args) {
        int choice;
        do {
            showMenu();
            choice = readInt();
            switch (choice) {
                case 1 -> addCourse();
                case 2 -> updateCourse();
                case 3 -> deleteCourse();
                case 4 -> printCoursesMenu();
                case 5 -> searchByName();
                case 6 -> System.out.println("BYE AND SEE YOU NEXT TIME");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 6);
    }

    private static void showMenu() {
        System.out.println("\n*** Course Management ***");
        System.out.println("1. Add online course/ offline course");
        System.out.println("2. Update course");
        System.out.println("3. Delete course");
        System.out.println("4. Print all / online course / offline course");
        System.out.println("5. Search information base on course name");
        System.out.println("6. Exit");
        System.out.print("You choose: ");
    }

    private static void addCourse() {
        System.out.println("\n*** Add new course ***");

        String type;
        while (true) {
            System.out.print("Online (O) or Offline (F): ");
            type = sc.nextLine().trim().toUpperCase();
            if (type.equals("O") || type.equals("F")) break;
            System.out.println("Data input is invalid");
        }

        if (type.equals("O")) {
            System.out.println("Create new online course");
            OnlineCourse oc = new OnlineCourse();
            oc.InputAll(sc, courses);
            courses.add(oc);
            System.out.println("Added successfully.");
        } else {
            System.out.println("Create new offline course");
            OfflineCourse ofc = new OfflineCourse();
            ofc.InputAll(sc, courses);
            courses.add(ofc);
            System.out.println("Added successfully.");
        }
    }

    private static void updateCourse() {
        System.out.println("\n*** Update course ***");
        System.out.print("Course ID: ");
        String id = sc.nextLine().trim();
        Course c = findByCourseID(id);
        if (c == null) {
            System.out.print("No data found, do you want to find again? (Y/N): ");
            String ans = sc.nextLine().trim().toUpperCase();
            if (ans.equals("Y")) updateCourse();
            return;
        }

        System.out.println("\n*** Search results ***");
        System.out.println(displayCourseFull(c));
        System.out.println("\n*** Updating ***");
        System.out.println("Note: Enter empty if you don't want to change it.");

        System.out.print("Course ID: ");
        String newId = sc.nextLine().trim();
        if (!newId.isEmpty()) {
            Course other = findByCourseID(newId);
            if (other != null && other != c) {
                System.out.println("Course ID must be unique. Update aborted.");
                return;
            }
            c.setCourseID(newId);
        }

        System.out.print("Course name: ");
        String newName = sc.nextLine().trim();
        if (!newName.isEmpty()) {
            Course other = findByCourseName(newName);
            if (other != null && other != c) {
                System.out.println("Course name must be unique. Update aborted.");
                return;
            }
            c.setCourseName(newName);
        }

        System.out.print("Credits: ");
        String credStr = sc.nextLine().trim();
        if (!credStr.isEmpty()) {
            try {
                int newCredits = Integer.parseInt(credStr);
                if (newCredits <= 0) {
                    System.out.println("Invalid credits. Update aborted.");
                    return;
                }
                c.setCredits(newCredits);
            } catch (NumberFormatException ex) {
                System.out.println("Invalid credits format. Update aborted.");
                return;
            }
        }

        if (c instanceof OnlineCourse) {
            OnlineCourse oc = (OnlineCourse) c;

            System.out.print("Platform: ");
            String platform = sc.nextLine().trim();
            if (!platform.isEmpty()) oc.setPlatform(platform);

            System.out.print("Instructors: ");
            String instr = sc.nextLine().trim();
            if (!instr.isEmpty()) oc.setInstructors(instr);

            System.out.print("Note: ");
            String note = sc.nextLine().trim();
            if (!note.isEmpty()) oc.setNote(note);

        } else if (c instanceof OfflineCourse) {
            OfflineCourse ofc = (OfflineCourse) c;

            System.out.print("Begin (d/M/yyyy): ");
            String b = sc.nextLine().trim();
            System.out.print("End (d/M/yyyy): ");
            String e = sc.nextLine().trim();
            if (!b.isEmpty() && !e.isEmpty()) {
                try {
                    LocalDate begin = LocalDate.parse(b, DATE_FMT);
                    LocalDate end = LocalDate.parse(e, DATE_FMT);
                    LocalDate today = LocalDate.now();
                    if (!begin.isAfter(today) || !end.isAfter(today) || !begin.isBefore(end)) {
                        System.out.println("Data input is invalid, dates not updated.");
                    } else {
                        ofc.setBegin(begin);
                        ofc.setEnd(end);
                    }
                } catch (Exception ex) {
                    System.out.println("Date format invalid, dates not updated.");
                }
            }

            System.out.print("Campus: ");
            String campus = sc.nextLine().trim();
            if (!campus.isEmpty()) ofc.setCampus(campus);

            System.out.print("Teacher (instructors): ");
            String teacher = sc.nextLine().trim();
            if (!teacher.isEmpty()) ofc.setInstructors(teacher);
        }
    } // 👈 ĐÃ THÊM DẤU NGOẶC NÀY — kết thúc hàm updateCourse()

    private static void deleteCourse() {
        System.out.println("\n*** Delete course ***");
        System.out.print("Course ID: ");
        String id = sc.nextLine().trim();
        Course c = findByCourseID(id);
        if (c == null) {
            System.out.print("No data found, do you want to find again? (Y/N): ");
            String ans = sc.nextLine().trim().toUpperCase();
            if (ans.equals("Y")) deleteCourse();
            return;
        }
        System.out.println(displayCourseFull(c));
        System.out.print("Are you sure to delete? (Y/N): ");
        String confirm = sc.nextLine().trim().toUpperCase();
        if (confirm.equals("Y")) {
            courses.remove(c);
            System.out.println("Deleted successfully.");
        } else {
            System.out.println("Delete cancelled.");
        }
    }

    private static void printCoursesMenu() {
        System.out.println("\n*** Print course ***");
        System.out.print("Do you want to print all (A), online course (O) or offline course (F): ");
        String sel = sc.nextLine().trim().toUpperCase();
        switch (sel) {
            case "A" -> printAll();
            case "O" -> printOnline();
            case "F" -> printOffline();
            default -> System.out.println("Invalid choice.");
        }
    }

    private static void printAll() {
        if (courses.isEmpty()) {
            System.out.println("No data to view");
            return;
        }
        System.out.println("Course ID - Course name - Credits");
        for (Course c : courses) {
            System.out.println(c.getCourseID() + "-" + c.getCourseName() + "-" + c.getCredits());
        }
    }

    private static void printOnline() {
        boolean found = false;
        System.out.println("Course ID-Course name-Credits-Platform-Instructors-Note");
        for (Course c : courses) {
            if (c instanceof OnlineCourse oc) {
                System.out.println(oc.getCourseID() + "-" + oc.getCourseName() + "-" + oc.getCredits()
                        + "-" + oc.getPlatform() + "-" + oc.getInstructors() + "-" + oc.getNote());
                found = true;
            }
        }
        if (!found) System.out.println("No online courses.");
    }

    private static void printOffline() {
        boolean found = false;
        System.out.println("Course ID-Course name-Credits-Begin-End-Campus-Instructors");
        for (Course c : courses) {
            if (c instanceof OfflineCourse ofc) {
                System.out.println(ofc.getCourseID() + "-" + ofc.getCourseName() + "-" + ofc.getCredits()
                        + "-" + ofc.getBegin().format(DATE_FMT) + "-" + ofc.getEnd().format(DATE_FMT)
                        + "-" + ofc.getCampus() + "-" + ofc.getInstructors());
                found = true;
            }
        }
        if (!found) System.out.println("No offline courses.");
    }

    private static void searchByName() {
        System.out.println("\n*** Searching ***");
        System.out.print("Course name: ");
        String name = sc.nextLine().trim();
        Course found = findByCourseName(name);
        if (found == null) {
            System.out.print("No data found, do you want to find again? (Y/N): ");
            String ans = sc.nextLine().trim().toUpperCase();
            if (ans.equals("Y")) searchByName();
            return;
        }
        System.out.println("\n*** Search results ***");
        System.out.println(displayCourseFull(found));
    }

    private static Course findByCourseID(String id) {
        for (Course c : courses)
            if (c.getCourseID().equals(id))
                return c;
        return null;
    }

    private static Course findByCourseName(String name) {
        for (Course c : courses)
            if (c.getCourseName().equalsIgnoreCase(name))
                return c;
        return null;
    }

    private static String displayCourseFull(Course c) {
        if (c instanceof OnlineCourse oc) {
            return "Course ID: " + oc.getCourseID() + "\nCourse name: " + oc.getCourseName() +
                    "\nCredits: " + oc.getCredits() + "\nPlatform: " + oc.getPlatform() +
                    "\nInstructors: " + oc.getInstructors() + "\nNote: " + oc.getNote();
        } else if (c instanceof OfflineCourse ofc) {
            return "Course ID: " + ofc.getCourseID() + "\nCourse name: " + ofc.getCourseName() +
                    "\nCredits: " + ofc.getCredits() + "\nBegin: " + ofc.getBegin().format(DATE_FMT) +
                    "\nEnd: " + ofc.getEnd().format(DATE_FMT) + "\nCampus: " + ofc.getCampus() +
                    "\nInstructors: " + ofc.getInstructors();
        } else {
            return c.toString();
        }
    }

    private static int readInt() {
        try {
            String line = sc.nextLine().trim();
            return Integer.parseInt(line);
        } catch (Exception e) {
            return -1;
        }
    }
}
