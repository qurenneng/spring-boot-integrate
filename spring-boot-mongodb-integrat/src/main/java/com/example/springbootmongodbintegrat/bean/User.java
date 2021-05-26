package com.example.springbootmongodbintegrat.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Author qrn
 * @Title
 * @Date 2021/5/26 17:30
 * @time 17:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "user")
public class User {
    @Id
    private Integer id;
    private String title;
    private String name;
    private Integer age;
}
