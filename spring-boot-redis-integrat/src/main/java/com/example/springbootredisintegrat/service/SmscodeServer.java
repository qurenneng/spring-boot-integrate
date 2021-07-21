package com.example.springbootredisintegrat.service;

/**
 * @Author qrn
 * @Date 2021/7/21 下午9:15
 * @Version 1.0 短信验证码 模拟
 * @blog https://blog.csdn.net/qq_41971087
 * 1. 获取短信验证码 2分钟过期
 * 2。每天只能发送3次验证码
 * 3。验证码校验：
 */
public interface SmscodeServer {

    /**
     * 设置 短信验证码到redis中
     * @param phone
     * @param code
     * @return
     */
    String smsCode(String phone,String code);

    /**
     * 校验短信验证码：
     * @param code
     * @return
     */
    String signCode(String code);

}
