package com.crm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage login;
	HomePage homepage;
	
	public LoginPageTest()
	{
	    super();
	
	}
	@BeforeMethod
	public void setUp()
	{
		initialization();
		 login=new LoginPage();
	}
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		String title=login.validateLoginPageTitle();
		Assert.assertEquals(title,"#1 Free CRM software in the cloud for sales and service");
	}
	@Test(priority=2)
	public void crmLogoTest()
	{
		boolean flag=login.validateCRMLogo();
		Assert.assertTrue(flag);
	}
	@Test(priority=3)
	public void loginTest() throws Exception
	{
		homepage=login.login(prop.getProperty("username"), prop.getProperty("password"));
	}

}
