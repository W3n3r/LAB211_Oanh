/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week7.P0080;

import java.util.Scanner;

/**
 *
 * @author tothi
 */
public class ShapeTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Shape[] shapes = new Shape[4];
        
        System.out.println("      Input Shape Dimensions      ");
        
        System.out.print("Enter radius of Circle: ");
        double circleRadius = sc.nextDouble();
        shapes[0] = new Circle(circleRadius);
        
        System.out.print("Enter side of Square: ");
        double squareSide = sc.nextDouble();
        shapes[1] = new Square(squareSide);
        
        
        System.out.print("Enter radius of Sphere: ");
        double sphereRadius = sc.nextDouble();
        shapes[2] = new Sphere(sphereRadius);
        
        
        System.out.print("Enter edge of Tetrahedron: ");
        double tetrahedronEdge = sc.nextDouble();
        shapes[3] = new Tetrahedron(tetrahedronEdge);
        
        System.out.println("\n      Shape Information      \n");
        
        for (Shape shape : shapes) {
            System.out.println(shape);
            
            if (shape instanceof TwoDimensionalShape) {
                TwoDimensionalShape shape2D = (TwoDimensionalShape) shape;
                System.out.printf("Area: %.2f\n", shape2D.getArea());
            } else if (shape instanceof ThreeDimensionalShape) {
                ThreeDimensionalShape shape3D = (ThreeDimensionalShape) shape;
                System.out.printf("Surface Area: %.2f\n", shape3D.getArea());
                System.out.printf("Volume: %.2f\n", shape3D.getVolume());
            }
            
            System.out.println();
        }
        
        sc.close();
    
    }
}
