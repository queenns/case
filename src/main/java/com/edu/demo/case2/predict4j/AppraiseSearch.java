package com.edu.demo.case2.predict4j;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

/**
 * 估价搜索
 *
 * @Author liu.xiaojian
 * @Date 2020-12-17 11:26
 **/
@Component
public class AppraiseSearch {

    private PredictHandle predictHandle;

    {
        try {
            predictHandle = new PredictHandle();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public double search(double[] values) {
        return predictor(values);
    }

    private double predictor(double[] features) {
        List<Double> forecast = predictHandle.calculPrice(features);
        if (forecast.size() != 1) {
            System.out.print("predict error!");
        }
        return forecast.get(0);
    }

}
