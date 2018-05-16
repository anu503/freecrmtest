package com.crm.qa.util;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{

	public static long page_load_timeout=30;
	public static long implicit_wait=20;
	
	public void switchToFrame()  //this is common method not specific to any page.common methods write in util class
	{
		driver.switchTo().frame("mainpanel");
	}
	
}
