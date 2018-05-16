package com.crm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactspage;
	
	HomePageTest()
	{
		super();
	}
	//testcases should be independent with each other.
	//before each test case...launch the browser and log in
	//execute test cases
	//after each test case close the browser....this is best practice.
	
	@BeforeMethod
	public void setup() throws Exception 
	{
		initialization();
		loginpage=new LoginPage();
		testutil=new TestUtil();
		homepage= new HomePage();
		homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest()
	{
		String homepagetitle=homepage.verifyHomePageTitle();
		Assert.assertEquals(homepagetitle,"CRMPRO","home page title is not matched");//this msg will be printed only if test case is failed in report
	}
	@Test(priority=2)
	public void verifyUsernameTest() throws Exception
	{ 
		testutil.switchToFrame();//usename is on the frame so we need to switch to that frame
		Assert.assertTrue(homepage.verifyCorrectUser());
	}
	@Test(priority=3)
	public void clickOnContactsTest()
	{
		testutil.switchToFrame();//this is also on the frame.
		contactspage=homepage.clickOnContacts();
	}
	
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	}
	


