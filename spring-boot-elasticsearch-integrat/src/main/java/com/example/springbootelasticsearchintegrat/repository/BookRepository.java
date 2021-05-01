package com.example.springbootelasticsearchintegrat.repository;

import com.example.springbootelasticsearchintegrat.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @Author qrn
 * @Date 2021/5/1 下午10:44
 * @Version 1.0
 * @blog https://blog.csdn.net/qq_41971087
 */
public interface BookRepository extends ElasticsearchRepository<Book,Integer> {

    List<Book>  findByName(String name);
}
