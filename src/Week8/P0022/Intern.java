/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week8.P0022;

/**
 *
 * @author tothi
 */
public class Intern extends Candidate {
    private String major;
    private int semester;

    public Intern(String id, String firstName, String lastName, int birthYear, String address,
                  String phone, String email, String major, int semester) {
        super(id, firstName, lastName, birthYear, address, phone, email, 2);
        this.major = major;
        this.semester = semester;
    }

    @Override
    public String toString() {
        return super.toString() + " | Major: " + major + " | Semester: " + semester;
    }

    @Override
    public void abc() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}