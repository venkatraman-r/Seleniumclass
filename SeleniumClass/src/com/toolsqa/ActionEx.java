package com.toolsqa;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;

public class ActionEx 
{
	WebDriver driver;
	
  @BeforeMethod
  public void beforeMethod() 
  {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Raju\\Desktop\\selenium\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
	  
	  driver.manage().window().maximize();
  }


  @Test
  public void actions() throws Exception
  {
	  driver.get("https://demoqa.com/resizable");
	  
	  Actions action = new Actions(driver);
	  Thread.sleep(2000);
	  // action.clickAndHold(driver.findElement(By.xpath("//*[@id=\"resizableBoxWithRestriction\"]/span"))).moveByOffset(300, 300).build().perform();
	  action.dragAndDropBy(driver.findElement(By.xpath("//*[@id='resizable']/span")), 400,300).build().perform();
  }
  
  @AfterMethod
  public void afterMethod() {
  }

}
