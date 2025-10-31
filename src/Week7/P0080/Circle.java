/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week7.P0080;

/**
 *
 * @author tothi
 */
class Circle extends TwoDimensionalShape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI*radius*radius;
    }

    @Override
    public String getShapeName() {
        return "Circle";
    }

    @Override
    public String toString() {
        return String.format("%s with radius %.2f", getShapeName(),radius);
    }
   
}
