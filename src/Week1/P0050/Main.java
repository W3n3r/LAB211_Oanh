/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week1.P0050;

/**
 *
 * @author tothi
 */

public class Main {
    public static void main(String[] args) {
        EquationSolver solver = new EquationSolver();
        
        while (true) {
            solver.displayMenu();
            int choice = Validator.checkChoice("Please choice one option: ");
            
            switch (choice) {
                case 1 -> solver.solveLinearEquation();
                case 2 -> solver.solveQuadraticEquation();
                case 3 -> {
                    System.out.println("Goodbye!");
                    return;
                }
            }
        }
    }
}