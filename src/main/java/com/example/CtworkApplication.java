package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(exclude = MongoAutoConfiguration.class)
@MapperScan(value = "com.example.dao")
@EnableAsync
public class CtworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(CtworkApplication.class, args);
    }

}
