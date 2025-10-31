/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week8.P0022;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author tothi
 */

public class Main {
    private final Scanner sc = new Scanner(System.in);
    private final CandidateManagement manager = new CandidateManagement();

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        seedData();

        while (true) {
            printMenu();
            int choice = readInt("Choose: ");
            switch (choice) {
                case 1:
                    createExperienceCandidates();
                    showGroupedNames();
                    break;
                case 2:
                    createFresherCandidates();
                    showGroupedNames();
                    break;
                case 3:
                    createInternCandidates();
                    showGroupedNames();
                    break;
                case 4:
                    searchCandidates();
                    break;
                case 5:
                    System.out.println("Exiting program. Goodbye!");
                    return;
                default:
                    System.out.println("Please choose from 1 to 5.");
            }
        }
    }

    private void printMenu() {
        System.out.println();
        System.out.println("CANDIDATE MANAGEMENT SYSTEM");
        System.out.println("1. Experience");
        System.out.println("2. Fresher");
        System.out.println("3. Internship");
        System.out.println("4. Searching");
        System.out.println("5. Exit");
        System.out.println("(Please choose 1 to Create Experience Candidate, 2 to Create Fresher Candidate, 3 to Internship Candidate,");
        System.out.println(" 4 to Searching and 5 to Exit program).");
    }

    private void createExperienceCandidates() {
        do {
            System.out.println("\nCreate Experience Candidate");
            String id = readNonEmpty("Candidate ID: ");
            String first = readNonEmpty("First Name: ");
            String last = readNonEmpty("Last Name: ");
            int birth = readBirthYear("Birth Year (1900..current): ");

            String address = readNonEmpty("Address: ");
            String phone = readPhone("Phone (>=10 digits): ");
            String email = readEmail("Email (account@domain): ");

            int exp = readIntInRange("Years of Experience (0..100): ", 0, 100);
            String skill = readNonEmpty("Professional Skill: ");

            manager.addCandidate(new Experience(id, first, last, birth, address, phone, email, exp, skill));
            System.out.println("Added Experience candidate: " + last + " " + first);
        } while (readYesNo("Do you want to continue (Y/N)? "));
    }

    private void createFresherCandidates() {
        do {
            System.out.println("\nCreate Fresher Candidate");
            String id = readNonEmpty("Candidate ID: ");
            String first = readNonEmpty("First Name: ");
            String last = readNonEmpty("Last Name: ");
            int birth = readBirthYear("Birth Year (1900..current): ");

            String address = readNonEmpty("Address: ");
            String phone = readPhone("Phone (>=10 digits): ");
            String email = readEmail("Email (account@domain): ");

            int gradYear = readIntInRange("Graduation Year (1900..current): ", 1900, Year.now().getValue());
            String rank = readRank("Graduation rank (Excellence, Excellent, Good, Fair, Poor): ");

            manager.addCandidate(new Fresher(id, first, last, birth, address, phone, email, gradYear, rank));
            System.out.println("Added Fresher candidate: " + last + " " + first);
        } while (readYesNo("Do you want to continue (Y/N)? "));
    }

    private void createInternCandidates() {
        do {
            System.out.println("\nCreate Intern Candidate");
            String id = readNonEmpty("Candidate ID: ");
            String first = readNonEmpty("First Name: ");
            String last = readNonEmpty("Last Name: ");
            int birth = readBirthYear("Birth Year (1900..current): ");

            String address = readNonEmpty("Address: ");
            String phone = readPhone("Phone (>=10 digits): ");
            String email = readEmail("Email (account@domain): ");

            String major = readNonEmpty("Major: ");
            int semester = readIntInRange("Semester (1..12): ", 1, 12);

            manager.addCandidate(new Intern(id, first, last, birth, address, phone, email, major, semester));
            System.out.println("Added Intern candidate: " + last + " " + first);
        } while (readYesNo("Do you want to continue (Y/N)? "));
    }

    private void searchCandidates() {
        System.out.println();
        showGroupedNames();

        String name = readNonEmpty("Input Candidate name (First name or Last name): ");
        int type = readIntInSet("Input type of candidate (0-Experience, 1-Fresher, 2-Intern): ", new int[]{0, 1, 2});

        List<Candidate> resultByName = manager.searchByName(name);
        List<Candidate> filtered = new ArrayList<>();
        for (Candidate c : resultByName) {
            if (c.getType() == type) filtered.add(c);
        }

        System.out.println("The candidates found:");
        if (filtered.isEmpty()) {
            System.out.println("(No matches)");
        } else {
            for (Candidate c : filtered) {
                System.out.println(c.toString() + " | " + c.getType());
            }
        }
    }

    private void showGroupedNames() {
        System.out.println("List of candidate:");
        showNamesOfType(0, "===========EXPERIENCE CANDIDATE============");
        showNamesOfType(1, "==========FRESHER CANDIDATE==============");
        showNamesOfType(2, "===========INTERN CANDIDATE==============");
    }

    private void showNamesOfType(int type, String header) {
        System.out.println(header);
        List<Candidate> all = manager.searchByName("");
        for (Candidate c : all) {
            if (c.getType() == type) {
                System.out.println(c.getFullName());
            }
        }
    }

    private String readNonEmpty(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.println("Input cannot be empty. Please try again.");
        }
    }

    private int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }

    private int readIntInRange(String prompt, int min, int max) {
        while (true) {
            int v = readInt(prompt);
            if (v >= min && v <= max) return v;
            System.out.printf("Please enter a number in range [%d..%d].%n", min, max);
        }
    }

    private int readIntInSet(String prompt, int[] allowed) {
        while (true) {
            int v = readInt(prompt);
            for (int a : allowed) if (a == v) return v;
            System.out.print("Invalid choice. Allowed: ");
            for (int a : allowed) System.out.print(a + " ");
            System.out.println();
        }
    }

    private int readBirthYear(String prompt) {
        while (true) {
            int y = readInt(prompt);
            int current = Year.now().getValue();
            if (y >= 1900 && y <= current) return y;
            System.out.println("Birth year must be 4 digits between 1900 and current year.");
        }
    }

    private String readPhone(String prompt) {
        while (true) {
            String p = readNonEmpty(prompt);
            if (p.matches("\\d{10,}")) return p;
            System.out.println("Phone must be digits only and at least 10 digits.");
        }
    }

    private String readEmail(String prompt) {
        while (true) {
            String e = readNonEmpty(prompt);
            if (e.matches("^[\\w.+\\-]+@[\\w\\-]+(\\.[\\w\\-]+)+$")) return e;
            System.out.println("Invalid email format (account@domain).");
        }
    }

    private String readRank(String prompt) {
        while (true) {
            String r = readNonEmpty(prompt).trim().toUpperCase(Locale.ROOT);
            if (r.equals("EXCELLENCE") || r.equals("EXCELLENT") || r.equals("GOOD") || r.equals("FAIR") || r.equals("POOR")) {
                String lower = r.toLowerCase(Locale.ROOT);
                return Character.toUpperCase(lower.charAt(0)) + lower.substring(1);
            }
            System.out.println("Rank must be one of: Excellence, Excellent, Good, Fair, Poor.");
        }
    }

    private boolean readYesNo(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            if (s.equalsIgnoreCase("Y")) return true;
            if (s.equalsIgnoreCase("N")) return false;
            System.out.println("Please enter Y or N.");
        }
    }

    private void seedData() {
        manager.addCandidate(new Experience("E01", "John", "Smith", 1986, "NY",
                "1234567890", "john@gmail.com", 5, "Java"));
        manager.addCandidate(new Fresher("F01", "Anna", "Lee", 1999, "LA",
                "6543217890", "anna@gmail.com", 2021, "Excellence"));
        manager.addCandidate(new Intern("I01", "Tom", "Brown", 2003, "TX",
                "9876543210", "tom@gmail.com", "Computer Science", 6));
        manager.addCandidate(new Fresher("F03", "Xuan", "Vo", 2000, "VN",
                "0123456789", "xuan@gmail.com", 2020, "Good"));
        manager.addCandidate(new Intern("F04", "A", "Nguyen", 2005, "HA",
                "0987654321", "a@gmail.com", "SE", 3));
    }
}