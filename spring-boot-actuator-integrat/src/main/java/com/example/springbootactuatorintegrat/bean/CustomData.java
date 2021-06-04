package com.example.springbootactuatorintegrat.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author qrn
 * @Title
 * @Date 2021/6/4 11:49
 * @time 11:49
 * 自定义端点:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomData {

    private String name;

    private Integer age;

}
