package com.youshin;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;

public class CalcNero {


    //multiplicate & sum arrays f({a1, a2, a3}, {b1, b2, b3}) => a1*b1+a2*b2+a3*b3
    private double multiAndSumArray(@NotNull double[] a, @NotNull double[] b) {
        double[] tempArray = new double[Math.min(a.length, b.length)];
        for (int i = 0; i<tempArray.length; i++) tempArray[i] = a[i]*b[i];
        return Arrays.stream(tempArray).sum();
    }

    /**
     * Matrix * Vector
     * @param matrix double[][]
     * @param vector double[]
     * @return matrix * vector double[]
     * @throws ArrayIndexOutOfBoundsException
     * @throws NullPointerException
     */
    public double[] multiplMatrixVector(final double[][] matrix, final double[] vector) {
        if(null == matrix || null == vector) throw new NullPointerException();
        if (matrix[0].length != vector.length) throw new ArrayIndexOutOfBoundsException();
        double res[] = new double[matrix.length];
        int i = 0;
        for (double[] d:matrix) res[i++] = multiAndSumArray(d, vector);
        return res;
    }

    /**
     * Vector * Matrix
     * @param vector double[]
     * @param matrix double[][]
     * @return vector * matrix double[]
     */
    public double[] multipVectorMatrix(final double[] vector, final double[][] matrix) {
        double[][] mirrorMatrix = rotateMatrix(matrix);
        return multiplMatrixVector(mirrorMatrix, vector);
    }

    /**
     * Rotate matrix
     * @param matrix double[a][b]
     * @return matrix double[b][a]
     */
    public double[][] rotateMatrix(final double[][] matrix) {
        double[][] mirrorMatrix = new double[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) for (int j = 0; j < mirrorMatrix.length; j++) mirrorMatrix[j][i] = matrix[i][j];
        return mirrorMatrix;
    }

    /**
     * Sigmoid
     * @param x argument
     * @return Sigmoid (1+exp(-x))
     */
    public double f(final double x) {
        return 1/(1+Math.exp(-x*InitParams.ALPHA));
    }

    /**
     * Sigmoid'
     * @param x argument
     * @return Sigmoid' f(x)(1-f(x))
     */
    public double df(final double x) {
        return f(x)*(1-f(x));
    }

    /**
     * f(vector)
     * @param vector double[] {a, b, c}
     * @return vector double[] {f(a), f(b), f(c)}
     */
    public double[] getValue(final double[] vector) {
        for (int i=0; i<vector.length; i++) vector[i] = f(vector[i]);
        return vector;
    }

    /**
     * fill matrix random values
     * @param matrix double[][]
     * @return fill random double[][]
     */
    public double[][] fillMatrixRandom(final double[][] matrix) {
        for(int i=0; i<matrix.length; i++) Arrays.setAll(matrix[i], count -> Math.random());
        return matrix;
    }

    public void showMatrix(double[][] matrix) {
        for (double[] m:matrix) System.out.println(Arrays.toString(m));
        System.out.println("--------------");
    }
}
