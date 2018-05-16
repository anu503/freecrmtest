package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath="//td[contains(@class,'headertext')and contains(text(),'User: anu danda')]")
	 WebElement usernamelabel;
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactslink;
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealslink;
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement taskslink;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
		
	}
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUser()
	{
		return usernamelabel.isDisplayed();
		
		
	}
	public ContactsPage clickOnContacts()
	{
		contactslink.click();
		return new ContactsPage();
	}
	public TasksPage clickOnTasks()
	{
		taskslink.click();
		return new TasksPage();
	}
	public DealsPage clickOnDeals()
	{
		dealslink.click();
		return new DealsPage();
	}
	
	
}
