package com.example.springbootapiintegrat.netease.server.Impl;

import cn.hutool.http.HttpUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootapiintegrat.ncov.common.ShareUrl;
import com.example.springbootapiintegrat.netease.bean.Music;
import com.example.springbootapiintegrat.netease.common.NeteaseConfig;
import com.example.springbootapiintegrat.netease.mapper.MusicMapper;
import com.example.springbootapiintegrat.netease.server.IMusicService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author qrn
 * @Title https://blog.csdn.net/qq_4197108
 * @Date 2021/5/27 19:59
 * @time 19:59
 */
@Service
public class MusicServiceImpl extends ServiceImpl<MusicMapper, Music> implements IMusicService {

    /**
     * 获取网易云音乐:
     * @return
     */
    @Override
    public String getMusicUrl() {
        return HttpUtil.get(NeteaseConfig.MUSICURL);
    }

    /**
     * 获取网易云热评:
     * @return
     */
    @Override
    public String getHotMusicUrl() {
        return HttpUtil.get(NeteaseConfig.HOTMUSICURL);
    }

    /**
     * 搜索查询 网易云音乐:
     * @param key
     * @return
     */
    @Override
    public String getMusicSearch(String key) {
        Map<String,Object> map = new HashMap<>();
        map.put("keyword",key);
        return HttpUtil.get(NeteaseConfig.MUSICURLSEARCH,map);
    }

    /**
     * 网易头条新闻:
     * @param start 开始页 默认 1
     * @param num 总页 默认 10
     * @return
     */
    @Override
    public String getNewToutiao(int start, int num) {
        Map<String,Object> map = new HashMap<>();
        map.put("start",start);
        map.put("num",num);
        return HttpUtil.get(NeteaseConfig.NEWTOUTIAO,map);
    }

    /**
     * 网易头条新闻 详情:
     * @param docid 网易新闻的docid
     * @return
     */
    @Override
    public String getNewDetai(String docid) {
        Map<String,Object> map = new HashMap<>();
        map.put("docid",docid);
        return HttpUtil.get(NeteaseConfig.NEWDETAI,map);
    }

    /**
     * ssl ??????
     * @param sort 输出分类[热歌榜，新歌榜，飙升榜，抖音榜，电音榜]，为空输出热歌榜
     * @return
     */
    @Override
    public String getRandMusic(String sort) {
        Map<String,Object> map = new HashMap<>();
        map.put("sort",sort);
        map.put("format","json");
        return HttpUtil.get(NeteaseConfig.RANDMUSIC,map);
    }
}
