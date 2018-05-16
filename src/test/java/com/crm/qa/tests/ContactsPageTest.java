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

public class ContactsPageTest  extends TestBase{
	LoginPage loginpage;
	TestUtil testutil;
	HomePage homepage;
	ContactsPage contactspage;
	 public ContactsPageTest()
	 {
		 super();
		 
	 }
	 @BeforeMethod
	 public void setUP() throws Exception
	 {
		 initialization();
		 loginpage=new LoginPage();
		 testutil=new TestUtil();
		 contactspage=new ContactsPage();
		homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		 testutil.switchToFrame();
		contactspage= homepage.clickOnContacts();
		 
		
	 }
	 @Test(priority=1)
	 public void verifyContactsLabelTest()
	 {
		 Assert.assertTrue(contactspage.verifyContactsLabel(),"contacts label is missing on the page");
	 }
	 @Test(priority=2)
	 public void selectSingleContactTest()
	 {
		 contactspage.selectSingleContactname();
	 }
     @AfterMethod
	 public void tearDown()
	 {
		 driver.quit();
	 }
}
