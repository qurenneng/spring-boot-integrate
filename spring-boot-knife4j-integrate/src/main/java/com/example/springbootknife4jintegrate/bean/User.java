package com.example.springbootknife4jintegrate.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author qrn
 * @Date 2021/4/18 上午11:11
 * @Version 1.0
 * @blog https://blog.csdn.net/qq_41971087
 */
@Data
public class User {

    @ApiModelProperty(value = "用户id")
    private Integer id;

    @ApiModelProperty(value = "用户名称")
    private String name;
    @ApiModelProperty(value = "用户年龄")
    private String age;

}
