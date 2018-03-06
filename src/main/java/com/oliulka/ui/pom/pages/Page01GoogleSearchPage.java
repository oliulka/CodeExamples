package com.oliulka.ui.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Page01GoogleSearchPage extends AbstractPage
{
	public Page01GoogleSearchPage(WebDriver driver) 
	{
		super(driver);
	}
	
	public WebElement searchtextbox() 
	{
		return driver.findElement(By.cssSelector("input[type='text']"));	
	}
	
	public WebElement searchbutton() 
	{
		return driver.findElement(By.cssSelector("button[type='submit']"));	
	}
}
