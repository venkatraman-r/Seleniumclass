package com.toolsqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewTest1 {
	WebDriver driver;

	 
	@BeforeClass
	public void beforeClass() 

	{
		  
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Raju\\Desktop\\selenium\\chromedriver_win32\\chromedriver.exe");
		 driver = new ChromeDriver();
	    
	    driver.manage().window().maximize();

	}
		
	@BeforeMethod
	public void beforeMethod() 
	{
	System.out.println("Before Method");
		
	}
	//Launch the application

	@Test(priority = 1)
	public void launch() 
	  {
		driver.get("https://demoqa.com/text-box");
		Assert.assertEquals(driver.getTitle(), "ToolsQA");
		
	  }
	
	@Test(priority = 2)
	//Provide the Input for account creation
	public void account() 
	  {
		driver.findElement(By.id("userName")).sendKeys("Automation testing");
		driver.findElement(By.id("userEmail")).sendKeys("automationtesting@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"currentAddress\"]")).sendKeys("Chennai");
		driver.findElement(By.id("permanentAddress")).sendKeys("Chennai");
	  }
	
	 @AfterMethod
	  public void afterMethod() 
	 {
	 System.out.println("After Method"); 
	 }

	  @AfterClass
	  public void afterClass() 
	  {
	  }

}
