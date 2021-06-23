package com.example.springbootdruidintegrat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * springboot 整合 Druid 数据库连接池:
 */
@SpringBootApplication
@MapperScan("com.example.springbootdruidintegrat.mapper")
public class SpringBootDruidIntegratApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDruidIntegratApplication.class, args);
	}
}
