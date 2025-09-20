/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week2.P0061;

/**
 *
 * @author tothi
 */
public class Triangle extends Shape {
    private double sideA;
    private double sideB;
    private double sideC;
    
    // Constructor
    public Triangle() {
    }
    
    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }
    
    public double getSideA() {
        return sideA;
    }
    
    public void setSideA(double sideA) {
        this.sideA = sideA;
    }
    
    public double getSideB() {
        return sideB;
    }
    
    public void setSideB(double sideB) {
        this.sideB = sideB;
    }
    
    public double getSideC() {
        return sideC;
    }
    
    public void setSideC(double sideC) {
        this.sideC = sideC;
    }

    public double getPerimeter() {
        return sideA + sideB + sideC;
    }

    public double getArea() {
        double s = getPerimeter() / 2; // semi-perimeter
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    public void printResult() {
        System.out.println("-----Triangle-----");
        System.out.println("Side A: " + sideA);
        System.out.println("Side B: " + sideB);
        System.out.println("Side C: " + sideC);
        System.out.printf("Area: %.2f%n", getArea());
        System.out.println("Perimeter: " + getPerimeter());
    }
}
