package com.example.springbootcloudstorageintegrat.property;

import lombok.Data;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "cosProperties")
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class CosProperties {
    private String bucketName;
    private String accessKey;
    private String secretKey;
    private String region;

}