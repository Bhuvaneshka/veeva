package com.veeva.vannilascripts;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TC003_VerifySlideView {
	
	
	@Test
	public void verifyTeamNames() throws InterruptedException {
		//Get the Chrome driver initialized and open the application
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.nba.com/warriors/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		// if the x appears, close it 
		try {
			driver.findElement(By.xpath("//div[text()='x']")).click();;
		}catch(WebDriverException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'swiper-pagination')]/span[1]")));
			ele.click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Thread.sleep(1000);
		
		//Click the next image navigation icon
		driver.findElement(By.xpath("//div[contains(@class,'swiper-pagination')]/span[1]")).click();
		
		
		// Get all the slide view options
		List<WebElement> slides = driver.findElements(By.xpath("//div[contains(@class,'swiper-slide')]"));
		
		//Check the slide change every 5 seconds
		for(int i=0; i<slides.size();i++) {
			slides = driver.findElements(By.xpath("//div[contains(@class,'swiper-slide')]"));
			System.out.println(slides.get(i).getAttribute("class"));
			Thread.sleep(5000);
		}
		
		driver.close();
	}

}
