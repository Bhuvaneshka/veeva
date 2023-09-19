package com.veeva.screens;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.veeva.testng.base.ProjectSpecificMethods;

public class HomePage extends ProjectSpecificMethods {

	public HomePage(RemoteWebDriver driver, ExtentTest node) {
		this.driver = driver;
		this.node = node;

	}

	public HomePage hoverOverTeamsMenu() {
		WebElement teamsMenu = locateElement("xpath", "//span[text()='Teams']");
		Actions builder = new Actions(driver);
		builder.moveToElement(teamsMenu).perform();
		return this;
	}

	public HomePage clickTeamSubMenu(String team) {
		driver.findElement(By.xpath("//li[@data-teamslug='" + team + "']")).click();
		return this;
	}

	public String getCurrentWindowTitle() {
		return driver.getTitle();
	}

	public TeamPage goToTeamPage() {
		// Get the window handles
		List<String> eachHandles = new ArrayList<>(driver.getWindowHandles());
		switchToWindow(eachHandles.get(1));
		return new TeamPage(driver, node);
	}

}
