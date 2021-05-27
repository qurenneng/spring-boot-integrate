package com.example.springbootapiintegrat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 实现免费接口 api 实例demo
 *
 */
@SpringBootApplication
@MapperScan("com.example.springbootapiintegrat.*.mapper")
public class SpringBootApiIntegratApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApiIntegratApplication.class, args);
	}

}
