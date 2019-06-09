package com.qa.CapsuleCRMTests;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import DriverMaster.MasterWebDriver;
import PageObjects.AccountSettingsPage;
import PageObjects.CasesPage;
import PageObjects.LandingPage;
import PageObjects.LoginPage;
import PageObjects.NavBar;
import PageObjects.PartyPage;
import PageObjects.PeopleAndOrganizationsPage;
import PageObjects.SiteAddressGoToPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class LoginTests extends MasterWebDriver {

	
	public LoginTests() throws IOException {
		super();
	}

	static LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
	static LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
	static SiteAddressGoToPage siteAddressGoToPage = PageFactory.initElements(driver, SiteAddressGoToPage.class);

	
	
	@Test(priority=1)
	@Severity(SeverityLevel.BLOCKER)
	@Epic("Login")
	@Feature("Login Feature")
	@Story("Story name : As a user i want to login to the application successfully so i can start using capsuleCRM services")
	@Description("Verify a successful login with valid credentials")
	public void successfulLogin() throws Exception{
		
		String url = "https://capsulecrm.com/";

		loadUrl(url);
		landingPage.clickLogin();
		siteAddressGoToPage.enterSiteLoginAddress("samisabir212");
		siteAddressGoToPage.clickGoToLogin();
		loginPage.login("samisabir212", "Friday27{[]}>");
		System.out.println("invoked browser #1 successfußlLogin");
	}
	
	
	@Test(priority=1, description="verifying error message when logging in with invalid username")
	@Severity(SeverityLevel.CRITICAL)
	@Description("verifying error message when logging in with invalid username")
	@Epic("Login")
	@Feature("Login Feature")
	@Story("Story name : User should not be able to login with invalid username using a valid password")
	public void loginWithInvalidUsername() throws Exception{
		
		String url = "https://capsulecrm.com/";

		loadUrl(url);
		loadUrl(url);
		landingPage.clickLogin();
		siteAddressGoToPage.enterSiteLoginAddress("samisabir212");
		siteAddressGoToPage.clickGoToLogin();
		loginPage.login("inValUsername212", "Friday27{[]}>");
		System.out.println("invoked browser #2 loginWithInvalidUsername");

	}
	
	
	@Test(priority=1, description="verifying error message when logging in with invalid password")
	@Severity(SeverityLevel.NORMAL)
	@Description("verifying error message when logging in with invalid password")
	@Story("Story name : User should not be able to login with invalid password using a valid username")
	public void loginWithInvalidPassword() throws Exception{
		
		String url = "https://capsulecrm.com/";

		loadUrl(url);
		loadUrl(url);
		landingPage.clickLogin();
		siteAddressGoToPage.enterSiteLoginAddress("samisabir212");
		siteAddressGoToPage.clickGoToLogin();
		loginPage.login("samisabir212", "QQQQQzni9");
		System.out.println("invoked browser #3 loginWithInvalidPassword");

	}
	
	@Test(priority=1, description="verifying error message when logging in with invalid username and invalid password")
	@Severity(SeverityLevel.TRIVIAL)
	@Description("verifying error message when logging in with invalid username and invalid password")
	@Story("Story name : User should not be logged in after entering invalid username and password")
	public void loginWithInvalidCredentials() throws Exception{
		String url = "https://capsulecrm.com/";

		loadUrl(url);
		loadUrl(url);
		landingPage.clickLogin();
		siteAddressGoToPage.enterSiteLoginAddress("samisabir212");
		siteAddressGoToPage.clickGoToLogin();
		loginPage.login("spopisnk", "diojd9aj");
		System.out.println("invoked browser #4 loginWithInvalidCredentials");

	}
	
}
