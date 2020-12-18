package com.edu.demo.case2.predict4j;


public class NumericalDecision<T extends Comparable<T>> extends Decision<T> {
    @Override
    boolean decision(T fval, T threshold) {
        if (fval.compareTo(threshold) <= 0) {
            return true;
        } else {
            return false;
        }
    }
}
