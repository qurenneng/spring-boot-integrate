package com.example.springbootdruidintegrat.controller;

import com.alibaba.druid.stat.DruidStatManagerFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author qrn
 * @Title
 * @Date 2021/6/23 16:48
 * @time 16:48
 *获取 Druid 的监控数据
 */
@RestController
public class DruidStatController {

    @GetMapping("/stat")
    public Object druidStat(){
        //该方法可以获取所有数据源的监控数据，除此之外 DruidStatManagerFacade 还提供了一些其他方法，你可以按需选择使用。
        return DruidStatManagerFacade.getInstance().getDataSourceStatDataList();
    }
}
