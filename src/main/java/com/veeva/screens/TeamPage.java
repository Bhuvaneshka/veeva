package com.veeva.screens;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.veeva.testng.base.ProjectSpecificMethods;

public class TeamPage extends ProjectSpecificMethods{
	
	public TeamPage(RemoteWebDriver driver, ExtentTest node){
		this.driver = driver;
		this.node = node;		
	}
	
	public TeamPage clickSlideViewButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement slideViewButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'swiper-pagination')]/span[1]")));
        slideViewButton.click();
		return this;
    }
	
	public List<WebElement> getAllSlides() {
        return driver.findElements(By.xpath("//div[contains(@class,'swiper-slide')]"));
    }
	
	public void verifyTeamName(String title)
    {
    	if(verifyTitle(title))
    	{
    		reportStep("The Team Name has been verified", "Pass");
    	}
    }
	    

}
