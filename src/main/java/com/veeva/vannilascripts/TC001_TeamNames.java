package com.veeva.vannilascripts;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TC001_TeamNames {
	
	
	@Test
	public void verifyTeamNames() {
		
		
		String[] teams = {"celtics", "nets", "knicks", "sixers","raptors"};
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.nba.com/warriors/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		// if the x appears, close it 
		try {
			driver.findElement(By.xpath("//div[text()='x']")).click();;
		}catch(WebDriverException e) {
			
		}
		
		// Teams Menu
		WebElement eleTeams = driver.findElement(By.xpath("//span[text()='Teams']"));
		
		// Randomise the menu
		int rand = new Random().nextInt(teams.length-1);
		System.out.println(rand);		
		
		// Mouse over on the Teams Menu and click sub menu
		Actions builder = new Actions(driver);
		builder.moveToElement(eleTeams).click(driver.findElement(By.xpath("//li[@data-teamslug='"+teams[rand]+"']"))).perform();
		
		// Get the window handles
		List<String> eachHandles = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(eachHandles.get(1));
		System.out.println(driver.getTitle());
		
		if(driver.getTitle().toLowerCase().contains(teams[rand])) {
			System.out.println("The team name matches");
		} else {
			System.out.println("The team name did not match");
		}
		
		
		driver.close();
	}

}
