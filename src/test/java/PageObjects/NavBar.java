package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavBar {


	public static @FindBy(xpath = ".//*[@class='nav-bar-section nav-bar-main is-teams-launch']//span[2]") WebElement peopleAndOrganizationsLink;
	public static @FindBy(xpath = ".//*[@class='nav-bar-section nav-bar-main is-teams-launch']//span[5]") WebElement casesLink;
	public static @FindBy(xpath = "//span[@class='nav-bar-username']") WebElement accountNameTopRightNavBar;
	public static @FindBy(xpath = "//a[contains(text(),'Account Settings')]") WebElement accountSettingsLinkFromDropDownMenu;

	
	
	
	// func : click cases link
	public void clickCasesLink() {

		casesLink.click();
	}

	// func : click peopleAndOrganizations link
	public void clickpeopleAndOrganizationsLink() {

		peopleAndOrganizationsLink.click();
	}
	
	public void clickAccountNameTopRightNavBar(){
		
		accountNameTopRightNavBar.click();
		
	}
	
	public void clickAccountSettingsLink(){
		
		accountSettingsLinkFromDropDownMenu.click();
	}
	

}
