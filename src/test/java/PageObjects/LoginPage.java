package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class LoginPage {
	
	//this page is https://<your user name here>.capsulecrm.com/login
	
	//username
	public static @FindBy(id = "login:usernameDecorate:username") WebElement usernameField;

	//password
	public static @FindBy(id = "login:passwordDecorate:password")  WebElement passwordField;

	//login button
	public static @FindBy(id = "login:login")  WebElement loginBtn;

	
	
	//login func
	/**
	 * enter username
	 * enter pass
	 * click login button
	 */
	
	@Step("Login with username: {0} and password: {1} step...")
	public void login(String username, String password){
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		loginBtn.click();
	}

}
