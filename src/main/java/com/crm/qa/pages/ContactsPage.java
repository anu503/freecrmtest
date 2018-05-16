package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
			WebElement contactslabel;
	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	public boolean verifyContactsLabel()
	{
		return contactslabel.isDisplayed();
	}
	public void selectSingleContactname()
	{
		driver.findElement(By.xpath("//input[@name='contact_id' and @value='51773576']")).click();
		driver.findElement(By.xpath("//td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id' and @value='51773574']")).click();
	}
	  

}
