package com.example.springboottaskintegrat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@EnableAsync//开启异步支持
@EnableScheduling //开启定时任务支持
public class SpringBootTaskIntegratApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTaskIntegratApplication.class, args);
    }

}
