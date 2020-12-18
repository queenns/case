package com.edu.demo.case2.predict4j;

import java.util.Map;


public class OverallConfig extends ConfigBase {
    public IOConfig io_config = new IOConfig();

    @Override
    public void set(Map<String, String> params) {
        io_config.set(params);
    }
}
