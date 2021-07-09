package com.example.springbootminiointegrat.service;

import com.example.springbootminiointegrat.config.MinioConfig;
import io.minio.MinioClient;
import io.minio.PutObjectOptions;
import io.minio.errors.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @Author qrn
 * @Title
 * @Date 2021/7/9 17:02
 * @time 17:02
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
            File file = new File("spring-boot-minio-integrat/touxian.jpeg");
            FileInputStream fileInputStream = new FileInputStream(file);
            minioClient.putObject(minioConfig.getBucket(),file.getName(), fileInputStream,new PutObjectOptions(fileInputStream.available(),-1));
            System.out.println("上次文件成功!");
            /**
             * 成功后 生成一个可以访问的url 默认是 7天有效时间
             */
            String url = minioClient.getObjectUrl(minioConfig.getBucket(),file.getName());
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



}
