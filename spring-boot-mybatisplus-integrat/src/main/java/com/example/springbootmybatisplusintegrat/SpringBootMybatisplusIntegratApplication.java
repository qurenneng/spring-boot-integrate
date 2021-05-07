package com.example.springbootmybatisplusintegrat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//加上这个注解后，后面的mapper 就不需要每次都加@mapper注解 ！
@MapperScan("com.example.springbootmybatisplusintegrat.*.mapper")
public class SpringBootMybatisplusIntegratApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMybatisplusIntegratApplication.class, args);
	}

}
