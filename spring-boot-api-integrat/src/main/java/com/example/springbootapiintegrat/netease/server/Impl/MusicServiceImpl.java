package com.example.springbootapiintegrat.netease.server.Impl;

import cn.hutool.http.HttpUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootapiintegrat.ncov.common.ShareUrl;
import com.example.springbootapiintegrat.netease.bean.Music;
import com.example.springbootapiintegrat.netease.common.NeteaseConfig;
import com.example.springbootapiintegrat.netease.mapper.MusicMapper;
import com.example.springbootapiintegrat.netease.server.IMusicService;
import org.springframework.stereotype.Service;

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
}
