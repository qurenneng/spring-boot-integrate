package com.example.springbootcloudstorageintegrat.utils.qcould;

import com.example.springbootcloudstorageintegrat.property.CosProperties;
import com.example.springbootcloudstorageintegrat.utils.Json.JSONObject;
import com.example.springbootcloudstorageintegrat.utils.qcould.module.Sts;
import com.qcloud.cos.utils.UrlEncoderUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.HmacUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * @author qrn
 * @version 1.0
 * @date 2020/8/11 18:45
 * 腾讯云 cos
 */

public class QcloudStsAuth {
    private TreeMap<String, Object> config;
    private String appId;
    private String name;

    /**
     * 指定桶的名字:
     */
    private String backNmae;

    private static final String LINE_SEPARATOR = "\n";
    private static final String Q_SIGN_ALGORITHM_KEY = "q-sign-algorithm";
    private static final String Q_SIGN_ALGORITHM_VALUE = "sha1";
    private static final String Q_AK = "q-ak";
    private static final String Q_SIGN_TIME = "q-sign-time";
    private static final String Q_KEY_TIME = "q-key-time";
    private static final String Q_HEADER_LIST = "q-header-list";
    private static final String Q_URL_PARAM_LIST = "q-url-param-list";
    private static final String Q_SIGNATURE = "q-signature";
    private static final long SIGN_EXPIRED_TIME = 3600;

    public QcloudStsAuth(CosProperties cosProperties) {
        config = new TreeMap<String, Object>();
        config.put("SecretId", cosProperties.getAccessKey());
        config.put("SecretKey", cosProperties.getSecretKey());
        /* 请求方法类型 POST、GET */
        config.put("RequestMethod", "GET");
        /* 区域参数，可选: gz:广州; sh:上海; hk:香港; ca:北美;等。 */
        config.put("DefaultRegion", cosProperties.getRegion());
//        config.put("DefaultRegion", "ap-beijing");
        String bucketName = cosProperties.getBucketName();
        String[] split = bucketName.split("-");
        appId =  split[split.length-1];
        backNmae = bucketName;
    }

    public Map<String, String> sign(String method, String pathname) throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException {

        QcloudApiModuleCenter module = new QcloudApiModuleCenter(new Sts(), config);

        TreeMap<String, Object> params = new TreeMap<String, Object>();
        /* 将需要输入的参数都放入 params 里面，必选参数是必填的。 */
        params.put("Action", "GetFederationToken");
        params.put("Nonce", (int) (Math.random() * 10000) + 10000);
        params.put("Region", "");
        params.put("SecretId", config.get("SecretId").toString());
        params.put("Timestamp", (int) (System.currentTimeMillis() / 1000));
        params.put("durationSeconds", 7200);
        params.put("name", "");

        Map<String, Object> sta = new TreeMap<String, Object>();
        List<String> action = new ArrayList<String>();
        action.add("name/cos:*");
        sta.put("action", action);
        sta.put("effect", "allow");
        Map<String, Object> qcs = new TreeMap<String, Object>();
        List<String> temp = new ArrayList<String>();
        temp.add("qcs::cam::anyone:anyone");
        qcs.put("qcs", temp);
        sta.put("principal", qcs);
        List<String> resource = new ArrayList<String>();
//        String tmpStr = "qcs::cos:"+config.get("DefaultRegion").toString()+":uid/"+appId+":prefix//"+appId+"/"+name+"/";
//        resource.add(tmpStr);
//        resource.add(tmpStr+"*");
        //      policy 生成 出现的问题  {"code":4000,"message":"(60024)you are not resource owner","codeDesc":"StrategyResourceInvalid "}
        //Policy权限设置 建议生成 后与 腾讯云后台的比较， 实在不行就以后台生成的为准，先测试看签名能不能过
        String tmpStr = "qcs::cos:"+config.get("DefaultRegion").toString()+":uid/"+appId+":"+backNmae+"/";
        resource.add(tmpStr+"*");
        sta.put("resource", resource);
        List<Object> statement = new ArrayList<Object>();
        statement.add(sta);
        Map<String, Object> policy = new LinkedHashMap<String, Object>();
        policy.put("version", "2.0");
        policy.put("statement", statement);
        String policyStr = new JSONObject(policy).toString();
        params.put("policy", policyStr);
        String paramStr = "GETsts.api.qcloud.com/v2/index.php" + Sign.buildParamStr(params, "GET");
        String signature = URLEncoder.encode(Sign.sign(paramStr, config.get("SecretKey").toString(), "sha1"),"UTF-8");
        params.put("Signature", signature);

        Map<String, String> res = new HashMap<String, String>();
        try {
            /* call 方法正式向指定的接口名发送请求，并把请求参数params传入，返回即是接口的请求结果。 */
            //验证签名 返回签名后需要的数据
            String result = module.call("GetFederationToken", params);

            JSONObject json_result = new JSONObject(result);
            JSONObject data = json_result.getJSONObject("data");
            JSONObject credentials = data.getJSONObject("credentials");
            String tmpSecretId = credentials.getString("tmpSecretId");
            String tmpSecretKey = credentials.getString("tmpSecretKey");
            String sessionToken = credentials.getString("sessionToken");
            Map<String, String> tempKey = new HashMap<String, String>();
            Map<String, String> headerMap = new HashMap<String, String>();
            Map<String, String> paramMap = new HashMap<String, String>();
            tempKey.put("tmpSecretId", tmpSecretId);
            tempKey.put("tmpSecretKey", tmpSecretKey);
            Date expiredTime = new Date(System.currentTimeMillis() + 600000);
            String authorization = getAuthorization(method, pathname, headerMap, paramMap, tempKey, expiredTime);
            res.put("Authorization", authorization);
            res.put("XCosSecurityToken", sessionToken);
            return res;
        } catch (Exception e) {
            System.out.println("error..." + e.getMessage());
            return null;
        }
    }

    private String getAuthorization(String methodName, String resouce_path,
                                    Map<String, String> headerMap, Map<String, String> paramMap,
                                    Map<String, String> tempKey, Date expiredTime) {


        Map<String, String> signHeaders = buildSignHeaders(headerMap);
        // 签名中的参数和http 头部 都要进行字符串排序
        TreeMap<String, String> sortedSignHeaders = new TreeMap<>();
        TreeMap<String, String> sortedParams = new TreeMap<>();

        sortedSignHeaders.putAll(signHeaders);
        sortedParams.putAll(paramMap);

        String qHeaderListStr = buildSignMemberStr(sortedSignHeaders);
        String qUrlParamListStr = buildSignMemberStr(sortedParams);
        String qKeyTimeStr, qSignTimeStr;
        qKeyTimeStr = qSignTimeStr = buildTimeStr(expiredTime);
        String signKey = HmacUtils.hmacSha1Hex(tempKey.get("tmpSecretKey").toString(), qKeyTimeStr);
        String formatMethod = methodName.toLowerCase();
        String formatUri = resouce_path;
        String formatParameters = formatMapToStr(sortedParams);
        String formatHeaders = formatMapToStr(sortedSignHeaders);

        String formatStr = new StringBuilder().append(formatMethod).append(LINE_SEPARATOR)
                .append(formatUri).append(LINE_SEPARATOR).append(formatParameters)
                .append(LINE_SEPARATOR).append(formatHeaders).append(LINE_SEPARATOR).toString();
        String hashFormatStr = DigestUtils.sha1Hex(formatStr);
        String stringToSign = new StringBuilder().append(Q_SIGN_ALGORITHM_VALUE)
                .append(LINE_SEPARATOR).append(qSignTimeStr).append(LINE_SEPARATOR)
                .append(hashFormatStr).append(LINE_SEPARATOR).toString();
        String signature = HmacUtils.hmacSha1Hex(signKey, stringToSign);

        String authoriationStr = new StringBuilder().append(Q_SIGN_ALGORITHM_KEY).append("=")
                .append(Q_SIGN_ALGORITHM_VALUE).append("&").append(Q_AK).append("=")
                .append(tempKey.get("tmpSecretId").toString()).append("&").append(Q_SIGN_TIME).append("=")
                .append(qSignTimeStr).append("&").append(Q_KEY_TIME).append("=").append(qKeyTimeStr)
                .append("&").append(Q_HEADER_LIST).append("=").append(qHeaderListStr).append("&")
                .append(Q_URL_PARAM_LIST).append("=").append(qUrlParamListStr).append("&")
                .append(Q_SIGNATURE).append("=").append(signature).toString();
        return authoriationStr;
    }

    private Map<String, String> buildSignHeaders(Map<String, String> originHeaders) {
        Map<String, String> signHeaders = new HashMap<>();
        for (Map.Entry<String, String> headerEntry : originHeaders.entrySet()) {
            String key = headerEntry.getKey();
            if (key.equalsIgnoreCase("content-type") || key.equalsIgnoreCase("content-md5")
                    || key.startsWith("x") || key.startsWith("X")) {
                String lowerKey = key.toLowerCase();
                String value = headerEntry.getValue();
                signHeaders.put(lowerKey, value);
            }
        }

        return signHeaders;
    }

    private String buildSignMemberStr(Map<String, String> signHeaders) {
        StringBuilder strBuilder = new StringBuilder();
        boolean seenOne = false;
        for (String key : signHeaders.keySet()) {
            if (!seenOne) {
                seenOne = true;
            } else {
                strBuilder.append(";");
            }
            strBuilder.append(key.toLowerCase());
        }
        return strBuilder.toString();
    }

    private String formatMapToStr(Map<String, String> kVMap) {
        StringBuilder strBuilder = new StringBuilder();
        boolean seeOne = false;
        for (Map.Entry<String, String> entry : kVMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            String lowerKey = key.toLowerCase();
            String encodeKey = UrlEncoderUtils.encode(lowerKey);
            String encodedValue = "";
            if (value != null) {
                encodedValue = UrlEncoderUtils.encode(value);
            }
            if (!seeOne) {
                seeOne = true;
            } else {
                strBuilder.append("&");
            }
            strBuilder.append(encodeKey).append("=").append(encodedValue);
        }
        return strBuilder.toString();
    }

    private String buildTimeStr(Date expiredTime) {
        StringBuilder strBuilder = new StringBuilder();
        long startTime = System.currentTimeMillis() / 1000;
        long endTime = expiredTime.getTime() / 1000;
        strBuilder.append(startTime).append(";").append(endTime);
        return strBuilder.toString();
    }

}
