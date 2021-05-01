package com.example.springbootredisintegrat.config;

import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import com.alibaba.fastjson.*;
import java.nio.charset.Charset;

/**
 * @Author qrn
 * @Date 2021/5/1 下午8:35
 * @Version 1.0
 * @blog https://blog.csdn.net/qq_41971087
 * 序列化与反序列化
 */
public class FastJsonRedisSerializer <T> implements RedisSerializer<T> {
    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");
    private Class<T> clazz;
    public FastJsonRedisSerializer(Class<T> clazz) {
        super();
        this.clazz = clazz;
    }

    @Override
    public byte[] serialize(T t) throws SerializationException {
        if (t == null) {
            return new byte[0];
        }
        return JSON.toJSONString(t, SerializerFeature.WriteClassName).getBytes(DEFAULT_CHARSET);
    }

    @Override
    public T deserialize(byte[] bytes) throws SerializationException {
        if (bytes == null || bytes.length <= 0) {
            return null;
        }
        String str = new String(bytes, DEFAULT_CHARSET);
        ParserConfig.getGlobalInstance().setAsmEnable(true);
        return JSON.parseObject(str, clazz);
    }
}
