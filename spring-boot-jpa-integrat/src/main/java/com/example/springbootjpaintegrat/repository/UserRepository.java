package com.example.springbootjpaintegrat.repository;

import com.example.springbootjpaintegrat.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @Author qrn
 * @Title
 * @Date 2021/5/8 12:41
 * @time 12:41
 * 定义用户的操作接口继承  CrudRepository 失效crud
 */
public interface UserRepository extends CrudRepository<User, Integer> {
}
