package com.oliulka.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GooglePage extends AbstractPage{
	
	public GooglePage(WebDriver driver) 
	{
		super(driver);
	}
	
	public List<WebElement> Header()
	{
		return driver.findElements(By.cssSelector("head > title"));
	}

}
