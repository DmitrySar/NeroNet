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
     * @param sizeInputData number of values from input data
     * @param neronsOfLayer number of neurons in each layer
     */
    public NeroNet(@NotNull final int sizeInputData, @NotNull final int ... neronsOfLayer) {
        this.inputData = new double[sizeInputData];
        this.neronsOfLayer = neronsOfLayer;
        createLayers();
    }

    /**
     * set input data in neroNet
     * @param inputData double[]
     * @return Neronet
     */
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

    /**
     * Return result out nero net
     * @return output values from last layers
     */
    public double[] getValue(){
        calcValues();
        return nerons.get(nerons.size()-1);
    }

    /**
     * Return all weights from nero net
     * @return double[][] weights
     */
    public ArrayList<double[][]> getWeights() {
        return weights;
    }

    /**
     * Return all nerons from nero net
     * @return nerons ArrayList<double[]>
     */
    public ArrayList<double[]> getNerons() {
        return nerons;
    }

    /**
     * Set new weights for nero net
     * @param weights ArrayList<double[][]>
     * @return NeroNet
     */
    public NeroNet setWeights(ArrayList<double[][]> weights) {
        this.weights = weights;
        return this;
    }


}
