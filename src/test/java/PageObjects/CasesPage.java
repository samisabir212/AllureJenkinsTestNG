package PageObjects;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import DriverMaster.MasterWebDriver;

public class CasesPage extends MasterWebDriver {

	public CasesPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static @FindBy(xpath = ".//a[contains(text(), 'Add Case')]") WebElement addCaseLink;
	public static @FindBy(xpath = "//input[@id='partySearch']") WebElement casesRelatesToTxtField;
	public static @FindBy(xpath = "//input[@id='caseNameDecorate:name']") WebElement nameTxtField;
	public static @FindBy(id = "caseDescriptionDecorate:description") WebElement descriptionTxtField;
	public static @FindBy(id = "save") WebElement saveBtn;
	public static @FindBy(xpath = "//section[@class='col col-border-right']//div[@class='panel']/div[2]/div/div/span/a") WebElement leftPanelForName;

	public static @FindBy(xpath = "//span[@class='kase-summary-status-open']") WebElement caseStatusIcon;

	public String getNameRelatedToCase() {
		String name = leftPanelForName.getText();
		return name;
	}

	public String getStatusIconText() {
		String text = caseStatusIcon.getText();
		return text;
	}

	public void clickAddCaseLink() {

		addCaseLink.click();
	}

	public void enterNewCase(String personOrOrganization, String OptionWithText, String name, String description)
			throws InterruptedException {

		// get character of the string and for each character thread.sleep
		char[] chars = personOrOrganization.toCharArray();

		String[] s = new String[chars.length];
		for (int i = 0; i < chars.length; i++) {
			s[i] = String.valueOf(chars[i]);
		}

		for (String letter : s) {
			Thread.sleep(400);
			casesRelatesToTxtField.sendKeys(letter);
		}

		Thread.sleep(3000);
		casesRelatesToTxtField.sendKeys(Keys.DOWN);
		casesRelatesToTxtField.sendKeys(Keys.ENTER);
		// selectOptionWithText(OptionWithText);
		Thread.sleep(2000);
		System.out.println(nameTxtField.isDisplayed());
		nameTxtField.sendKeys(name);
		descriptionTxtField.sendKeys(description);
		saveBtn.click();

	}
}
