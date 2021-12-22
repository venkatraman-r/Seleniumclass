package com.seleniumclass;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ToolSqa 

{
	
WebDriver driver;

 
@BeforeClass
public void beforeClass() 

{
	  
	System.setProperty("webdriver.edge.driver","C:\\Users\\Raju\\Desktop\\selenium\\edgedriver_win64\\msedgedriver.exe");
    driver = new EdgeDriver();
    
    driver.manage().window().maximize();

}
	
@BeforeMethod
public void beforeMethod() 
{
System.out.println("Before Method");
	
}
//Launch the application

@Test
public void launch() 
  {
	driver.get("https://demoqa.com/text-box");
	Assert.assertEquals(driver.getTitle(), "ToolsQA");
	
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
