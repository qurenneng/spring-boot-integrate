/**
 * Copyright : http://www.sandpay.com.cn , 2011-2014
 * Project : sandpay-qr-demo
 * $Id$
 * $Revision$
 * Last Changed by pxl at 2018-4-25 下午3:50:48
 * $URL$
 * 
 * Change Log
 * Author      Change Date    Comments
 *-------------------------------------------------------------
 * pxl         2018-4-25        Initailized
 */
package com.example.springbootapiintegrat.sande.util;

import java.util.Random;

/**
 *
 * @ClassName ：RandomStringGenerator
 * @author : pxl
 * @Date : 2018-4-25 下午3:50:48
 * @version 2.0.0
 *
 */
public class RandomStringGenerator {

	public static String getRandomStringByLength(int length)
	  {
	    String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	    Random random = new Random();
	    StringBuffer sb = new StringBuffer();
	    for (int i = 0; i < length; i++) {
	      int number = random.nextInt(base.length());
	      sb.append(base.charAt(number));
	    }
	    return sb.toString();
	  }
}
