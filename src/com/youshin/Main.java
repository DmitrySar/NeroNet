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

    private static final double[][] RIGHT_RESULT ={{0}, {0}, {0}, {0}, {1}, {1}, {1}, {1}};


    public static void main(String[] args) {
        double[] inData = {1.0, 2.0, 3.0};
        NeroNet neroNet = new NeroNet(3,  3, 2, 1);
        TrainingNet trainingNet = new TrainingNet(INDATA, RIGHT_RESULT, neroNet);
        trainingNet.start();
    }
}
