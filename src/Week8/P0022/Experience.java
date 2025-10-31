/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week8.P0022;

/**
 *
 * @author tothi
 */
public class Experience extends Candidate {
    private int expInYear;
    private String proSkill;

    public Experience(String id, String firstName, String lastName, int birthYear, String address,
                      String phone, String email, int expInYear, String proSkill) {
        super(id, firstName, lastName, birthYear, address, phone, email, 0);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    @Override
    public String toString() {
        return super.toString() + " | Exp: " + expInYear + " | Skill: " + proSkill;
    }

    @Override
    public void abc() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
