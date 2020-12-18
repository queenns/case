package com.edu.demo.case2.predict4j;

import java.io.IOException;
import java.util.List;

public class UserCallDemo {

    PredictHandle PHer;

    {
        try {
            // ClassPathResource classPathResource = new ClassPathResource(modelPath);
            PHer = new PredictHandle();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public double predictor(double[] features) {
        List<Double> forecast = PHer.calculPrice(features);
        if (forecast.size() != 1) {
            System.out.print("predict error!");
        }
        return forecast.get(0);
    }


    public static void main(String args[]) throws IOException {
        double[] features = new double[11];
        String[] arr = "33 199 2 14 5992 14.8 5 6 2.5273273656719524 2009 1".split(" ");

        for (int i = 0; i < 11; i++) {
            features[i] = Double.valueOf(arr[i]);
        }

        double predictValue = new UserCallDemo().predictor(features);
        System.out.print("predictValue :" + predictValue);
    }
}
