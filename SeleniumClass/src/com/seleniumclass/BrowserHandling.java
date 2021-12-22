package com.seleniumclass;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class BrowserHandling 
{

	public static void main(String[] args) throws Exception
	{
		
		WebDriver driver = null;
		int browser = 2; 
		
		//Handling browser
		switch(browser)
		{
		
		case 1 : System.setProperty("webdriver.chrome.driver", "C:\\Users\\Raju\\Desktop\\selenium\\chromedriver_win32\\chromedriver.exe");
				 driver = new ChromeDriver();
				 break;
				 
		case 2 :  System.setProperty("webdriver.edge.driver","C:\\Users\\Raju\\Desktop\\selenium\\edgedriver_win64\\msedgedriver.exe");
	             driver = new EdgeDriver();
	             break;
	             
	    default : System.out.println("Enter the value 1 for chrome and 2 for edge");
	    		 break;
	    			
		}
		
		//Getting size of your window
		Dimension dim = driver.manage().window().getSize();
		System.out.println(dim);
		
		
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/text-box");
		
		String Expectedtitle = "ToolsQA";
		
		String ActualTitle = driver.getTitle();
		
		if(ActualTitle.equalsIgnoreCase(Expectedtitle))
		{
			System.out.println("Validation successful for Title........"+ActualTitle);
		}
		else
		 System.out.println("Validation failed. Landed in wrong website......."+ActualTitle);	
		
		
		driver.findElement(By.id("userName")).sendKeys("Automation testing");
		driver.findElement(By.id("userEmail")).sendKeys("automationtesting@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"currentAddress\"]")).sendKeys("Chennai");
		driver.findElement(By.id("permanentAddress")).sendKeys("Chennai");
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//*[@id=\'submit\']")).click();
		
		//Navigation
		driver.navigate().back();
		
		Thread.sleep(3000);
		
		driver.navigate().forward();
		
		Thread.sleep(2000);
		
		driver.navigate().refresh();
		
		//Handling radio button
		/*
		driver.navigate().to("https://demoqa.com/radio-button");
		//driver.close();
		
		WebElement noRadio = driver.findElement(By.xpath("//*[@for=\"noRadio\"]"));
		
		boolean noRadioboolean = noRadio.isEnabled();
		//Handling Radio Button
		/*if(noRadioboolean)
		{
		noRadio.click();
		System.out.println("The element is not enabled");
		}
		else
		{
			System.out.println("The element is not enabled");
		}*/
		
		//Thread.sleep(2000);
		//WebElement yesradio = driver.findElement(By.cssSelector("label[for='yesRadio']"));
		//boolean yesRadio = yesradio.isSelected();
		/*
		if(yesradio.isEnabled() && !yesradio.isSelected())
		{
			yesradio.click();
		}
		
		String radiotext = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[1]/p")).getText();
		System.out.println(radiotext);
		*/
		
		
		driver.navigate().to("https://demoqa.com/select-menu");
		
		WebElement selectref = driver.findElement(By.xpath("//*[@id=\"oldSelectMenu\"]"));
		
		Select select = new Select(selectref);
		
		select.selectByValue("3");
		
		Thread.sleep(2000);
		
		select.selectByIndex(7);
		
		Thread.sleep(2000);
		
		select.selectByVisibleText("Indigo");
		
	}
}
