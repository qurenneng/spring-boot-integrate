package com.example.springbootminiointegrat.controller;

import com.example.springbootminiointegrat.service.MinioService;
import io.minio.errors.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @Author qrn
 * @Title minio 存储 控制层:
 * @Date 2021/7/9 17:29
 * @time 17:29
 */
@RestController
@RequestMapping("/minio/")
public class MinioController {

    @Autowired
    MinioService minioService;

    @GetMapping("uploadedFile")
    public String uploadedFile() throws IOException, InvalidResponseException, RegionConflictException, InvalidKeyException, NoSuchAlgorithmException, ErrorResponseException, XmlParserException, InvalidBucketNameException, InsufficientDataException, InternalException {
       return  minioService.uploadedFile();
    }
}
