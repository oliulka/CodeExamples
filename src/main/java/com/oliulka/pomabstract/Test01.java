package com.oliulka.pomabstract;

import org.testng.annotations.Test;

public class Test01 extends AbstractUITest 
{
	@Test
	public void GoogleTest01() throws InterruptedException{
		Flow01 GoogleFlow = new Flow01();
		GoogleFlow.Search("Selenium");
		
	}
	

}
