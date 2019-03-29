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
        NeroNet neroNet = new NeroNet(inData,  3, 2, 1);
        TrainingNet trainingNet = new TrainingNet(INDATA, RIGHT_RESULT, neroNet);
        trainingNet.calcDelts(INDATA[0],RIGHT_RESULT[0]);
        trainingNet.calcWeights(INDATA[3]);

        //for(double[] n:neroNet.nerons) System.out.println(Arrays.toString(n));
//        System.out.println("value: "+Arrays.toString(neroNet.getValue()));
//        for (double[][] w:neroNet.getWeights()) new CalcNero().showMatrix(w);
        //for(double[] n:neroNet.nerons) System.out.println(Arrays.toString(n));
    }
}
