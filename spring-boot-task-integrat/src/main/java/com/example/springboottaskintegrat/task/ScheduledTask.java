package com.example.springboottaskintegrat.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;

@Component
public class ScheduledTask {

    @Autowired
    private RestTemplate restTemplate;


    @Scheduled(cron = "0 0/20 * * * ?")
    public void sendPostRequest() {
        String url = "https://faucet.testnet.sui.io/v1/gas";

        // 构造请求体
        String requestBody = "{\"FixedAmountRequest\":{\"recipient\":\"0x3c6d7bfbe8551e3ecd941a5cf0ccbe02014037012349e9fa09a8bbded814cf43\"}}";

        // 设置请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // 封装请求体和请求头
        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        // 发送POST请求
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

        // 打印返回结果
        System.out.println("Response: " + response.getBody());
    }
}
