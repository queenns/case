package com.edu.demo.case2.predict4j;


public class CategoricalDecision<T extends Comparable<T>> extends Decision<T> {
    @Override
    boolean decision(T fval, T threshold) {
        if (Integer.parseInt(fval.toString()) == Integer.parseInt(threshold.toString())) {
            return true;
        } else {
            return false;
        }
    }
}
