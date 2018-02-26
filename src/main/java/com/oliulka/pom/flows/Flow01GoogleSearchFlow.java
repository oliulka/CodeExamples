package com.oliulka.pom.flows;

import com.oliulka.pom.pages.Page01GoogleSearchPage;
import com.oliulka.pom.utilities.Constants;
import com.oliulka.pom.utilities.ExcelUtils;

public class Flow01GoogleSearchFlow 
{
	private Page01GoogleSearchPage page;
	public Flow01GoogleSearchFlow(Page01GoogleSearchPage page){
		this.page = page;			
	}
	
	public void searchflow() {

		
		try {
			// Get Data from Excel Sheet
			ExcelUtils.setExcelFile(Constants.Path_TestData + Constants.File_TestData,"Sheet1");
			String SearchValue = ExcelUtils.getCellData(1, 2);
			// Perform Action
			page.searchtextbox().sendKeys(SearchValue);
			page.searchbutton().click();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
