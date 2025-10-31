/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week7.P0080;

/**
 *
 * @author tothi
 */
class Square extends TwoDimensionalShape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return side*side;
    }

    @Override
    public String getShapeName() {
        return "Square";
    }

    @Override
    public String toString() {
        return String.format("%s with side %.2f", getShapeName(),side);
    }

    
}
