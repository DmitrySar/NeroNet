package com.youshin;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class NeroNet {

    private double[] inputData;

    private int[] neronsOfLayer;

    private ArrayList<double[][]> weights = new ArrayList<>();
    private ArrayList<double[]> nerons = new ArrayList<>();

    /**
     * Constructor
     * @param inputData one sample of input data
     * @param neronsOfLayer number of neurons in each layer
     */
    public NeroNet(@NotNull final double[] inputData, @NotNull final int ... neronsOfLayer) {
        this.inputData = inputData;
        this.neronsOfLayer = neronsOfLayer;
        createLayers();
    }

    public NeroNet setInputData(double[] inputData) {
        this.inputData = inputData;
        return this;
    }

    private void createLayers() {
        for (int i:neronsOfLayer) nerons.add(new double[i]);
        int i=0;
        weights.add(new double[nerons.get(i).length][inputData.length]);
        for(i=0; i < nerons.size()-1; i++) weights.add(new double[nerons.get(i+1).length][nerons.get(i).length]);
        fillRandomWeights();
    }

    private void fillRandomWeights(){
        for (int i=0; i<weights.size();i++) weights.set(i, new CalcNero().fillMatrixRandom(weights.get(i)));
    }

    private void calcValues() {
        nerons.set(0, new CalcNero().multiplMatrixVector(weights.get(0), inputData));
        for (int i=1; i<nerons.size();i++) nerons.set(i, new CalcNero().multiplMatrixVector(weights.get(i), nerons.get(i-1)));
        for (int i=0; i<nerons.size();i++) nerons.set(i, new CalcNero().getValue(nerons.get(i)));
    }

    public double[] getValue(){
        calcValues();
        return nerons.get(nerons.size()-1);
    }

    public ArrayList<double[][]> getWeights() {
        return weights;
    }

    public ArrayList<double[]> getNerons() {
        return nerons;
    }

}
