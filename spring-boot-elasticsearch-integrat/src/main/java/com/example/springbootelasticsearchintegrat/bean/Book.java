package com.example.springbootelasticsearchintegrat.bean;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @Author qrn
 * @Date 2021/5/1 下午10:40
 * @Version 1.0
 * @blog https://blog.csdn.net/qq_41971087
 */
@Document(indexName = "test")
@Data
public class Book {
    private Integer id;

    private String name;
}
