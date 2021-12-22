package com.toolsqa;

import org.testng.annotations.Test;
import org.testng.reporters.Files;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;

public class Windows

{
 
	WebDriver driver;
	
	
  @BeforeMethod
  public void beforeMethod() 
  {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Raju\\Desktop\\selenium\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
  }

  public void screenshot(String Filename) throws FileNotFoundException, IOException
  {
	  File scrsct = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	  Files.copyFile(new FileInputStream(scrsct),new File("C:\\Users\\Raju\\Desktop\\"+Filename+".jpeg"));
	  
  }
  
  @Test(priority = 1,enabled = false)
  public void launch() throws InterruptedException, Exception, IOException 
  {
	  driver.get("https://www.naukri.com/");
	  
	  Thread.sleep(2000);
	  
	  driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	  
	  
	  screenshot("screenshot");
	  String Title = driver.getTitle();
	  System.out.println(Title);
	  
	  String MainWindow= driver.getWindowHandle();
	  System.out.println(MainWindow);
	
	  Set<String> childwindows = driver.getWindowHandles();
	  System.out.println(childwindows);
	 
	  for(String childwindow : childwindows)
	  {
		  driver.switchTo().window(childwindow);
		  System.out.println(driver.getTitle());
	 }
  }
  @Test(priority = 2,enabled = false)
  public void alert() throws Exception
  {
	  driver.get("https://demoqa.com/alerts");
	/*  
	  driver.findElement(By.xpath("//*[@id=\"alertButton\"]")).click();
	  
	  Alert alert = driver.switchTo().alert();
	  
	  System.out.println(alert.getText());
	  alert.accept();
	  
	  Thread.sleep(3000);
	  */
	  driver.findElement(By.xpath("//*[@id=\"confirmButton\"]")).click();
	  Alert alert1 = driver.switchTo().alert();
	  //alert1.sendKeys("Automation Testing");
	  
	  Thread.sleep(2000);
	  
	  screenshot("screenshot1");
	  
	  alert1.dismiss(); 	   
	   
  }
  
  @Test
  public void action()
  {
	  driver.get("https://demoqa.com/droppable");
	  Actions action = new Actions(driver);
	  
	  //action.clickAndHold(driver.findElement(By.xpath("//*[@id=\"draggable\"]"))).moveToElement(driver.findElement(By.xpath("//*[@id=\"droppable\"]"))).build().perform();
	action.doubleClick();
  }
  
  @AfterMethod
  public void afterMethod() 
  {
	  
  }

}
