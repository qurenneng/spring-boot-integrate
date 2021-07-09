package com.example.springbootapiintegrat.sande.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Author qrn
 * @Title
 * @Date 2021/7/9 11:54
 * @time 11:54
 * 配置类:
 */
@Component
@Setter
@Getter
public class ShanDePayConfig {

    /**
     * 商户id
     */
    @Value("sande.mid")
    private String mid;
    /**
     * 平台商户id
     */
    @Value("sande.plMid")
    private String plMid;

    /**
     * 请求路径:
     */
    @Value("sande.url")
    private String url;

    /**
     * 配置文件中的商户私钥证书路径常量
     */
    @Value("signCert.path")
    private String signCertPath;
    /**
     * 配置文件中的商户私钥证书密码常量
     */
    @Value("signCert.pwd")
    private String signCertPwd;
    /**
     * 配置文件中的杉德证书路径常量
     */
    @Value("sandCert.path")
    private String sandCertPath;

}
