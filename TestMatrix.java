/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testmatrix;

/**
 *
 * @author Hasan
 */
import java.util.Scanner;

public class TestMatrix {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double[][] array1 = {
            {1.1, 2.2, 3.3, 4.4}, {5.5, 6.6, 7.7, 8.8}, {9.9, 10.0, 11.1, 12.2}
        };       // Declaration of array1 a 2D array (3x4 elements) and initialize its elements with random double values between 0.0 and 50.0 .
        double[][] array2 = {
            {1.1, 2.2, 3.3, 4.4}, {5.5, 6.6, 7.7, 8.8}, {9.9, 10.0, 11.1, 12.2}, {13.3, 14.4, 15.5, 16.6}
        }; // Declaration of array2 a 2D array (4x4 elements) and initialize its elements with random double values between 0.0 and 50.0 .
        double[] array3 = {10.2, 20.4, 30.5, 40.6}; // // Declaration of array3 a 1D array 4 elements and initialize its elements with random double values between 0.0 and 50.0 .
        System.out.println(Matrix.numOfMatrixces + " matrix in the memory.");
        Matrix m1 = new Matrix(array1); // Declaration of a Matrix variable m1 and assigned to it a new Matrix object out of the array1 2D array
        System.out.println(m1.toString());
        System.out.println(m1.numOfMatrixces + " matrix in the memory."); 
        Matrix m2 = new Matrix(array2);  

        System.out.println(m2.toString());
        System.out.println(m2.numOfMatrixces + " matrices in the memory.");
        Matrix m3 = new Matrix(array3);
        System.out.println(m3.toString());
        double number;
        Scanner input = new Scanner(System.in);
        System.out.println(m3.numOfMatrixces + " matrices in the memory.");
        System.out.println("Enter a double value: ");
        number = input.nextDouble();
        Matrix m4 = new Matrix(m1.add(number));
        System.out.println(m4.numOfMatrixces + " matrices in the memory.");
        m1.displayOp(number, '+', m4);
        Matrix m5 = new Matrix(m2.add(m3));
        System.out.println(m5.numOfMatrixces + " matrices in the memory.");
        m2.displayOp(m3, '+', m5);
        Matrix m6 = new Matrix(m1.multiply(number));
        System.out.println(m6.numOfMatrixces + " matrices in the memory.");
        m1.displayOp(number, '*', m6);
        Matrix m7 = new Matrix(m1.multiply(m3));
        System.out.println(m7.numOfMatrixces + " matrices in the memory.");
        m1.displayOp(m3, '*', m7);
        Matrix m8 = new Matrix(m1.transpose());

        System.out.println("The transpose of ");
        System.out.println(m1.toString());
        System.out.println("is");
        System.out.println(m8.toString());
    }



}
