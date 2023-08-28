package com.demo_230712;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.demo_230712.mapper")
public class Demo230712Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo230712Application.class, args);
    }

}
