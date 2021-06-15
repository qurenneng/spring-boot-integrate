package com.example.springbootcloudstorageintegrat.controller;


import com.example.springbootcloudstorageintegrat.property.CosProperties;
import com.example.springbootcloudstorageintegrat.property.OssProperties;
import com.example.springbootcloudstorageintegrat.property.QiniuyunProperties;
import com.example.springbootcloudstorageintegrat.utils.ossAuth.OssStsAuth;
import com.example.springbootcloudstorageintegrat.utils.qcould.QcloudStsAuth;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class CommonApiController {
    @Autowired
    private CosProperties cosProperties;

    @Autowired
    private OssProperties ossProperties;

    @Autowired
    private QiniuyunProperties qiniuyunProperties;

    /**
     * 腾讯云 cos web 直传
     * @param method
     * @param pathname
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     * @throws InvalidKeyException
     */
    @GetMapping("/uploadSign")
    public Map<String, String> uploadSign(@RequestParam(value = "method") String method,
                                          @RequestParam(value = "pathname") String pathname) throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException {
        QcloudStsAuth stsAuth = new QcloudStsAuth(cosProperties);
        Map<String, String> map = stsAuth.sign(method, pathname);
        return map;
    }


    /** 阿里云 oss web直传
     * 验证签名:
     * @return
     */
    @GetMapping("/callbackSign")
    public Map<String, String> callbackSign(){
        OssStsAuth ossStsAuth= new OssStsAuth();
        Map<String, String> sign = ossStsAuth.getSign(ossProperties);
        return  sign;
    }

    /**
     * 阿里云  oss 回调进行回调:
     * @return
     */
    @RequestMapping("/callbackUrl")
    public void callbackUrl(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        OssStsAuth ossStsAuth= new OssStsAuth();
        String ossCallbackBody = ossStsAuth.GetPostBody(request.getInputStream(),
                Integer.parseInt(request.getHeader("content-length")));
        boolean b = ossStsAuth.VerifyOSSCallbackRequest(request, ossCallbackBody);
        if(b){
            ossStsAuth.response(request, response, "{\"Status\":\"OK\"}", HttpServletResponse.SC_OK);
        }else{
            ossStsAuth.response(request, response, "{\"Status\":\"verdify not ok\"}", HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    /**
     * 七牛云授权: web 直传
     * @return
     */
    @RequestMapping("/upToken")
    public String qiniuAuth(){
        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String  key = null;
        Auth auth = Auth.create(qiniuyunProperties.getAccessKey(), qiniuyunProperties.getSecretKey());
        String sign = auth.uploadToken(qiniuyunProperties.getBucketName(), key);
        return sign;
    }
}
