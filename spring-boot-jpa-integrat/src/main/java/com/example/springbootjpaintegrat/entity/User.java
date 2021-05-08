package com.example.springbootjpaintegrat.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @Author qrn
 * @Title
 * @Date 2021/4/27 16:35
 * @time 16:35
 * 创建实体类，指定id创建 自动生成
 */
@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Integer age;
    private String email;
}
