package com.example.springbootapiintegrat.netease.controller;

import com.example.springbootapiintegrat.netease.server.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author qrn
 * @Title
 * @Date 2021/5/29 17:21
 * @time 17:21
 * 网易云控制层:
 */
@RestController
@RequestMapping("/netease/")
public class NeteaseController {


    @Autowired
    IMusicService iMusicService;

    /**
     * 获取网易云音乐:
     * @return
     */
    @RequestMapping("getMusicUrl")
    public String getMusicUrl(){
        return  iMusicService.getMusicUrl();
    }

    /**
     * 获取网易云热评:
     * @return
     */
    @RequestMapping("getHotMusicUrl")
    public String getHotMusicUrl(){
        return  iMusicService.getHotMusicUrl();
    }


    /**
     * 网易云音乐搜索:
     * @param key
     * @return
     */
    @RequestMapping("getMusicSearch")
    public String getMusicSearch(String key){
        return  iMusicService.getMusicSearch(key);
    }

    /**
     * 网易头条新闻:
     * @param start
     * @param num
     * @return
     */
    @RequestMapping("getNewToutiao")
    public String getNewToutiao(int start,int num){
        return  iMusicService.getNewToutiao(start,num);
    }

    /**
     * 网易头条新闻详情:
     * @param docid 头条新闻docid
     * @return
     */
    @RequestMapping("getNewDetai")
    public String getNewDetai(String docid){
        return  iMusicService.getNewDetai(docid);
    }

    /**
     * 网易头条新闻详情:
     * @param sort 输出分类[热歌榜，新歌榜，飙升榜，抖音榜，电音榜]，为空输出热歌榜
     * @return
     */
    @RequestMapping("getRandMusic")
    public String getRandMusic(String sort){
        return  iMusicService.getRandMusic(sort);
    }
}
