/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week2.P0061;

import java.util.Scanner;

/**
 *
 * @author tothi
 */

public class Main {
    
    private Scanner scanner;
    
    public Main() {
        scanner = new Scanner(System.in);
    }
    
    public void run() {
        System.out.println("=====Calculator Shape Program=====");
        
        Rectangle rectangle = inputRectangleData();
        Circle circle = inputCircleData();
        Triangle triangle = inputTriangleData();
        
        rectangle.printResult();
        circle.printResult();
        triangle.printResult();
        
        scanner.close();
    }
    
    private Rectangle inputRectangleData() {
        Rectangle rectangle = new Rectangle();
        
        System.out.print("Please input side width of Rectangle: ");
        double width = getValidNumber();
        rectangle.setWidth(width);
        
        System.out.print("Please input length of Rectangle: ");
        double length = getValidNumber();
        rectangle.setLength(length);
        
        return rectangle;
    }
    
    private Circle inputCircleData() {
        Circle circle = new Circle();
        
        System.out.print("Please input radius of Circle: ");
        double radius = getValidNumber();
        circle.setRadius(radius);
        
        return circle;
    }
    
    private Triangle inputTriangleData() {
        Triangle triangle = new Triangle();
        
        System.out.print("Please input side A of Triangle: ");
        double sideA = getValidNumber();
        triangle.setSideA(sideA);
        
        System.out.print("Please input side B of Triangle: ");
        double sideB = getValidNumber();
        triangle.setSideB(sideB);
        
        System.out.print("Please input side C of Triangle: ");
        double sideC = getValidNumber();
        triangle.setSideC(sideC);
        
        return triangle;
    }
    
    private double getValidNumber() {
        while (true) {
            try {
                String input = scanner.nextLine().trim();
                double number = Double.parseDouble(input);
                if (number > 0) {
                    return number;
                } else {
                    System.out.print("Please enter a positive number: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a valid number: ");
            }
        }
    }
    
    public static void main(String[] args) {
        Main program = new Main();
        program.run();
    }
}
