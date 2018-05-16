package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	//page factory or object repository
	@FindBy(name="username")
	WebElement username;
	@FindBy(name="password")
	WebElement password;
	@FindBy(xpath=".//*[@id='loginForm']/div/div/input")
	WebElement loginbtn;
	@FindBy(xpath="//button[contains(text(),'Sign Up'])")
	WebElement signupbtn;
   @FindBy(xpath="//img[contains(@class,'img-responsive')]")
   WebElement logo;
   //initialize all the webelemenyts using fage factory
   
   public LoginPage()  //constructor to initialize
   {
	   PageFactory.initElements(driver, this); //pagefactory is a class and initelements() isa method to initialize.this is pointing to current object.in this place u can write
	                                             //LoginPge.class
   }
	
	//actions:methods
   public String validateLoginPageTitle()
   {
	   return driver.getTitle();
   }
	public boolean validateCRMLogo()
	{
		return logo.isDisplayed();
	}
	public HomePage login(String un,String pwd) throws Exception
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		Thread.sleep(5000);
		//WebDriverWait wait2 = new WebDriverWait(driver,30);
		//wait2.until(ExpectedConditions.elementToBeClickable(loginbtn));
		loginbtn.click();
		return new HomePage();
	}
	}
