package com.oliulka.ui.pom.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import com.oliulka.ui.pom.pages.Page01GoogleSearchPage;

public class BrowserTest {
	
	private Page01GoogleSearchPage page; 
		
	public BrowserTest(Page01GoogleSearchPage page)
	{
		this.page = page;
	}

	@Test(priority =1)
	public static void FirstTest() throws InterruptedException
	{
		
	// Chrome
	System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
		
	//Firefox
	//System.setProperty("webdriver.gecko.driver", "resources/geckodriver.exe");
	//WebDriver driver = new FirefoxDriver();
		
	//IE
	//System.setProperty("webdriver.ie.driver", "resources/IEDriverServer.exe");
	//WebDriver driver = new InternetExplorerDriver();
		
	driver.manage().window().maximize();
	driver.get("https://www.google.com");

	for(int i=0; i<60; i++)
	{
		int headerCount = (driver.findElements(By.cssSelector("head > title")).size());
		if (headerCount >0)
		{
			break;
		}
		System.out.println(headerCount);
	Thread.sleep(100);
	}
	System.out.println("I am on Google page");
	Thread.sleep(5000);
	driver.quit();

	}
	

}
