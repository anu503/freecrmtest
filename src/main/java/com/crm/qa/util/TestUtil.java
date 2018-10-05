package com.crm.qa.util;

import org.apache.commons.codec.binary.Base64;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{

	public static long page_load_timeout=30;
	public static long implicit_wait=20;
	
	public void switchToFrame()  //this is common method not specific to any page.common methods write in util class
	{
		driver.switchTo().frame("mainpanel");
	}
    public static String decodePwd(String pwd)
    {
    	 byte[] decoded_pwd=Base64.decodeBase64(pwd.getBytes());
    	 return new String(decoded_pwd);
    }
}
