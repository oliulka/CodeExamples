package com.oliulka.ui.pom;

import org.testng.annotations.Test;

public class GoogleTest extends base {
	
	@Test
	public void GoogleTest01() throws InterruptedException
	{
		GooglePage gpage = new GooglePage();
		GoogleFlow gflow = new GoogleFlow(gpage);
		gflow.LoadGoodlePage(driver);		
	}
	
}
