/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week1.P0050;

/**
 *
 * @author tothi
 */
import java.util.ArrayList;
import java.util.List;

public class EquationSolver {
    private NumberAnalyzer analyzer;
    
    public EquationSolver() {
        this.analyzer = new NumberAnalyzer();
    }
    
    public void displayMenu() {
        System.out.println("\n========= Equation Program =========");
        System.out.println("1. Calculate Superlative Equation");
        System.out.println("2. Calculate Quadratic Equation");
        System.out.println("3. Exit");
    }
    
    public List<Double> calculateEquation(double a, double b) {
        List<Double> solutions = new ArrayList<>();
        
        if (a == 0) {
            if (b == 0) {
                // Infinitely many solutions - return empty list
                return solutions;
            } else {
                // No solution - return null
                return null;
            }
        } else {
            // One solution: x = -b/a
            double x = -b / a;
            solutions.add(x);
            return solutions;
        }
    }
    
    public List<Double> calculateQuadraticEquation(double a, double b, double c) {
        List<Double> solutions = new ArrayList<>();
        
        if (a == 0) {
            // Becomes linear equation
            return calculateEquation(b, c);
        }
        
        double delta = b * b - 4 * a * c;
        
        if (delta < 0) {
            // No real solutions
            return null;
        } else if (delta == 0) {
            // One solution
            double x = -b / (2 * a);
            solutions.add(x);
        } else {
            // Two solutions
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            solutions.add(x1);
            solutions.add(x2);
        }
        
        return solutions;
    }
    
    public void solveLinearEquation() {
        System.out.println("\n----- Calculate Equation -----");
        
        double a = Validator.checkDouble("Enter A: ");
        double b = Validator.checkDouble("Enter B: ");
        
        List<Double> solutions = calculateEquation(a, b);
        
        if (solutions == null) {
            System.out.println("Solution: No solution");
        } else if (solutions.isEmpty()) {
            System.out.println("Solution: Infinitely many solutions");
        } else {
            System.out.printf("Solution: x = %.3f\n", solutions.get(0));
        }
        
        analyzer.analyzeNumbers(a, b);
    }
    
    public void solveQuadraticEquation() {
        System.out.println("\n----- Calculate Quadratic Equation -----");
        
        double a = Validator.checkDouble("Enter A: ");
        double b = Validator.checkDouble("Enter B: ");
        double c = Validator.checkDouble("Enter C: ");
        
        List<Double> solutions = calculateQuadraticEquation(a, b, c);
        
        if (solutions == null) {
            System.out.println("Solution: No real solutions");
        } else if (solutions.isEmpty()) {
            System.out.println("Solution: Infinitely many solutions");
        } else if (solutions.size() == 1) {
            System.out.printf("Solution: x = %.3f\n", solutions.get(0));
        } else {
            System.out.printf("Solution: x1 = %.3f and x2 = %.3f\n", 
                            solutions.get(0), solutions.get(1));
        }
        
        analyzer.analyzeNumbers(a, b, c);
    }
}
