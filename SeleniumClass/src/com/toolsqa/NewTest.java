package com.toolsqa;

import org.testng.annotations.Test;
import org.testng.reporters.Files;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class NewTest
{
	WebDriver driver;

	 
	@BeforeClass
	public void beforeClass() 

	{
		  
		System.setProperty("webdriver.edge.driver","C:\\Users\\Raju\\Desktop\\selenium\\edgedriver_win64\\msedgedriver.exe");
	    driver = new EdgeDriver();
	    
	    driver.manage().window().maximize();

	}
		
	public void screenshot(String Filename) throws Exception, IOException
	{
		File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		Files.copyFile(new FileInputStream(scr),new File("C:\\Users\\Raju\\Desktop\\"+Filename+".jpeg"));
	}
	
	@BeforeMethod
	public void beforeMethod() 
	{
	System.out.println("Before Method");
		
	}
	//Launch the application

	@Test(priority = 1)
	public void launch() throws IOException, Exception 
	  {
		driver.get("https://demoqa.com/text-box");
		Assert.assertEquals(driver.getTitle(), "ToolsQA");
		screenshot("Screen 1 Launch");
		
	  }
	
	@Test(priority = 2)
	//Provide the Input for account creation
	public void account() throws IOException, Exception 
	  {
		driver.findElement(By.id("userName")).sendKeys("Automation testing");
		driver.findElement(By.id("userEmail")).sendKeys("automationtesting@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"currentAddress\"]")).sendKeys("Chennai");
		driver.findElement(By.id("permanentAddress")).sendKeys("Chennai");
		
		screenshot("Screen 2 Account creation");
		//File scrsct = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		 // Files.copyFile(new FileInputStream(scrsct),new File("C:\\Users\\Raju\\Desktop\\"+Filename+".jpeg"));
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
