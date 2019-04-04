# Neural network Java project
- learn the principles of the neural network
- write a program
- input data:
- + array[][] double of any variations input data
- + array[][] double of correct results

## write Class NeroNet
- input value: number of input values, number of neurons in each layer
- example:
```java
NeroNet neroNet = new NeroNet(3,  3, 2, 1);
```

## write Class TrainingNet
- input value:
- + array[][] double of input data
- + array[][] duble of correct results
- + NeroNet
example:
```java
TrainingNet trainingNet = new TrainingNet(INDATA, RIGHT_RESULT, neroNet);
```

## example main method:
```java
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

```
