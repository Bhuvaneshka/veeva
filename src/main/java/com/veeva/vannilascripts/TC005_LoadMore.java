package com.veeva.vannilascripts;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC005_LoadMore {
	
	
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
		
		//Handle the pop-up
		driver.findElement(By.xpath("//button[text()='I Accept']")).click();
		
		//Get the initial number of items
		List<WebElement> elements = driver.findElements(By.xpath("//span[text()='Load more']/ancestor::div[@class='xsm:mx-5']//div[contains(@class,'flex-grow')]"));
		
		int intialCount = elements.size();
		System.out.println(intialCount);
		
		//click on the Load More button
		driver.findElement(By.xpath("//span[text()='Load more']")).click();
		
		//Get the items count after load more
		List<WebElement> elementsNew = driver.findElements(By.xpath("//span[text()='Load more']/ancestor::div[@class='xsm:mx-5']//div[contains(@class,'flex-grow')]"));
		int newCount = elementsNew.size();
		System.out.println(newCount);

		
		if(newCount == intialCount+8) {
			System.out.println("The count increased by 8 as expected");
		}

		driver.close();
	}

}
