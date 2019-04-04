package com.youshin;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class CalcNeroTest {

    @Test
    public void multiplMatrixVector() {
        final double[] result = {8.0, 17.0};
        CalcNero calcNero = new CalcNero();
        double[][] matrix = {
                {1.0, 2.0, 3.0, 1.0},
                {4.0, 5.0, 6.0, 1.0}
        };
        double[] vector = {1.0, 1.0, 1.0, 2.0};
        assertEquals(Arrays.toString(result), Arrays.toString(calcNero.multiplMatrixVector(matrix, vector)));
    }

    @Test
    public void rotateMatrix() {
        double[][] matrix = {
                                {1,2,3},
                                {4,5,6}
        };
        double[][] rotateMatrix = {
                                    {1,4},
                                    {2,5},
                                    {3,6}
        };
        final int TEST_ROW = 1;
        CalcNero calcNero = new CalcNero();
        //calcNero.showMatrix(calcNero.rotateMatrix(matrix));
        //calcNero.showMatrix(calcNero.rotateMatrix(rotateMatrix));
        assertEquals(Arrays.toString(rotateMatrix[TEST_ROW]), Arrays.toString(calcNero.rotateMatrix(matrix)[TEST_ROW]));
    }

    @Test
    public void f() {
    }

    @Test
    public void df() {
    }

    @Test
    public void getValue() {
    }

    @Test
    public void fillMatrixRandom() {
    }

    @Test
    public void showMatrix() {
    }
}