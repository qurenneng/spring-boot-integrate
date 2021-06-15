package com.example.springbootcloudstorageintegrat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 整合 阿里云oss 腾讯云 cos 阿里云 web直传实例
 * 为了降低服务端压力，上传文件直接走js 服务端只做签名加密工作，降低服务端压力。
 */
@SpringBootApplication
public class SpringBootCloudstorageIntegratApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCloudstorageIntegratApplication.class, args);
	}

}
