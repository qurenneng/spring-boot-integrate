package com.example.springbootmongodbintegrat.repository;

import com.example.springbootmongodbintegrat.bean.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @Author qrn
 * @Title
 * @Date 2021/5/27 11:58
 * @time 11:58
 * 使用 jpa 去操作 MongoDB
 */
public interface UserRepository  extends CrudRepository<User, Integer> {
}
