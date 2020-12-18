package com.edu.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * spring main
 *
 * @Author lxj
 * @Date 2020-11-02 15:33
 **/
@EnableScheduling
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.edu.demo")
public class MainApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApiApplication.class, args);
    }

}
