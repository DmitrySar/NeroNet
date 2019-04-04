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
NeroNet neroNet = new NeroNet(3,  3, 3, 1);
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
## Show result:

 Show result after training:

1 [6.729477407270466E-4]
2 [4.044587706018213E-6]
3 [4.044587712563457E-6]
4 [2.4079076569312864E-4]
5 [0.9984601497707847]
6 [0.9999999929205929]
7 [0.999999993778399]
8 [0.9984601497507619]

 Show weights in every layer:

[504.9698013717052, -633.9575208168569, 140.46198239393]
[-179.96455437458556, 2.8861901766015863, 190.91644348083912]
[-106.60856708108244, 847.7671115172667, -735.1427566907468]
--------------
[-16.821447196750572, 16.312326799913475, -15.71774602080265]
[14.71396789344623, -26.379389202667063, 12.004634635009507]
[-12.786278332575517, 12.458381855404433, -10.934760934994623]
--------------
[3.2309572416089174, -5.9133937594776, 6.751614886869608]
--------------
