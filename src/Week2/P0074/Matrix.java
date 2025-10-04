/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week2.P0074;

import java.util.Scanner;

/**
 *
 * @author tothi
 */

public class Matrix {
    private int rows;
    private int cols;
    private int[][] data;

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.data = new int[rows][cols];
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public int[][] getData() {
        return data;
    }

    public void input(Scanner sc, String name) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                while (true) {
                    System.out.print("Enter " + name + "[" + (i + 1) + "][" + (j + 1) + "]:");
                    if (sc.hasNextInt()) {
                        data[i][j] = sc.nextInt();
                        break;
                    } else {
                        System.out.println("Value of matrix is digit");
                        sc.next();
                    }
                }
            }
        }
    }

    public Matrix additionMatrix(Matrix m2) {
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[i][j] = this.data[i][j] + m2.data[i][j];
            }
        }
        return result;
    }

    public Matrix subtractionMatrix(Matrix m2) {
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[i][j] = this.data[i][j] - m2.data[i][j];
            }
        }
        return result;
    }

    public Matrix multiplicationMatrix(Matrix m2) {
        Matrix result = new Matrix(this.rows, m2.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < m2.cols; j++) {
                for (int k = 0; k < this.cols; k++) {
                    result.data[i][j] += this.data[i][k] * m2.data[k][j];
                }
            }
        }
        return result;
    }

    public void display() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("[" + data[i][j] + "]");
            }
            System.out.println();
        }
    }
}
