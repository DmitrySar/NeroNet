package com.youshin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TrainingNet {
    private final double[][] inputdata;
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

    private final double[][] rightRes;// = {0, 0, 0, 0, 1, 1, 1, 1};

    private NeroNet neroNet;

    private ArrayList<double[]> delts = new ArrayList<>();
    private ArrayList<double[][]> weights = new ArrayList<>();

    public TrainingNet(final double[][] inputdata, final double[][] rightRes, final NeroNet neroNet) {
        this.inputdata = inputdata;
        this.rightRes = rightRes;
        this.neroNet = neroNet;
        delts.addAll(neroNet.getNerons());
        weights.addAll(neroNet.getWeights());
    }

    private void calcDelts (double[] inData, double[] res) {
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

    private void calcWeights(double[] inData) {
        CalcNero calcNero = new CalcNero();
        double[][] w;
        double[] d, n, xn;
        ArrayList<double[]> inDataNeron = new ArrayList<>();
        inDataNeron.add(inData);
        inDataNeron.addAll(neroNet.getNerons());
        for(int count = 0; count < weights.size(); count++) {
            w = weights.get(count);
            d = delts.get(count);
            n = neroNet.getNerons().get(count);
            xn = inDataNeron.get(count);
            //calc weights
            for (int i = 0; i < w.length; i++)
                for(int j = 0; j < xn.length; j++)
                    w[i][j]+=InitParams.L_RATE*d[i]*calcNero.df(n[i])*xn[j];
        weights.set(count, w);
        }
    }

    /**
     * learning nero net
     * @return nero net with new weights
     */
    public NeroNet train() {
        Map<double[], double[]> inDataRes = new HashMap<>();
        for(int i = 0; i < rightRes.length; i++) inDataRes.put(inputdata[i], rightRes[i]);
        for (int epoche = 0; epoche < InitParams.EPOCHE; epoche++) {
            for (double[] inData:inputdata) {
                calcDelts(inData, inDataRes.get(inData));
                calcWeights(inData);
            }
            neroNet.setWeights(weights);
        }
        return neroNet;
    }
 }
