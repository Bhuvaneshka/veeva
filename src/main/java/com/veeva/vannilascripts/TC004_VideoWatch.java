package com.veeva.vannilascripts;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TC004_VideoWatch {
	
	
	@Test
	public void verifyTeamNames() throws InterruptedException {
		
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.nba.com/warriors/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		// if the x appears, close it 
		try {
			driver.findElement(By.xpath("//div[text()='x']")).click();;
		}catch(WebDriverException e) {
			
		}
		
		//Handle the popup
		driver.findElement(By.xpath("//button[text()='I Accept']")).click();
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Watch Video']")));
			ele.click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Thread.sleep(1000);
		
		//Click on the video
		driver.findElement(By.xpath("//span[text()='Watch Video']")).click();
		
		
		// Confirm the video is getting played after few seconds
		Thread.sleep(10000);
		int size = driver.findElements(By.xpath("//video")).size();
		if(size == 1) {
			System.out.println("The video is played");
		}
		
		driver.close();
	}

}
