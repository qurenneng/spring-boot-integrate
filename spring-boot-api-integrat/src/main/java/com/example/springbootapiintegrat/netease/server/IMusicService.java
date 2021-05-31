package com.example.springbootapiintegrat.netease.server;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springbootapiintegrat.netease.bean.Music;

/**
 * @Author qrn
 * @Title https://blog.csdn.net/qq_4197108
 * @Date 2021/5/27 19:58
 * @time 19:58
 */
public interface IMusicService  extends IService<Music> {


    /**
     * 获取网易云音乐:
     * @return
     */
    String getMusicUrl();


    /**
     * 获取网易云热评
     * @return
     */
    String getHotMusicUrl();

    /**
     * 搜索查询 网易云音乐:
     * @param key
     * @return
     */
    String getMusicSearch(String key);

    /**
     * 网易头条新闻
     * @param start 开始页 默认 1
     * @param num 总页 默认 10
     * @return
     */
    String getNewToutiao(int start,int num);

    /**
     * 网易头条新闻详情:
     * @param docid
     * @return
     */
    String getNewDetai(String docid);

    /**
     * 网易云榜单音乐
     * @param sort 输出分类[热歌榜，新歌榜，飙升榜，抖音榜，电音榜]，为空输出热歌榜
     * @return
     */
    String getRandMusic(String sort);

}
