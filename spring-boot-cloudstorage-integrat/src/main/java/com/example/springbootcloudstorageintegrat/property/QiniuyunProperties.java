package com.example.springbootcloudstorageintegrat.property;

import lombok.Data;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author qrn
 * @Title
 * @Date 2021/6/15 12:48
 * @time 12:48
 */
@Data
@Component
@ConfigurationProperties(prefix = "qiniuyunProperties")
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class QiniuyunProperties {
    private String bucketName;
    private String accessKey;
    private String secretKey;
}
