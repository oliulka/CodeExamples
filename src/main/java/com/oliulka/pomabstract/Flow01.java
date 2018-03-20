package com.oliulka.pomabstract;

import static org.testng.AssertJUnit.assertTrue;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Flow01 extends AbstractUITest {
	
	public void Search(String searchParametr) throws InterruptedException
	{
		WebDriver driver = getDriver();
		page01 GooglePage = new page01(driver);
		driver.get("https://www.google.com");
		Thread.sleep(5000);
		GooglePage.searchBar().sendKeys(searchParametr);
		driver.manage().timeouts().implicitlyWait(50000, TimeUnit.MILLISECONDS);
		GooglePage.searchBar().sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(50000, TimeUnit.MILLISECONDS);
		assertTrue(driver.getTitle().toLowerCase().contains("google"));
		System.out.println(driver.getTitle().toLowerCase());
		System.out.println("Test is completed!");
	}


}
