package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SiteAddressGoToPage {
	
	//this page is https://app.capsulecrm.com/siteaddress/goto
	
	//site address field
	public static @FindBy(xpath = ".//*[@id='login-subdomain']") WebElement capsuleSiteAddressField;
	public static @FindBy(xpath = ".//*[@id='login-button']") WebElement goToLoginBtn;

	
	//enter site login func
	public void enterSiteLoginAddress(String siteAddress){
		
		capsuleSiteAddressField.sendKeys(siteAddress);
		
	}
	
	//func click go to login	
	public void clickGoToLogin(){
		
		goToLoginBtn.click();
		
	}

}
