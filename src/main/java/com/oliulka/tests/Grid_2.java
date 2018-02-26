package com.oliulka.tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.MalformedURLException;

public class Grid_2 {
	WebDriver driver;
	String baseURL, nodeURL;
	
	@BeforeTest
	public void beforeTest() throws MalformedURLException, InterruptedException
	{
		baseURL = "http://www.google.com";
		nodeURL = "http://172.28.18.91:4444/wd/hub";
		DesiredCapabilities capability = DesiredCapabilities.firefox();
		capability.setBrowserName("firefox");
		capability.setPlatform(Platform.VISTA);
		driver = new RemoteWebDriver(new URL(nodeURL), capability);		
	}
	
	@AfterTest
	public void afterTest() {
		driver.quit();
		System.out.println("Test is over");
	}
	
	@Test
	public void Test() throws InterruptedException {
		driver.get(baseURL);
		Thread.sleep(30000);
	}
	

}
