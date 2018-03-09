package com.oliulka.ui.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GooglePage {
	
	public WebElement searchtextbox(WebDriver driver) 
	{
		return driver.findElement(By.cssSelector("input[type='text']"));	
	}
	
	public WebElement searchbutton(WebDriver driver) 
	{
		return driver.findElement(By.cssSelector("button[type='submit']"));	
	}

}
