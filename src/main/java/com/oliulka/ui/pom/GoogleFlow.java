package com.oliulka.ui.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleFlow 
{
	public GooglePage page01;
	
	public GoogleFlow(GooglePage page01) {
		this.page01 = page01;
	}

	public void LoadGoodlePage(WebDriver driver) throws InterruptedException
	{
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		Thread.sleep(5000);
		page01.searchtextbox(driver).click();
		page01.searchtextbox(driver).sendKeys("Elon Musk");
		Thread.sleep(1000);
		page01.searchtextbox(driver).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		System.out.println("Test is over!");
		
	}
	
}
