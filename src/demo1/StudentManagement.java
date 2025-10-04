package Week4.P0021;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StudentManagement {
    private final List<Student> students = new ArrayList<>();

    public boolean addStudent(Student s) {
        if (s == null || s.getId() == null) return false;
        if (findById(s.getId()) != null) return false; // duplicate id not allowed
        students.add(s);
        return true;
    }

    public Student findById(String id) {
        if (id == null) return null;
        for (Student s : students) {
            if (id.equalsIgnoreCase(s.getId())) return s;
        }
        return null;
    }

    public List<Student> findByName(String name) {
        if (name == null) return new ArrayList<>();
        String key = name.toLowerCase();
        return students.stream()
                .filter(s -> s.getName() != null && s.getName().toLowerCase().contains(key))
                .collect(Collectors.toList());
    }

    public List<Student> findBySemester(String semester) {
        if (semester == null) return new ArrayList<>();
        String key = semester.toLowerCase();
        return students.stream()
                .filter(s -> s.getSemester() != null && s.getSemester().toLowerCase().contains(key))
                .collect(Collectors.toList());
    }

    public boolean updateStudent(String id, String newName, String newSemester) {
        Student s = findById(id);
        if (s == null) return false;
        if (newName != null && !newName.isBlank()) s.setName(newName);
        if (newSemester != null && !newSemester.isBlank()) s.setSemester(newSemester);
        return true;
    }

    public boolean deleteStudent(String id) {
        Student s = findById(id);
        if (s == null) return false;
        return students.remove(s);
    }

    public List<Student> getAll() {
        return new ArrayList<>(students);
    }

    public List<Student> findAndSortByName(String nameOrSemester) {
        // search in both name and semester then sort by name ascending
        List<Student> result = students.stream()
                .filter(s -> (s.getName()!=null && s.getName().toLowerCase().contains(nameOrSemester.toLowerCase()))
                          || (s.getSemester()!=null && s.getSemester().toLowerCase().contains(nameOrSemester.toLowerCase())))
                .sorted(Comparator.comparing(Student::getName, Comparator.nullsLast(String::compareToIgnoreCase)))
                .collect(Collectors.toList());
        return result;
    }

    public void reportStudent() {
        if (students.isEmpty()) {
            System.out.println("No students to show.");
            return;
        }
        System.out.println("---- Student report ----");
        for (Student s : students) {
            System.out.println(s);
        }
        System.out.println("------------------------");
    }
}
