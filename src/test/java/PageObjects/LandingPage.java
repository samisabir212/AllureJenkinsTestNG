package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class LandingPage {
	
	//this page url is https://capsulecrm.com/
	
	//login button
	public static @FindBy(xpath = ".//a[contains(text(),'Log in')]") WebElement loginBtn;

	
	
	//click login func 
	/**
	 * click login button
	 */
	
	@Step("Clicking Login Button on the CapsuleCRM LandingPage...")
	public void clickLogin(){
		loginBtn.click();
	}
	

}
