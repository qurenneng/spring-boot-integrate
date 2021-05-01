package com.example.springbootredisintegrat.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author qrn
 * @Date 2021/5/1 下午2:38
 * @Version 1.0
 * @blog https://blog.csdn.net/qq_41971087
 */
@Data
public class Employee implements Serializable {

    private Integer id;
    @TableField("lastName") // 数据库非主键字段
    private String lastName;
    private String email;
    private Integer gender;
    @TableField("dId") // 数据库非主键字段
    private Integer dId;
}
