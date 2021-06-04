package com.example.springbootactuatorintegrat.config;

import com.example.springbootactuatorintegrat.bean.CustomData;
import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @Author qrn
 * @Title
 * @Date 2021/6/4 11:38
 * @time 11:38
 *
 */
@Configuration(proxyBeanMethods = false)
public class MySecurityConfiguration {


    /**
     * 如果加入了 security 想不验证身份也能访问，那么就加上一下配置：
     * @param http
     * @return
     * @throws Exception
     */
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.requestMatcher(EndpointRequest.toAnyEndpoint())
//                .authorizeRequests((requests) -> requests.anyRequest().permitAll());
//        return http.build();
//    }

    /**
     * 自定义端点:
     * @return
     */
    @ReadOperation
    public CustomData getData() {
        return new CustomData("test", 5);
    }
}
