package com.example.springbootcloudstorageintegrat.property;

import lombok.Data;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author qrn
 * @version 1.0
 * @date 2020/8/11 15:52
 * 阿里云 oss 基础属性配置类:
 */
@Data
@Component
@ConfigurationProperties(prefix = "ossProperties")
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class OssProperties {
    private String bucketName;
    private String accessKey;
    private String secretKey;
    private String region;
    /**
     * 回调地址
     */
    private String callbackUrl;
    /**
     * 存放的目录
     */
    private String dir;
}
