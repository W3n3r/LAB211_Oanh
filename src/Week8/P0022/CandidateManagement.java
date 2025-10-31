/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week8.P0022;

/**
 *
 * @author tothi
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class CandidateManagement {
    private ArrayList<Candidate> candidates = new ArrayList<>();

    public void addCandidate(Candidate c) {
        candidates.add(c);
    }

    public void showAll() {
        for (Candidate c : candidates) {
            System.out.println(c);
        }
    }

    public List<Candidate> searchByName(String keyword) {
        List<Candidate> result = new ArrayList<>();
        for (Candidate c : candidates) {
            if (c.getFullName().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(c);
            }
        }
        return result;
    }
}