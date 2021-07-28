package com.example.springbootapiintegrat.alipay;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.internal.util.AlipaySignature;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.crypto.Cipher;
import java.io.*;
import java.net.URLEncoder;
import java.security.Key;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.X509EncodedKeySpec;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Description: 下单 demo
 */
@Controller
public class PayDemo {

    // 1、支付宝H5 demo
	
    @RequestMapping(value = "/h5test")
    public String h5test() {
        String orderCode = UUID.randomUUID().toString().replace("-", "");
        //加密 此秘钥为约定的秘钥，无需更改
        String pub = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCjW8kxHWXtgUfQRkMy0418PlvvD8CUslJG4AtzXXbcstU+fxC5bL5FEwhq14hvnDtgN//4enhjSfB/6bJV62asXqq5xr5/zAHlMGW1PY/F7Di7ospTv/rQYPX+x1SxGj4ilWtu8Ljpr6q2ZY2h/WfGUpnCgUnTLK/0hGwGoCEtWQIDAQAB";
        Map<String, String> map = new HashMap();
        map.put("version", "1.0");
        map.put("charset", "UTF-8");
        map.put("signType", "01");
        map.put("mid", "xxxxxxxxxxxxxxxxx");//自己的商户
        map.put("orderCode", orderCode);//订单号 保证每个订单号唯一性
        map.put("reqTime", getTime());
//        map.put("txnTimeOut", "20201230101255");
        map.put("productId", "00002022");
        map.put("clearCycle", "0");
        map.put("totalAmount", "000000000101");
        map.put("notifyUrl", "http://test/ntfiy");//商户回调地址
        map.put("frontUrl", "https://www.baidu.com/");
        map.put("clientIp", "172.0.0.1");
        map.put("productName", "商品");

        //此私钥为商户私钥，下单时需要填更换为商户自己的私钥，否则验签不过
        //此私钥为商户私钥，下单时需要填更换为商户自己的私钥，否则验签不过
        PrivatekeyController privatekeyController = new PrivatekeyController();
        PrivateKey privateKey1 = privatekeyController.GetPvkformPfx("xxxxxxxxxxxxxxxxxxxxxxx.pfx", "xxxxxxxxxxxxxxxxxx");
        String privateKey=privatekeyController.encode(privateKey1.getEncoded());

        int b = privateKey.length() - 100;
        String beforKey = privateKey.substring(0, b);
        String afterKey = privateKey.substring(b);
        String name = "";
        //私钥后100位加密
        try {
            byte[] ss = encryptByPublicKey(afterKey.getBytes(), pub);
            String miKey = Base64.encodeBase64String(ss);
            if (miKey.isEmpty()) {
                return "私钥加密失败";
            }
            map.put("beforKey", beforKey);
            map.put("afterKey", miKey);
            String sign = AlipaySignature.rsaSign(map, privateKey, "UTF-8");
            map.put("sign", sign);
            name = URLEncoder.encode(JSON.toJSONString(map), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("https://fcd.sandpay.com.cn/gateway/sand/alih5?name="+name);
        return "redirect:https://fcd.sandpay.com.cn/gateway/sand/alih5?name=" + name;
    }

    /**
     * 当天
     *
     * @return
     */
    public static String getTime() {
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        String format = df.format(date);
        return format;
    }



    private static byte[] encryptByPublicKey(byte[] data, String publicKey) throws Exception {
        byte[] keyBytes = Base64.decodeBase64(publicKey);
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        Key publicK = keyFactory.generatePublic(x509KeySpec);
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, publicK);
        int inputLen = data.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > 117) {
                cache = cipher.doFinal(data, offSet, 117);
            } else {
                cache = cipher.doFinal(data, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * 117;
        }
        byte[] encryptedData = out.toByteArray();
        out.close();
        return encryptedData;
    }

    private static JSONObject doPost(String url, Map<String, String> map) {
        HttpPost post = new HttpPost(url);
        JSONObject response = null;
        try {
            StringEntity s = new StringEntity(JSON.toJSONString(map), "UTF-8");
            s.setContentType("application/json");
            post.setEntity(s);
            HttpResponse res = HttpClients.createDefault().execute(post);
            if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String result = EntityUtils.toString(res.getEntity());
                response = JSON.parseObject(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
}
