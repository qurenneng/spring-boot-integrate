package com.example.springbootminiointegrat.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author qrn
 * @Title
 * @Date 2021/7/9 16:20
 * @time 16:20
 */
@Component
@Setter
@Getter
public class MinioConfig {

    /**
     * 对象存储访问路劲
     */
    @Value("${minio.endpoint}")
    private String endpoint;

    /**
     * 唯一标识
     */
    @Value("${minio.accessKey}")
    private String accessKey;

    /**
     *账户的密码
     */
    @Value("${minio.secretKey}")
    private String secretKey;
    /**
     * 存储捅
     */
    @Value("${minio.bucket}")
    private String bucket;


}
