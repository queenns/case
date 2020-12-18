package com.edu.demo.case2.predict4j;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author liu.xiaojian
 * @Date 2020-12-18 09:29
 **/
public class RequestFormat {
    private static String DELIMITER = ",";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("/home/liuxiaojian/Downloads/test_data.csv"));
        String title = reader.readLine();
        System.out.println(title);

        PrintWriter writer = new PrintWriter(new File("/home/liuxiaojian/Downloads/ok.csv"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        ObjectMapper mapper = new ObjectMapper();

        String line;
        while ((line = reader.readLine()) != null) {

            String item[] = line.split(",");

            AppraiseForm appraiseForm = new AppraiseForm();

            appraiseForm.setProvinceId(Integer.parseInt(item[0]));
            appraiseForm.setCityId(Integer.parseInt(item[1]));
            appraiseForm.setPbId(Integer.parseInt(item[2]));
            appraiseForm.setPserId(Integer.parseInt(item[3]));
            appraiseForm.setMid(Integer.parseInt(item[4]));
            appraiseForm.setMileAge(Double.parseDouble(item[5]));
            appraiseForm.setColor(Integer.parseInt(item[6]));

            LocalDateTime localDateTimeCardTime = LocalDateTime.of(Integer.valueOf(item[7]), Integer.valueOf(item[8]), Integer.valueOf(item[9]), 0, 0);
            Integer cardTime = Integer.parseInt(formatter.format(localDateTimeCardTime));
            appraiseForm.setCardTime(cardTime);

            appraiseForm.setStatus(Integer.parseInt(item[10]));

            LocalDateTime localDateTimeCreateTime = LocalDateTime.of(Integer.valueOf(item[11]), Integer.valueOf(item[12]), Integer.valueOf(item[13]), 0, 0);
            Integer createTime = Integer.parseInt(formatter.format(localDateTimeCreateTime));
            appraiseForm.setCreateTime(createTime);

            LocalDateTime localDateTimeUpdateTime = LocalDateTime.of(Integer.valueOf(item[14]), Integer.valueOf(item[15]), Integer.valueOf(item[16]), 0, 0);
            Integer updateTime = Integer.parseInt(formatter.format(localDateTimeUpdateTime));
            appraiseForm.setUpdateTime(updateTime);

            String json = mapper.writeValueAsString(appraiseForm);

            StringBuilder builder = new StringBuilder();
            builder.append("http://data-api.xcar.com.cn:80/xcar-index-data-api/v1/appraise/worn POST ");
            builder.append(json);
            builder.append('\n');

            writer.write(builder.toString());

        }
        writer.close();
    }
}
