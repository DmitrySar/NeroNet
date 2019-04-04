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
//        neroNet.setInputData(INDATA[0]);
//        System.out.println(Arrays.toString(neroNet.getValue()));
        neroNet = trainingNet.train();
        int i = 0;
        for(double[] indata:INDATA) {
            neroNet.setInputData(indata);
            System.out.println(++i + " "+Arrays.toString(neroNet.getValue()));
        }
        //for (i = 0; i < neroNet.getNerons().size(); i++) System.out.println(Arrays.toString(neroNet.getNerons().get(i)));
//        System.out.println(Arrays.toString(neroNet.getNerons().get(1)));
//        calcNero.showMatrix(neroNet.getWeights().get(1));
//        System.out.println(Arrays.toString(calcNero.multiplMatrixVector(neroNet.getWeights().get(1), neroNet.getNerons().get(0))));
    }
}
