package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.crm.qa.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public TestBase() 
	{
	  try
	  { 
		prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\Danda\\selenium\\Freecrmtest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
		prop.load(fis); 
		
      }catch(FileNotFoundException e)
	  {
	    e.printStackTrace();	
	   }catch(IOException e)
	  {
		   e.printStackTrace(); 
	  }
	}
	public static void initialization()
	{
		 String browsername=prop.getProperty("browser");
		 
		 if(browsername.equalsIgnoreCase("chrome"))
		 {
			 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Danda\\Desktop\\chromedriver.exe");
			 driver=new ChromeDriver();
		 }
		 if(browsername.equalsIgnoreCase("FF"))
		 {
			 System.setProperty("webdriver.gecko.driver", "C:\\Users\\Danda\\Desktop\\geckodriver.exe");
			 driver=new FirefoxDriver();
		 }
		 if(browsername.equalsIgnoreCase("Internetexplorer"))
		 {
			 System.setProperty("webdriver.ie.driver", "C:\\Users\\Danda\\Desktop\\IEDriverServer.exe");
			 driver=new InternetExplorerDriver();
		 }
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().pageLoadTimeout(TestUtil.page_load_timeout, TimeUnit.SECONDS);//if u want change the time in some applications we will create
		                                                                  //one class under util package. 
		 driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait, TimeUnit.SECONDS);
		String url= prop.getProperty("url");
		driver.get(url);
		
		
	}
	
	
	
	
	
	
}
