package com.youshin;

import java.util.ArrayList;
import java.util.Arrays;

public class TrainingNet {
    private final double[][] INPUTDATA;
//    = {
//            {0,0,0,1},//0
//            {1,0,0,1},
//            {1,1,0,1},
//            {1,1,1,1},
//            {0,0,1,1},//1
//            {0,1,0,1},
//            {0,1,1,1},
//            {1,0,1,1}
//
//    };

    private final double[][] RIGHT_RES;// = {0, 0, 0, 0, 1, 1, 1, 1};

    private NeroNet neroNet;

    private ArrayList<double[]> delts = new ArrayList<>();
    private ArrayList<double[][]> weights = new ArrayList<>();

    public TrainingNet(final double[][] INPUTDATA, final double[][] RIGHT_RES, final NeroNet neroNet) {
        this.INPUTDATA = INPUTDATA;
        this.RIGHT_RES = RIGHT_RES;
        this.neroNet = neroNet;
        delts.addAll(neroNet.getNerons());
        weights.addAll(neroNet.getWeights());
    }

    public void calcDelts (double[] inData, double[] res) throws ArrayIndexOutOfBoundsException {
        neroNet.setInputData(inData);
        double delta[] = neroNet.getValue();
        if(res.length != delta.length) throw new ArrayIndexOutOfBoundsException();
        for (int i=0; i < delta.length; i++) delta[i] = res[i]-delta[i];
        //calc all delts in neroNet
        //mirrors neroNet calc?
        CalcNero calcNero = new CalcNero();
        delts.set(delts.size()-1, delta);
        for (int i = 1; i < delts.size(); i++ ) delts.set(delts.size()-i-1, calcNero.multipVectorMatrix(delts.get(delts.size()-i), weights.get(weights.size()-i)));
    }

    public void calcWeights() {
        //
    }
 }
