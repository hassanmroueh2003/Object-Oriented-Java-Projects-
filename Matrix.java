/*
Title: CSIS 215 Project 1 Matrix and its operations
Date: 3/20/2022
Author: Hassan Mroueh
Purpose: The purpose of this project is to implement the matrix and some of its operations as a class.
Methods used: - setMatrix : takes a 2D array of doubles and assigns its values to the elements of the matrix of this object.
              - setMatrix : takes a 1D array of doubles and assigns its values to the elements of diagonal of the matrix of this object. Other elements are equal to 0.
              - add : takes an object of class Matrix and returns the result of the addition of its matrix to the matrix of this object  
              - add : takes a 2D array  of doubles and and returns the result of the addition of this double to the elements of the matrix of this object 
              - subtract: takes a parameter of type Matrix and returns a Matrix object that results of the subtraction of this object and the parameter object
              - subtract : takes a parameter of type double and returns a Matrix object that results of the subtraction of this object and the parameter double
              - multiply : takes a parameter of type Matrix and returns a Matrix object that results of the multiplication of this object and the parameter object.
              - multiply : takes a parameter of type double and returns a Matrix object that results of the multiplication of this object and the parameter of type double
              - transpose: transpose that transposes the this object and returns the result of operation as a new Matrix object.
              - displayOp : displays the this and the parameter Matrix objects and the operation (+, -, *) and the resulted Matrix object
              - displayOp : displays this Matrix object and the double value and the operation (+, -, *) and the resulted Matrix
              - toString : returns the 2D array matrix of this object as a string
 */
package testmatrix;

public class Matrix {

    public double[][] Matrix; // reference to a 2D array that contains the elements of the matrix
    public static int numOfMatrixces = 0; // an integer represents the number of Matrix objects in the memory

    /**
     * purpose: creates the 2d array of the object, referenced by the data field
     * matrix, with the same dimensions as its parameter array.
     * precondition:takes a reference to a 2D array of double values post
     * condition: invokes the method setMatrix
     *
     * @param m
     */
    public Matrix(double[][] m) { // A public constructor that takes a reference to a 2D array of double values.
        setMatrix(m);  // This constructor invokes the method setMatrix
        numOfMatrixces++; // the number of Matrix objects in the memory increases by 1
    }

    /**
     * purpose: creates the 2d array of the object, referenced by the data field
     * matrix, with the both dimensions equal to the length of the 1d parameter
     * array.. precondition:takes a reference to a 1D array of double values
     * post condition: invokes the method setMatrix
     *
     * @param m
     */
    public Matrix(double[] a) { // A public constructor that takes a reference to a 1D array of double values.
        setMatrix(a); // This constructor invokes the method setMatrix
        numOfMatrixces++; // the number of Matrix objects in the memory increases by 1
    }

    /**
     * purpose: returns a copy of the data fields precondition: takes a Matrix
     * object post condition: invokes the method setMatrix
     *
     * @param m
     */
    public Matrix(Matrix m) {     // A copy constructor
        this.Matrix = m.Matrix;

    }

    /**
     * purpose: returns a copy of the data fields precondition: takes a 2D array
     * with double values post condition: invokes the method setMatrix
     *
     * @param m
     */
    public void setMatrix(double[][] m) {
        this.Matrix = m;                        // the 2D array Matrix references to the 2D array in the parameter 
    }

    /**
     * purpose: it assigns values of the 1D array in order to the elements of
     * the 2D array when the index of the rows is equal to the columns
     * precondition: takes a 1D array with double values post condition: none
     *
     * @param m
     */
    public void setMatrix(double[] a) {
        double[][] Matrix = new double[a.length][a.length];  // create a new 2D array wtih rows and columns equal to the length of the 1D array in the parameter
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (i == j) {
                    Matrix[i][j] = a[i];  // it assigns values of  the 1D array in order to the elements of the 2D array when the index of the rows is equal to the columns
                }
            }
        }
        this.Matrix = Matrix;
    }

    /**
     * purpose: elements of the 2D arrays this Matrix and the rightHandSide with
     * the same index will be added and assigned to the 3rd 2D array with the
     * same index of the object result precondition: takes an object of class
     * Matrix and the 2D array of this object must have the same rows and
     * columns of the matrix 2D array of this class post condition: returns a
     * Matrix object that results of the addition of this object and the
     * parameter object
     *
     * @param m
     */
    public Matrix add(Matrix rightHandSide) {    // takes an object of class Matrix and the 2D array of this object must have the same rows and columns of the matrix 2D array of this class
        double[][] sum = new double[this.Matrix.length][this.Matrix[0].length]; // initialize a new 2D array with elements with value equal to 0.0
        Matrix result = new Matrix(sum); // create a new object and assign the 2D array sum to it 
        if ((this.Matrix.length != rightHandSide.Matrix.length) && (this.Matrix[0].length != rightHandSide.Matrix[0].length)) // the 2 matrices should have the same nb of rows and columns
        {
            System.out.println("The  2 matrixes should be equal");
            return null; // if the 2 matrices don't have the same nb of rows and columns it returns null
        }

        for (int row = 0; row < this.Matrix.length; row++) { // this loop covers all the rows
            for (int column = 0; column < this.Matrix[row].length; column++) { // the 2nd loop covers all the columns of each row
                result.Matrix[row][column] = this.Matrix[row][column] + rightHandSide.Matrix[row][column]; // elements of the 2D arrays this Matrix and the rightHandSide with the same index will be added and assigned to the 3rd 2D array with the same index of the object result 
            }
        }
        return result; //returns a Matrix object that results of the addition of this object and the parameter object
    }

    /**
     * purpose: elements of the 2D arrays this Matrix and the double
     * rightHandSide will be added and assigned to the 3rd 2D array of the
     * object result precondition: takes a parameter of type double post
     * condition: returns a Matrix object that results of the addition of this
     * object and the parameter double
     *
     * @param m
     */
    public Matrix add(double rightHandSide) { //takes a parameter of type double
        double[][] sum = new double[this.Matrix.length][this.Matrix[0].length]; // initialize a new 2D array with elements with value equal to 0.0
        Matrix result = new Matrix(sum); // create a new object and assign the 2D array sum to it 
        for (int row = 0; row < this.Matrix.length; row++) { // this loop covers all the rows
            for (int column = 0; column < this.Matrix[row].length; column++) { // the 2nd loop covers all the columns of each row
                result.Matrix[row][column] = this.Matrix[row][column] + rightHandSide; // elements of this Matrix are  added to the variable rightHandSide  and assigned to the  array of the object result  
            }
        }
        return result; // returns a Matrix object that results of the addition of this object and the parameter double
    }

    /**
     * purpose: elements of the 2D arrays this Matrix and the rightHandSide with
     * the same index will be subtracted and assigned to the 3rd 2D array with
     * the same index of the object result precondition: takes an object of
     * class Matrix and the 2D array of this object must have the same rows and
     * columns of the matrix 2D array of this class post condition: returns a
     * Matrix object that results of the subtraction of this object and the
     * parameter object
     *
     * @param m
     */
    public Matrix subtract(Matrix rightHandSide) { // takes a parameter of type Matrix and its 2D array should have the same nb of rows and columns of the 2D array Matrix of this object
        double[][] total = new double[this.Matrix.length][this.Matrix[0].length]; // initialize a new 2D array with elements with value equal to 0.0
        Matrix result = new Matrix(total); // create a new object and assign the 2D array total to it 
        if ((this.Matrix.length != rightHandSide.Matrix.length) && (this.Matrix[0].length != rightHandSide.Matrix[0].length)) // the 2 matrices should have the same nb of rows and columns
        {
            System.out.println("The rows of the 2 matrixes are not equal");
            return null; // if the 2 matrices don't have the same nb of rows and columns it returns null
        }

        for (int row = 0; row < this.Matrix.length; row++) { // this loop covers all the rows
            for (int column = 0; column < this.Matrix[row].length; column++) { // the 2nd loop covers all the columns of each row
                result.Matrix[row][column] = this.Matrix[row][column] + rightHandSide.Matrix[row][column]; // elements of the  arrays this Matrix and the rightHandSide with the same index will be subtracted and assigned to the 3rd 2D array with the same index of the object result 
            }
        }
        return result; // returns a Matrix object that results of the subtraction of this object and the parameter object.
    }

    /**
     * purpose: elements of the 2D arrays this Matrix and the double
     * rightHandSide will be subtracted and assigned to the 3rd 2D array of the
     * object result precondition: takes a parameter of type double post
     * condition: returns a Matrix object that results of the subtraction of
     * this object and the parameter double
     *
     * @param m
     */
    public Matrix subtract(double rightHandSide) { //takes a parameter of type double
        double[][] total = new double[this.Matrix.length][this.Matrix[0].length]; // initialize a new 2D array with elements with value equal to 0.0
        Matrix result = new Matrix(total); // create a new object and assign the  array total to it 
        for (int row = 0; row < this.Matrix.length; row++) { // this loop covers all the rows
            for (int column = 0; column < this.Matrix[row].length; column++) { // the 2nd loop covers all the columns of each row
                result.Matrix[row][column] = this.Matrix[row][column] + rightHandSide; // elements of this Matrix are  subtracted by the variable rightHandSide  and assigned to the  array of the object result  
            }
        }
        return result; //returns a Matrix object that results of the subtraction of this object and the parameter double
    }

    /**
     * purpose: elements of the 2D arrays this Matrix and the rightHandSide with
     * the same index will be multiplied and assigned to the 3rd 2D array with
     * the same index of the object result precondition: takes a parameter of
     * type Matrix and the rows of its 2D array must be equal to the number of
     * columns of the 2D array of this object post condition: returns a Matrix
     * object that results of the multiplication of this object and the
     * parameter object and the resulting matrix will have the same number of
     * rows as the first matrix and the same number of columns as the second
     * matrix
     *
     * @param m
     */
    public Matrix multiply(Matrix rightHandSide) { // takes a parameter of type Matrix and the rows of its 2D array must be equal to the nb of columns of the 2D array of this object
        double[][] total = new double[this.Matrix.length][rightHandSide.Matrix[0].length];
        /* initialize a new 2D array with elements with value equal to 0.0 .
        the resulting matrix will have the same number of rows as the first matrix and  the same number of columns as the second matrix.  */

        Matrix result = new Matrix(total); // create a new object and assign the 2D array sum to it 
        if (this.Matrix[0].length != rightHandSide.Matrix.length) // checks if the nb of columns of this matrix  is equal to the nb of rows of the rightHandSide matrix 
        {
            System.out.println("The  nb of cloumns of the 1st matrix must be equal to the nb of rows of the 2nd matrix");
            return null; // if the condition is not true then it returns null
        }

        for (int i = 0; i < this.Matrix.length; i++) { // this loop covers all the rows of the result matrix 
            for (int j = 0; j < rightHandSide.Matrix[i].length; j++) { // the 2nd loop covers all the columns of each row
                for (int multiples = 0; multiples < this.Matrix[i].length; multiples++) {
                    result.Matrix[i][j] = this.Matrix[i][multiples] * rightHandSide.Matrix[multiples][j] + result.Matrix[i][j];
                    /* row represented by i of the 1st matrix will be multiplied by the colmun of
                    of the rightHandSide matrix represented by j and their total will be assigned to the element of the 2D array Matrix of the object result of index [i][j]  */
                }
            }
        }
        return result;
    }

    /**
     * purpose: elements of the 2D arrays this Matrix and the double
     * rightHandSide will be multiplied and assigned to the 3rd 2D array of the
     * object result precondition: takes a parameter of type double post
     * condition: returns a Matrix object that results of the multiplication of
     * this object and the parameter of type double
     *
     * @param m
     */
    public Matrix multiply(double rightHandSide) { // takes a parameter of type double
        double[][] total = new double[this.Matrix.length][this.Matrix[0].length]; // initialize a new 2D array with elements with value equal to 0.0
        Matrix result = new Matrix(total); // create a new object and assign the  array total to it 
        for (int i = 0; i < this.Matrix.length; i++) {
            for (int j = 0; j < this.Matrix[i].length; j++) {
                result.Matrix[i][j] = this.Matrix[i][j] * rightHandSide; // elements of this Matrix are  multiplied by the variable rightHandSide  and assigned to the  array of the object result  
            }
        }
        return result; // returns a Matrix object that results of the multiplication of this object and the parameter of type double
    }

    /**
     * purpose: it switches the row and column indices of this matrix by
     * producing another matrix result precondition: none post condition: it
     * returns the result a transpose of the Matrix of this object operation as
     * a new Matrix object
     *
     * @param m
     */
    public Matrix transpose() { // takes no parameters
        double[][] total = new double[this.Matrix[0].length][this.Matrix.length]; // initialize a new 2D array with elements with value equal to 0.0
        Matrix result = new Matrix(total); // create a new object and assign the  array total to it 
        for (int i = 0; i < this.Matrix.length; i++) {
            for (int j = 0; j < this.Matrix[i].length; j++) {
                result.Matrix[j][i] = this.Matrix[i][j]; //  it switches the row and column indices of this matrix  by producing another matrix result
            }
        }
        return result; // it returns the result of operation as a new Matrix object
    }

    /**
     * purpose: displays the this and the parameter Matrix objects and the
     * operation (+, -, *) and the resulted Matrix precondition: takes a matrix
     * object, characters of the operation (+, -, *) , the Matrix object result
     * of the operation post condition: none
     *
     * @param m
     */
    public void displayOp(Matrix rightHandSide, char op, Matrix result) { // takes a matrix object, characters of the operation (+, -, *) , the Matrix object result of the operation
        if (op == '+') { // if operation is true for addition then it prints the 2 matrices with addition character and equal to the result preceeded with the result matrix
            for (int i = 0; i < this.Matrix.length; i++) {
                for (int j = 0; j < this.Matrix[i].length; j++) {
                    System.out.printf("%-7.2f%-1s", this.Matrix[i][j], " ");
                }
                if (i == this.Matrix.length - 1) {
                    System.out.print("     +     ");
                } else {
                    System.out.print("           ");
                }
                for (int j = 0; j < this.Matrix[i].length; j++) {
                    System.out.printf("%-7.2f%-1s", rightHandSide.Matrix[i][j], " ");
                }
                if (i == this.Matrix.length - 1) {
                    System.out.print("     =     ");
                } else {
                    System.out.print("           ");
                }

                for (int j = 0; j < this.Matrix[i].length; j++) {
                    System.out.printf("%-7.2f%-1s", result.Matrix[i][j], " ");
                }
                System.out.println();

            }

        } else if (op == '*') { // if operation is true for multiplication then it prints the 2 matrices with multiplication character and equal to the result preceeded with the result matrix
            for (int i = 0; i < this.Matrix.length; i++) {
                for (int j = 0; j < this.Matrix[i].length; j++) {
                    System.out.printf("%-7.2f%-1s", this.Matrix[i][j], " ");
                }
                if (i == this.Matrix.length - 1) {
                    System.out.print("     *     ");
                } else {
                    System.out.print("           ");
                }
                for (int j = 0; j < rightHandSide.Matrix[i].length; j++) {
                    System.out.printf("%-7.2f%-1s", rightHandSide.Matrix[i][j], " ");
                }
                if (i == this.Matrix.length - 1) {
                    System.out.print("     =     ");
                } else {
                    System.out.print("           ");
                }

                for (int j = 0; j < result.Matrix[i].length; j++) {
                    System.out.printf("%-7.2f%-1s", result.Matrix[i][j], " ");
                }
                System.out.println();

            }

        } else if (op == '-') { // if operation is true for subtraction then it prints the 2 matrices with subtraction character and equal to the result preceeded with the result matrix
            for (int i = 0; i < this.Matrix.length; i++) {
                for (int j = 0; j < this.Matrix[i].length; j++) {
                    System.out.printf("%-7.2f%-1s", this.Matrix[i][j], " ");
                }
                if (i == this.Matrix.length - 1) {
                    System.out.print("     -     ");
                } else {
                    System.out.print("           ");
                }
                for (int j = 0; j < this.Matrix[i].length; j++) {
                    System.out.printf("%-7.2f%-1s", rightHandSide.Matrix[i][j], " ");
                }
                if (i == this.Matrix.length - 1) {
                    System.out.print("     =     ");
                } else {
                    System.out.print("           ");
                }

                for (int j = 0; j < this.Matrix[i].length; j++) {
                    System.out.printf("%-7.2f%-1s", result.Matrix[i][j], " ");
                }
                System.out.println();

            }

        }
    }

    /**
     * purpose: displays displays this Matrix object and the double value and
     * the operation (+, -, *) and the resulted Matrix precondition: takes a
     * variable of type double, characters of the operation (+, -, *) , the
     * Matrix object result of the operation post condition: none
     *
     * @param m
     */
    public void displayOp(Double rightHandSide, char op, Matrix result) {
        if (op == '+') { // if operation is true for addition then it prints the  matrix preceed with addition character and then the double number  and equal to the result preceeded with the result matrix
            for (int i = 0; i < this.Matrix.length; i++) {
                for (int j = 0; j < this.Matrix[i].length; j++) {
                    System.out.printf("%-7.2f%-1s", this.Matrix[i][j], " ");
                }
                if (i == this.Matrix.length / 2) {
                    System.out.printf("%-2s%-1c%-2s%-6.2f%-1c%-2s", " ", op, " ", rightHandSide, '=', " ");
                } else {
                    System.out.printf("%-14s", " ");
                }

                for (int j = 0; j < this.Matrix[i].length; j++) {
                    System.out.printf("%-7.2f%-1s", result.Matrix[i][j], " ");
                }
                System.out.println();

            }

        } else if (op == '*') { // if operation is true for multiplication then it prints the  matrix preceed with multiplication character and then the double number  and equal to the result preceeded with the result matrix
            for (int i = 0; i < this.Matrix.length; i++) {
                for (int j = 0; j < this.Matrix[i].length; j++) {
                    System.out.printf("%-7.2f%-1s", this.Matrix[i][j], " ");
                }
                if (i == this.Matrix.length / 2) {
                    System.out.printf("%-2s%-1c%-2s%-6.2f%-1c%-2s", " ", op, " ", rightHandSide, '=', " ");
                } else {
                    System.out.printf("%-14s", " ");
                }

                for (int j = 0; j < this.Matrix[i].length; j++) {
                    System.out.printf("%-7.2f%-1s", result.Matrix[i][j], " ");
                }
                System.out.println();

            }

        } else if (op == '-') { // if operation is true for subtraction then it prints the  matrix preceed with subtraction character and then the double number  and equal to the result preceeded with the result matrix
            for (int i = 0; i < this.Matrix.length; i++) {
                for (int j = 0; j < this.Matrix[i].length; j++) {
                    System.out.printf("%-7.2f%-1s", this.Matrix[i][j], " ");
                }
                if (i == this.Matrix.length / 2) {
                    System.out.printf("%-2s%-1c%-2s%-6.2f%-1c%-2s", " ", op, " ", rightHandSide, '=', " ");
                } else {
                    System.out.printf("%-14s", " ");
                }

                for (int j = 0; j < this.Matrix[i].length; j++) {
                    System.out.printf("%-7.2f%-1s", result.Matrix[i][j], " ");
                }
                System.out.println();

            }

        }

    }

    /**
     * purpose: converts the 2D array matrix of this object into a string
     * precondition: none post condition: returns the 2D array matrix of this
     * object as a string
     *
     * @param m
     */
    public String toString() { // takes no parameters
        String aString = ""; // create a new variable string 
        for (int row = 0; row < this.Matrix.length; row++) { // this loop covers the rows of the 2D array of the Matrix of this object
            for (int col = 0; col < this.Matrix[row].length; col++) { // this loop covers the columns of the 2D array of the Matrix of this object
                aString += " " + this.Matrix[row][col]; // it adds the elements of the 2D arrays as an array of characters into the String that was initliazed earlier
            }
            aString += "\r\n"; // when a row is covered creates a new line and goes to the next row
        }
        return aString; // returns the 2D array matrix of this object as a string
    }
}
