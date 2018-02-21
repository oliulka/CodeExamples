package com.oliulka.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.oliulka.pages.GooglePage;

public class BrowserTest {
	
	private GooglePage page; 
		
	public BrowserTest(GooglePage page)
	{
		this.page = page;
	}

	
	public static void main(String[] args) throws InterruptedException
	{
		
	// Chrome
	System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
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
