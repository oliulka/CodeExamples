package com.oliulka.ui.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class base {

	public WebDriver driver;

	@BeforeTest
	public void setDriver() 
	{
		System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
		
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}