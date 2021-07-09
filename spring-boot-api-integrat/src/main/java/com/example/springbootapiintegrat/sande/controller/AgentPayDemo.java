/**
 * Copyright : http://www.sandpay.com.cn , 2011-2014
 * Project : sandpay-dsf-demo
 * $Id$
 * $Revision$
 * Last Changed by pxl at 2018-4-25 上午11:13:56
 * $URL$
 * 
 * Change Log
 * Author      Change Date    Comments
 *-------------------------------------------------------------
 * pxl         2018-4-25        Initailized
 */
package com.example.springbootapiintegrat.sande.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.springbootapiintegrat.sande.config.DemoBase;
import com.example.springbootapiintegrat.sande.config.ShanDePayConfig;
import com.example.springbootapiintegrat.sande.util.CertUtil;
import com.example.springbootapiintegrat.sande.util.SDKConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * 产品：杉德代收付产品<br>
 * 交易：代付接口<br>
 * 日期： 2021-01<br>
 * 版本： 1.0.0 
 * 说明：以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己需要，按照技术文档编写。该代码仅供参考。<br>
 */
@RestController
public class AgentPayDemo { 
	
	public static  Logger logger = LoggerFactory.getLogger(AgentPayDemo.class);

	@Autowired
	private ShanDePayConfig shanDePayConfig;

	public static void main(String[] args) throws Exception {
		AgentPayDemo demo = new AgentPayDemo();
		String reqAddr="/agentpay";   //接口报文规范中获取

		ShanDePayConfig shanDePayConfig = new ShanDePayConfig();
		// 获取密钥配置
		String sandCertPath = shanDePayConfig.getSandCertPath();
		String signCertPath = shanDePayConfig.getSignCertPath();
		String signCertPwd = shanDePayConfig.getSignCertPwd();
		//加载证书
		CertUtil.init(sandCertPath,signCertPath,signCertPwd);


		JSONObject request = new JSONObject();
		request.put("version", DemoBase.version);
		request.put("productId", DemoBase.PRODUCTID_AGENTPAY_TOC);
		request.put("tranTime", DemoBase.getCurrentTime());
		request.put("orderCode", DemoBase.getOrderCode());
		request.put("timeOut", DemoBase.getNextDayTime());
		request.put("tranAmt", "000000000001");                                 //金额
		request.put("currencyCode", DemoBase.CURRENCY_CODE);                    //币种
		request.put("accAttr", "0");                                            //账户属性     0-对私   1-对公
		request.put("accType", "4");                                            //账号类型      3-公司账户  4-银行卡
		request.put("accNo", "6228480038125000000");                            //收款人账户号
		request.put("accName", "施祺");                                       	//收款人账户名
		request.put("provNo", "");                                              //收款人开户省份编码
		request.put("cityNo", "");                                              //收款人开会城市编码
		request.put("bankName", "");                                            //收款账户开户行名称
		request.put("bankType", "");                                			//收款人账户联行号
		request.put("remark", "测试");                                          	//摘要
		request.put("payMode", ""); 											//付款模式
		request.put("channelType", "");                                         //渠道类型
		request.put("extendParams", "");										//业务扩展参数
		request.put("reqReserved", "");                                         //请求方保留域
		request.put("extend", "");                                              //扩展域
		request.put("phone", "");												//手机号
		String merId = shanDePayConfig.getMid(); 			//商户ID
		String plMid = shanDePayConfig.getPlMid();		//平台商户ID
		JSONObject resp = DemoBase.requestServer(request, reqAddr, DemoBase.AGENT_PAY, merId, plMid);
		if(resp!=null) {
			logger.info("响应码：["+resp.getString("respCode")+"]");	
			logger.info("响应描述：["+resp.getString("respDesc")+"]");
			logger.info("处理状态：["+resp.getString("resultFlag")+"]");
			
			System.out.println("响应码：["+resp.getString("respCode")+"]");
			System.out.println("响应描述：["+resp.getString("respDesc")+"]");
			System.out.println("处理状态：["+resp.getString("resultFlag")+"]");
		}else {
			logger.error("服务器请求异常！！！");	
			System.out.println("服务器请求异常！！！");
		}	

	}
	
}
