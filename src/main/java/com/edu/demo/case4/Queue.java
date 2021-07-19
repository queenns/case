package com.edu.demo.case4;

public abstract class Queue {

    public static void main(String[] args) {
        int mod = mockMod(1, 5);
        System.out.println(mod);
    }

    public static int mockMod(int i, int capacity) {
        return (i + 1) % capacity;
    }

}
