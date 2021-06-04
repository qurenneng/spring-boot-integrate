package com.example.springbootwebfluxintegrat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.springbootwebfluxintegrat.mapper")
public class SpringBootWebfluxIntegratApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebfluxIntegratApplication.class, args);
    }

}
