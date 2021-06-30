package com.example.springbootapiintegrat.alipay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.CertAlipayRequest;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;

import java.util.UUID;

/**
 * @Author qrn
 * @Title
 * @Date 2021/6/28 18:20
 * @time 18:20
 * 参考文档: https://opendocs.alipay.com/open/54/106370
 *
 * https://opendocs.alipay.com/open/204/105465
 */
public class Demo {

   public void test() throws AlipayApiException {

//       String outtradeno = UUID.randomUUID().toString().replace("-", "");
//
//       //构造client
//       CertAlipayRequest certAlipayRequest = new CertAlipayRequest ();
//       //设置网关地址
//       certAlipayRequest.setServerUrl("https://openapi.alipay.com/gateway.do");
//       //设置应用Id
//       certAlipayRequest.setAppId(app_id);
//       //设置应用私钥
//       certAlipayRequest.setPrivateKey(privateKey);
//       //设置请求格式，固定值json
//       certAlipayRequest.setFormat("json");
//       //设置字符集
//       certAlipayRequest.setCharset("utf-8");
//       //设置签名类型
//       certAlipayRequest.setSignType("RSA2");
//       //设置应用公钥证书路径
//       certAlipayRequest.setCertPath(app_cert_path);
//       //设置支付宝公钥证书路径
//       certAlipayRequest.setAlipayPublicCertPath(alipay_cert_path);
//       //设置支付宝根证书路径
//       certAlipayRequest.setRootCertPath(alipay_root_cert_path);
//       //构造client
//       AlipayClient alipayClient = new DefaultAlipayClient(certAlipayRequest);
//       //实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
//       AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest ();
//       //SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
//       AlipayTradeAppPayModel model = new AlipayTradeAppPayModel ();
//       model.setBody("我是测试数据" );
//       model.setSubject ("App支付测试Java");
//       model.setOutTradeNo (outtradeno);
//       model.setTimeoutExpress ("30m");
//       model.setTotalAmount ("0.01");
//       model.setProductCode ("QUICK_MSECURITY_PAY");
//       request.setBizModel (model);
//       request.setNotifyUrl ("商户外网可以访问的异步地址");
//       try  {
//           //这里和普通的接口调用不同，使用的是sdkExecute
//           AlipayTradeAppPayResponse response = alipayClient.sdkExecute( request );
//           System.out.println(response.getBody()); //就是orderString 可以直接给客户端请求，无需再做处理。
//       }  catch (AlipayApiException e ) {
//           e.printStackTrace();
//       }
   }

}
