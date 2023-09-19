package com.veeva.testng.base;

import java.io.IOException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import com.veeva.selenium.base.SeleniumBase;
import utils.DataLibrary;


public class ProjectSpecificMethods extends SeleniumBase {

	public String dataSheetName;		

	@DataProvider(name = "fetchData")
	public Object[][] fetchData() throws IOException {
		return DataLibrary.readExcelData(dataSheetName);
	}	

	@BeforeMethod
	public void beforeMethod() {
		driver = startApp("chrome", "https://www.nba.com/warriors");
		node = test.createNode(testCaseName);
	}

	@AfterMethod
	public void afterMethod() {
		close();
	}
}
