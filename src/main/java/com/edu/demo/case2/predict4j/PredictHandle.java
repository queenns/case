package com.edu.demo.case2.predict4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PredictHandle {

    Boosting boosting = null;
    Map<String, String> map = null;
    OverallConfig config = null;
    Predictor predictor = null;

    int featuresSize = 83;

    //��ʼ������
    public Map<Double, Double> CityRelevant = new HashMap<Double, Double>() {
        {
            put(199.0, -0.35);
            put(200.0, 0.89);
        }
    };

    public PredictHandle() throws IOException {
        boosting = Boosting.createBoosting();
        // predict config, just like predict.conf in LightGBM
        map = new HashMap<String, String>();
        config = new OverallConfig();
        config.set(map);
        predictor =
                new Predictor(boosting, config.io_config.num_iteration_predict, config.io_config.is_predict_raw_score,
                        config.io_config.is_predict_leaf_index, config.io_config.pred_early_stop,
                        config.io_config.pred_early_stop_freq, config.io_config.pred_early_stop_margin);

    }

    public List<Double> calculPrice(int[] indices, double[] values) {

        SparseVector v = new SparseVector(values, indices);
        List<Double> predicts = predictor.predict(v);
        return predicts;


    }


    /**
     *
     */
    public double[] bulidData(double[] inputValues) {
        double[] calculData = new double[featuresSize];
        int len = inputValues.length;
        for (int i = 0; i < len; i++) {
            calculData[i] = inputValues[i];
        }
        double city = inputValues[1];
        boolean sign = CityRelevant.containsKey(city);
        if (sign) {
            calculData[len] = CityRelevant.get(city);
        } else {
            calculData[len] = 0.1;
        }

        for (int i = len + 1; i < featuresSize; i++) {
            calculData[i] = 0.99;
        }

        return calculData;
    }


    public List<Double> calculPrice(double[] inputValues) {
        int[] indices = new int[featuresSize];

        for (int i = 0; i < featuresSize; i++) {
            indices[i] = i;
        }

        double[] calculData = bulidData(inputValues);
        SparseVector v = new SparseVector(calculData, indices);
        List<Double> predicts = predictor.predict(v);
        return predicts;

    }

}
