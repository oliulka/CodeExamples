package com.oliulka.pomabstract;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class page01 extends AbstractPage
{

	public page01(WebDriver driver) {
		super(driver);
	}
	
	public WebElement searchBar()
	{
		return driver.findElement(By.cssSelector("input[type='text']"));
	}
	
	public List <WebElement> searchBarIfPresent()
	{
		return driver.findElements(By.cssSelector("input[type='text']"));
	}
	
	public WebElement searchbutton() 
	{
		return driver.findElement(By.cssSelector("button[type='submit']"));	
	}

}
