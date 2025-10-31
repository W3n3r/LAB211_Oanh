/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week7.P0080;

/**
 *
 * @author tothi
 */
class Tetrahedron extends ThreeDimensionalShape {
    private double edge;

    public Tetrahedron(double edge) {
        this.edge = edge;
    }
    
    @Override
    public double getArea() {
        return Math.sqrt(3)*edge*edge; // (căn 3 x a bình )
    }

    @Override
    public double getVolume() {
        return (1.0 / 12.0)*Math.sqrt(2)*Math.pow(edge, 3); // căn 2 / 12 x a mủ 3
    }

    @Override
    public String getShapeName() {
        return "Tetrahedron";
    }

    @Override
    public String toString() {
        return String.format("%s with edge %.2f", getShapeName(),edge);
    }
    
}
