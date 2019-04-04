package com.youshin;

import java.util.Arrays;

public class Main {

    private static final double[][] INDATA = {
            {0,0,0},//0
            {1,0,0},
            {1,1,0},
            {1,1,1},
            {0,0,1},//1
            {0,1,0},
            {0,1,1},
            {1,0,1}

    };

    private static final double[][] RIGHT_RESULT ={
            {0},
            {0},
            {0},
            {0},
            {1},
            {1},
            {1},
            {1}
    };


    public static void main(String[] args) {
        CalcNero calcNero = new CalcNero();
        NeroNet neroNet = new NeroNet(3,  3, 2, 1);
        TrainingNet trainingNet = new TrainingNet(INDATA, RIGHT_RESULT, neroNet);
        neroNet = trainingNet.train();
        int i = 0;
        System.out.printf("\n Show result after training: \n \n");
        for(double[] indata:INDATA) {
            neroNet.setInputData(indata);
            System.out.println(++i + " "+Arrays.toString(neroNet.getValue()));
        }
        System.out.printf("\n Show weights in every layer: \n \n");
        for (double[][] w:neroNet.getWeights()) calcNero.showMatrix(w);
    }
}
