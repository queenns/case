package com.edu.demo.case2.predict4j;

import com.google.common.collect.Lists;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author liu.xiaojian
 * @Date 2020-12-17 16:22
 **/
public class FileReader {

    private static String MODEL_FILE_PATH = "/appraise/20201216_Verification-v1.0.txt";

    public static List<String> readLines() {
        ClassPathResource classPathResource = new ClassPathResource(MODEL_FILE_PATH);
        try (InputStream stream = classPathResource.getInputStream()) {
            return IOUtils.readLines(stream);
        } catch (IOException e) {
            e.printStackTrace();
            return Lists.newArrayListWithCapacity(0);
        }
    }

}
