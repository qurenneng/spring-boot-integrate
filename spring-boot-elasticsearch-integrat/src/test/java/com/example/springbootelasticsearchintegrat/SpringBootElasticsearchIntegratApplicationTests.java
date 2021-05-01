package com.example.springbootelasticsearchintegrat;

import com.example.springbootelasticsearchintegrat.bean.Book;
import com.example.springbootelasticsearchintegrat.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Iterator;
import java.util.List;

@SpringBootTest
class SpringBootElasticsearchIntegratApplicationTests {

    @Autowired
    BookRepository bookRepository;

    /**
     * 新建文档
     */
    @Test
    void contextLoads() {
        Book book = new Book();
        book.setId(1);
        book.setName("小明");
        bookRepository.index(book);
    }

    /**
     * 查询数据
     */
    @Test
    void getBook(){
        List<Book> byName = bookRepository.findByName("小明");
        System.out.println(byName);
    }


}
