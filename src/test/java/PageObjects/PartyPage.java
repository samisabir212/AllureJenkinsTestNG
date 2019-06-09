package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PartyPage {
	
	public static @FindBy(xpath = "//span[@class='party-details-title']") WebElement title;


	public String getTitleText(){
		
		 String text = title.getText();
		return text;
	}
	
}
