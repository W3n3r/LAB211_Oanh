//package Week4.P0021;
//
//public class Student {
//    private String id;
//    private String name;
//    private String semester;
//
//    public Student() { }
//
//    public Student(String id, String name, String semester) {
//        this.id = id;
//        this.name = name;
//        this.semester = semester;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getSemester() {
//        return semester;
//    }
//
//    public void setSemester(String semester) {
//        this.semester = semester;
//    }
//
//    @Override
//    public String toString() {
//        return String.format("ID: %s | Name: %s | Semester: %s", id, name, semester);
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Student)) return false;
//        Student s = (Student) o;
//        return id != null && id.equalsIgnoreCase(s.id);
//    }
//
//    @Override
//    public int hashCode() {
//        return id == null ? 0 : id.toLowerCase().hashCode();
//    }
//}
