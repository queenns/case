package com.edu.demo.case2.predict4j;

import java.util.List;


public abstract class PredictFunction {
    abstract List<Double> predict(SparseVector vector);
}
