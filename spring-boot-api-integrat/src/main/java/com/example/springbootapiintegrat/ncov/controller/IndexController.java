package com.example.springbootapiintegrat.ncov.controller;

import com.example.springbootapiintegrat.ncov.server.INcovServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author qrn
 * @Title
 * @Date 2021/5/25 15:39
 * @time 15:39
 */
@RestController
@RequestMapping("/index/")
public class IndexController {

    @Autowired
    INcovServer iNcovServer;

    /**
     * 新冠全国疫情(腾讯)
     * @return
     */
    @GetMapping("getOnsInfo")
    public String getOnsInfo(){
        return  iNcovServer.getOnsInfo();
    }

    /**
     * 新冠全国疫情（136）
     * @return
     */
    @GetMapping("listTotal")
    public String listTotal(){
        return  iNcovServer.listTotal();
    }

    /**
     * 新冠全国疫情（新浪）
     * @return
     */
    @GetMapping("newsWapList")
    public String newsWapList(){
        return  iNcovServer.newsWapList();
    }

}
