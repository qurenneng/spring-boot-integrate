package com.example.springbootapiintegrat.ncov.server.impl;

import cn.hutool.http.HttpUtil;
import com.example.springbootapiintegrat.ncov.common.ShareUrl;
import com.example.springbootapiintegrat.ncov.server.INcovServer;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @Author qrn
 * @Title https://blog.csdn.net/qq_41971087
 * @Date 2021/5/25 15:12
 * @time 15:12
 * 新冠数据接口:
 */
@Service
public class NcovServeImpl implements INcovServer {

    /**
     * 新冠全国疫情(腾讯)
     * @return
     */
    @Override
    public String getOnsInfo() {
        return HttpUtil.get(ShareUrl.ONSINFOURL);
    }

    /**
     * 新冠全国疫情（136）
     */
    @Override
    public String listTotal() {
        return HttpUtil.get(ShareUrl.LISTTOTAL);
    }

    /**
     * 冠全国疫情（新浪）
     * @return
     */
    @Override
    public String newsWapList() {
        return HttpUtil.get(ShareUrl.NEWSWAP);
    }
}
