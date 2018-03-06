package com.oliulka.ui.pom.pages;


import org.openqa.selenium.WebDriver;

public abstract class AbstractPage 
{
	protected WebDriver driver;
	
	public AbstractPage(WebDriver driver){
		this.driver = driver;
	}
	
	public WebDriver getDriver(){
		return driver;
		
	}
	
}