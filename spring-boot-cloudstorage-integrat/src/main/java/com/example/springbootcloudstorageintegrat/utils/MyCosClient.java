package com.example.springbootcloudstorageintegrat.utils;

import com.example.springbootcloudstorageintegrat.property.CosProperties;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.GetObjectRequest;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;

import java.io.File;

public class MyCosClient {

    private CosProperties cos;
    private COSClient cosClient;
    private COSCredentials cred;
    private ClientConfig clientConfig;

    public MyCosClient(CosProperties cosProperties) {
        cos = cosProperties;
        // 1 初始化用户身份信息(secretId, secretKey)
        cred = new BasicCOSCredentials(cos.getAccessKey(), cos.getSecretKey());
        // 2 设置bucket的区域, COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
        clientConfig = new ClientConfig(new Region(cos.getRegion()));
        // 3 生成cos客户端
        cosClient = new COSClient(cred, clientConfig);
        //bucket的命名规则为{name}-{appid} ，此处填写的存储桶名称必须为此格式
    }

    public PutObjectResult upload(String localFile, String uploadKey) {
        File upFile = new File(localFile);
        // 指定要上传到 COS 上的路径
        PutObjectRequest putObjectRequest = new PutObjectRequest(cos.getBucketName(), uploadKey, upFile);
        PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
        cosClient.shutdown();
        return putObjectResult;
    }

    public ObjectMetadata download(String localFile, String downloadKey) {
        File downFile = new File(localFile);
        // 指定要下载的文件所在的 bucket 和对象键
        GetObjectRequest getObjectRequest = new GetObjectRequest(cos.getBucketName(), downloadKey);
        ObjectMetadata downObjectMeta = cosClient.getObject(getObjectRequest, downFile);
        return downObjectMeta;
    }

}
