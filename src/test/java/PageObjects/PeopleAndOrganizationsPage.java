package PageObjects;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import DriverMaster.MasterWebDriver;

public class PeopleAndOrganizationsPage extends MasterWebDriver {
	
	
	public PeopleAndOrganizationsPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}


	public static @FindBy(xpath = ".//div[@class='page-header']/div[@class='page-header-right']/a[1]") WebElement addPersonBtn;
	public static @FindBy(xpath = "//select[@name='party:j_id108:j_id116']") WebElement titleDropDownBtn;
	public static @FindBy(id = "party:fnDecorate:fn") WebElement firstNameTxtField;
	public static @FindBy(id = "party:lnDecorate:ln") WebElement lastNameTxtField;
	public static @FindBy(id = "party:roleDecorate:jobTitle") WebElement jobTitleTxtField;
	public static @FindBy(id = "party:orgDecorate:org") WebElement organizationTxtField;
	public static @FindBy(id = "party:tagsDecorate:tagComboBox") WebElement tagsTxtField;
	public static @FindBy(id = "party:j_id325:0:phnDecorate:number") WebElement phoneNumTxtField;
	public static @FindBy(xpath = "//select[@name='party:j_id325:0:phnDecorate:j_id328']") WebElement phoneNumDropDown;
	public static @FindBy(xpath = "//span[contains(text(),'+ Ad‌d an‌other ph‌one nu‌mber')]") WebElement addAnotherPhoneNumber;
	public static @FindBy(id = "party:j_id342:0:emlDecorate:nmbr") WebElement emailAddressTxtField;
	public static @FindBy(xpath = "//span[contains(text(),'+ Ad‌d an‌other em‌ail ad‌dress')]") WebElement addAnotherEmailAddress;
	public static @FindBy(xpath = "//select[@name='party:j_id342:0:emlDecorate:j_id345']") WebElement emailAddressDropDown;
	public static @FindBy(id = "party:j_id370:0:webDecorate:web") WebElement webiteAndSocialNetworkstxtField;
	public static @FindBy(xpath = "//select[@id='party:j_id370:0:webDecorate:service']") WebElement webiteAndSocialNetworksDropDown;
	public static @FindBy(xpath = "//span[contains(text(),'Ad‌d an ad‌dress')]") WebElement addAddressOption;
	public static @FindBy(xpath = "//textarea[@id='party:j_id389:0:strDecorate:str']") WebElement addressTxtField;
	public static @FindBy(xpath = "//select[@name='party:j_id389:0:j_id438']") WebElement addressDropDown;
	public static @FindBy(id = "party:j_id389:0:ctyDecorate:cty") WebElement cityTownTxtField;
	public static @FindBy(id = "party:j_id389:0:rgnDecorate:dist") WebElement stateCountytxtField;
	public static @FindBy(id = "party:j_id389:0:ctyPstCd:pstCd") WebElement zipPostalTxtField;
	public static @FindBy(id = "party:save") WebElement saveBtn;



	
	public void clickAddPerson(){
		
		addPersonBtn.click();
	}
	
	
	public void addNewPersonWithFullInfo(String title, String firstname,String lastname,String jobTitle, String organization,
			String tag,String phonNum,String email,String twitterHandle, String address,String city, String stateCounty, String zipCodePostal){
		
		titleDropDownBtn.click();
		selectDropDownOptionByVisibleText(titleDropDownBtn, title);
		firstNameTxtField.sendKeys(firstname);
		lastNameTxtField.sendKeys(lastname);
		jobTitleTxtField.sendKeys(jobTitle);
		organizationTxtField.sendKeys(organization);
		tagsTxtField.sendKeys(tag);
		phoneNumTxtField.sendKeys(phonNum);
		emailAddressTxtField.sendKeys(email);
		webiteAndSocialNetworkstxtField.sendKeys(twitterHandle);
		addAddressOption.click();
		addressTxtField.sendKeys(address);
		selectDropDownOptionByVisibleText(addressDropDown, "Office");
		cityTownTxtField.sendKeys(city);
		stateCountytxtField.sendKeys(stateCounty);
		zipPostalTxtField.sendKeys(zipCodePostal);
		saveBtn.click();
		
	}
	

	
	
	
	/**
	 * addperson button
	 * title
	 * firstname
	 * lastname
	 * job title
	 * organization
	 * tag
	 * phone num'email
	 * save button
	 */

}
