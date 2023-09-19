package com.veeva.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.veeva.screens.HomePage;
import com.veeva.testng.base.ProjectSpecificMethods;

public class TC001_TeamNames extends ProjectSpecificMethods {

	@BeforeTest
	public void setValues() {
		testCaseName = "Login and verify Home Page";
		testDescription = "Open the application and verify the team name";
		nodes = "Leads";
		authors = "Bhuvanesh";
		category = "Test";
	}

	@Test
	public void verifyTeamNames() {

		String[] teams = { "Boston", };
		int rand = (int) (Math.random() * teams.length);
		String selectedTeam = teams[rand];

		new HomePage(driver, node).hoverOverTeamsMenu().clickTeamSubMenu(selectedTeam).goToTeamPage()
				.verifyTeamName(selectedTeam);
	}

}
