package Week4.P0021;

import java.util.List;
import java.util.Scanner;

public class TestStudent {
    private final StudentManagement manager = new StudentManagement();
    private final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        new TestStudent().menu();
    }

    private void menu() {
        while (true) {
            System.out.println();
            System.out.println("=== Student Management ===");
            System.out.println("1. Add student");
            System.out.println("2. Find & sort (by name or semester)");
            System.out.println("3. Update or delete student");
            System.out.println("4. Report all students");
            System.out.println("5. Exit");
            System.out.print("Choose (1-5): ");

            int choice = readInt();
            switch (choice) {
                case 1 -> addStudent();
                case 2 -> findAndSort();
                case 3 -> updateOrDelete();
                case 4 -> manager.reportStudent();
                case 5 -> {
                    System.out.println("Exiting program...");
                    return;
                }
                default -> System.out.println("Invalid choice! Please choose 1-5.");
            }
        }
    }

    private int readInt() {
        try {
            String s = sc.nextLine();
            return Integer.parseInt(s.trim());
        } catch (Exception e) {
            return -1;
        }
    }

    private void addStudent() {
        System.out.print("Enter id: ");
        String id = sc.nextLine().trim();
        if (id.isEmpty()) {
            System.out.println("Id cannot be empty.");
            return;
        }
        if (manager.findById(id) != null) {
            System.out.println("Student with this id already exists.");
            return;
        }
        System.out.print("Enter name: ");
        String name = sc.nextLine().trim();
        System.out.print("Enter semester: ");
        String sem = sc.nextLine().trim();
        Student s = new Student(id, name, sem);
        if (manager.addStudent(s)) {
            System.out.println("Added successfully.");
        } else {
            System.out.println("Failed to add student.");
        }
    }

    private void findAndSort() {
        System.out.print("Enter search keyword (name or semester): ");
        String key = sc.nextLine().trim();
        if (key.isEmpty()) {
            System.out.println("Keyword empty. Showing all students sorted by name:");
            List<Student> all = manager.getAll();
            all.sort((a,b)-> a.getName().compareToIgnoreCase(b.getName()));
            all.forEach(System.out::println);
            return;
        }
        List<Student> res = manager.findAndSortByName(key);
        if (res.isEmpty()) {
            System.out.println("No matching students found.");
        } else {
            System.out.println("Found " + res.size() + " student(s):");
            res.forEach(System.out::println);
        }
    }

    private void updateOrDelete() {
        System.out.print("Enter id to update/delete: ");
        String id = sc.nextLine().trim();
        Student s = manager.findById(id);
        if (s == null) {
            System.out.println("Student not found.");
            return;
        }
        System.out.println("Found: " + s);
        System.out.print("Choose action: 1-Update, 2-Delete, other-Cancel: ");
        int a = readInt();
        if (a == 1) {
            System.out.print("New name (leave blank to keep): ");
            String newName = sc.nextLine();
            System.out.print("New semester (leave blank to keep): ");
            String newSem = sc.nextLine();
            boolean ok = manager.updateStudent(id, newName, newSem);
            System.out.println(ok ? "Updated." : "Update failed.");
        } else if (a == 2) {
            System.out.print("Are you sure to delete? (y/N): ");
            String confirm = sc.nextLine().trim().toLowerCase();
            if (confirm.equals("y") || confirm.equals("yes")) {
                boolean ok = manager.deleteStudent(id);
                System.out.println(ok ? "Deleted." : "Delete failed.");
            } else {
                System.out.println("Delete canceled.");
            }
        } else {
            System.out.println("Cancelled.");
        }
    }
}
