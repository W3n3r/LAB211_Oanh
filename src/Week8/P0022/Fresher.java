/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week8.P0022;

/**
 *
 * @author tothi
 */
public class Fresher extends Candidate {
    private int graduationYear;
    private String graduationRank;

    public Fresher(String id, String firstName, String lastName, int birthYear, String address,
                   String phone, String email, int graduationYear, String graduationRank) {
        super(id, firstName, lastName, birthYear, address, phone, email, 1);
        this.graduationYear = graduationYear;
        this.graduationRank = graduationRank;
    }

    @Override
    public String toString() {
        return super.toString() + " | Graduation: " + graduationYear + " | Rank: " + graduationRank;
    }

    @Override
    public void abc() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}