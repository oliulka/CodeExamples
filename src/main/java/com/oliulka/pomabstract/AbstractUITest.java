package com.oliulka.pomabstract;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class AbstractUITest {
	
	public WebDriver driver;
	private static Map<String, WebDriver> driverMap = new ConcurrentHashMap<String, WebDriver>();
	
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driverMap.put("mydriver", driver);
	}
	
	@AfterMethod
	public void tearDown(){ 
		driverMap.get("mydriver").quit();
	}
	
	public WebDriver getDriver(){
		return driverMap.get("mydriver");
	}

}
