package com.edu.demo.case2.predict4j;


public abstract class Decision<T> {
    abstract boolean decision(T fval, T threshold);
}
