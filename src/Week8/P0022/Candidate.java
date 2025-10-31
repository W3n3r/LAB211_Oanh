/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week8.P0022;

/**
 *
 * @author tothi
 */
public abstract class Candidate {
    protected String id;
    protected String firstName;
    protected String lastName;
    protected int birthYear;
    protected String address;
    protected String phone;
    protected String email;
    protected int type; // 0: Experience, 1: Fresher, 2: Intern
    
    public abstract void abc();

    public Candidate(String id, String firstName, String lastName, int birthYear,
                     String address, String phone, String email, int type) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.type = type;
    }

    public String getFullName() {
        return lastName + " " + firstName;
    }

    public int getType() {
        return type;
    }

    @Override
    public String toString() {
        return id + " | " + getFullName() + " | " + birthYear + " | " + address + 
               " | " + phone + " | " + email;
    }
}