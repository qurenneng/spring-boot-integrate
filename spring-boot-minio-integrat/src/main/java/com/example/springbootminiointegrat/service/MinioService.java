package com.example.springbootminiointegrat.service;

import com.example.springbootminiointegrat.config.MinioConfig;
import io.minio.MinioClient;
import io.minio.PutObjectOptions;
import io.minio.errors.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.FileNameMap;
import java.net.URLConnection;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author qrn
 * @Title
 * @Date 2021/7/9 17:02
 * @time 17:02
 * minio api 操作文档: http://docs.minio.org.cn/docs/master/java-client-quickstart-guide
 */
@Service
public class MinioService {

    @Autowired
    MinioConfig minioConfig;


    /**
     * 上传文件:
     */
    public String uploadedFile() throws IOException, InvalidKeyException, InvalidResponseException, InsufficientDataException, NoSuchAlgorithmException, InternalException, XmlParserException, InvalidBucketNameException, ErrorResponseException, RegionConflictException {
        try{
            MinioClient minioClient = init();
            boolean bucketExists = minioClient.bucketExists(minioConfig.getBucket());
            //判断捅是否存在，如果不存在那么就创建捅:
            if(!bucketExists){
                minioClient.makeBucket(minioConfig.getBucket());
            }
            File file = new File("spring-boot-minio-integrat/1122.png");
            FileInputStream fileInputStream = new FileInputStream(file);
            PutObjectOptions putObjectOptions = new PutObjectOptions(fileInputStream.available(), -1);
            //这里根据不同文件 设置不同的 contentype 请看参考文档 https://tool.oschina.net/commons/
            //默认设置的是 application/octet-stream 下载文件。
            putObjectOptions.setContentType(getMimeType(file.getPath()));
//            Map<String, String> headers = new HashMap<>();
//            headers.put("Content-Type",getMimeType(file.getPath()));
//            putObjectOptions.setHeaders(headers);
            minioClient.putObject(minioConfig.getBucket(),file.getName(), fileInputStream,putObjectOptions);
            System.out.println("上次文件成功!");
            /**
             * 成功后 生成一个可以访问的url
             */
            String url = minioClient.getObjectUrl(minioConfig.getBucket(),file.getName());
            //获取到url 直接入库存在线的链接就ok了
            return url;
        }catch (InvalidEndpointException | InvalidPortException e) {
            e.printStackTrace();
        }
        return  "";
    }

    public MinioClient init() throws InvalidPortException, InvalidEndpointException {
        MinioClient  minioClient = new MinioClient(minioConfig.getEndpoint(),minioConfig.getAccessKey(),minioConfig.getSecretKey());
        return  minioClient;
    }


    /**
     * 获取文件中的 MimeType
     * @param fileUrl
     * @return
     */
    public  String getMimeType(String fileUrl)
    {
        FileNameMap fileNameMap = URLConnection.getFileNameMap();
        String type = fileNameMap.getContentTypeFor(fileUrl);
        return type;
    }

}
