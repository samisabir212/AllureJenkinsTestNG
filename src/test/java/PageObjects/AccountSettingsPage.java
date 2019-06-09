package PageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.model.Test;

import DriverMaster.MasterWebDriver;

public class AccountSettingsPage extends MasterWebDriver {

	public AccountSettingsPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	// Left navPanel elements links
	String leftPanelLinkElementsLocator = ".//ul[@class='nav-panel']/li/a";
	public static @FindBy(xpath = "//ul[@class='settings-nav']/li[8]/a") WebElement tracksLink;

	// page headers
	public static @FindBy(xpath = "//div[@class='left-fixed']/span") WebElement accountSettingsPageHeaderTxt;

	// Appearance
	public static @FindBy(xpath = "//h1[@class='settings-page-header']") WebElement PageHeaderTextFromAccountSettingsPageTxt;
	public static @FindBy(id = "appearance:uploadDecorate:logoImage") WebElement chooseFile_Upload;
	public static @FindBy(xpath = "//a[@class='btn-primary singlesubmit']") WebElement saveBtnAppearnceForAppearanceLogoUpload;

	// Users
	public static @FindBy(xpath = "//a[@class='action btn-primary btn-primary-clear']") WebElement addNewBtn;
	public static @FindBy(id = "register:firstnameDecorate:firstName") WebElement firstnameField;
	public static @FindBy(id = "register:lastNameDecorate:lastName") WebElement lastnameField;
	public static @FindBy(id = "register:emailDecorate:email") WebElement emailField;
	public static @FindBy(id = "register:usernameDecorate:username") WebElement usernameField;
	public static @FindBy(id = "register:save") WebElement inviteUserBtn;
	String accountSettingsUsersTableData = "//table[@id='j_id128:users']/tbody/tr/td";

	// MileStone
	public static @FindBy(xpath = "//button[@class='btn-primary']") WebElement addNewMileStoneBtn;
	public static @FindBy(xpath = "//input[@class='form-input-text milestone-modal-name']") WebElement addNewMileStoneNameField;
	public static @FindBy(xpath = "//textarea[@class='form-input-text milestone-modal-description']") WebElement mileStoneDescriptionField;
	public static @FindBy(xpath = "//input[@class='form-input-text milestone-modal-probability']") WebElement probabilityOfWinningField;
	public static @FindBy(xpath = "//input[@class='form-input-text milestone-modal-days-until-stale']") WebElement daysUntilStaleField;
	public static @FindBy(xpath = ".//div[@class='form-actions']/button[@class='async-button ember-view btn-primary']") WebElement mileStoneSaveBtn;
	String tableRowsOfOpportunityMileStones = ".//table[@class='record-list']/tbody/tr/td";

	// Opportunity tracks
	public static @FindBy(id = "j_id123:trackDescriptionDecorate:trackDescription") WebElement newOpportunityTrackNameField;
	public static @FindBy(id = "j_id123:trackTagDecorate:trackTag") WebElement tagOpportunityTrackField;
	public static @FindBy(id = "j_id123:taskLines:0:taskDescriptionDecorate:taskDescription") WebElement taskDescriptionOpportunityTrackField;
	public static @FindBy(id = "ui-id-1-button") WebElement categoryOpportunityTrackDropDownMenu;
	public static @FindBy(id = "j_id123:taskLines:0:taskDaysAfterDecorate:taskDaysAfter") WebElement dueOpportunityTrackField;
	public static @FindBy(xpath = "//select[@id='j_id123:taskLines:0:taskDaysAfterDecorate:trackDayDelayRule']") WebElement afterTrackStartsOpportunityTrackDropDown;
	public static @FindBy(xpath = "//select[@name='j_id123:taskLines:0:taskAssignmentDecorate:j_id218']") WebElement assigneeOpportunityTrackDropDown;
	public static @FindBy(xpath = "") WebElement addTaskOpportunityTrackBtn;
	public static @FindBy(xpath = "//a[@class='btn-primary btn-clear singlesubmit']") WebElement saveOpportunityTrackBtn;
	String tableRowsOfDataOpportunitiesTracks = ".//tbody//tr//td";

	// task categories
	public static @FindBy(id = "j_id124:j_id126") WebElement addNewCategoryBtn;
	public static @FindBy(xpath = "//div[@id='editCategoryModal']/div/span/div/div/span/input[1]") WebElement categoryNameField;
	public static @FindBy(id = "editCategoryForm:j_id175") WebElement saveCategoryBtn;

	// tags
	public static @FindBy(id = "j_id125:j_id127") WebElement addNewTagBtn;
	public static @FindBy(xpath = "//div[@id='editTagModal']/div/span/div/div/span/input") WebElement addTagNameTextField;
	public static @FindBy(id = "j_id177:j_id210") WebElement saveNewTagBtn;

	
	public void verifyTotalNumberOfConfigureButtons(int expectedTotalnumberOfConfigureButtons, ExtentTest testcase){
		
		List<WebElement> listOfRows = driver.findElements(By.xpath(".//tbody/tr"));
		int counter = 0;
		for(int i = 1; i<=listOfRows.size();i++){
			System.out.println(i);
			WebElement configureBtn = driver.findElement(By.xpath(".//tbody/tr["+i+"]/td[3]/a"));
			System.out.println(configureBtn.getText());
			System.out.println(configureBtn.getText().equalsIgnoreCase("Configure"));
			if(configureBtn.getText().equalsIgnoreCase("Configure")){
				
				Status = "Passed";
				counter++;
				
				
			}else{
				System.out.println("couldnt find the matching text for the configure button");
				testcase.info("couldnt find the matching text for the configure button, but we found :"+ configureBtn.getText());
			}
			
		}
		
		if(counter==10){
			System.out.println("we found a total of 10 configure buttons we are successful");
			testcase.info("we found a total of 10 configure buttons we are successful");
			testcase.pass("Click on Integrations and verify total number of Configure buttons : "+Status);

		}else{
			testcase.fail("Click on Integrations and verify total number of Configure buttons : "+Status);

		}
	}
	
	
	public void addNewTagAndVerifyTheTagCreated(String tagname, ExtentTest testcase) throws InterruptedException {

		addNewTagBtn.click();
		try {
			WebElement addtagBox = driver.findElement(By.xpath("//div[@id='editTagModal']"));
			System.out.println("Can we interact with this element ? answer : " + addtagBox.isDisplayed());
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement tagTextFieldWait = wait.until(ExpectedConditions.visibilityOf(addTagNameTextField));
			tagTextFieldWait.sendKeys(tagname);

		} catch (StaleElementReferenceException e) {

		}
		saveNewTagBtn.click();

		List<WebElement> list = driver.findElements(By.xpath(".//tbody/tr"));
		System.out.println("right before the loop");

		for (int i = 1; i < list.size(); i++) {

			System.out.println(i);

			WebElement actualTagname = driver.findElement(By.xpath(".//tbody/tr[" + i + "]/td[1]"));
			System.out.println("hellooo");
			try{
				System.out.println("I found " + actualTagname.getText());

			}catch(StaleElementReferenceException e){
				
			}
			System.out.println("Im trying to compare it to the expected value : " + tagname);

			try {
				
				if (actualTagname.getText().equalsIgnoreCase(tagname)) {
					System.out.println("Condition is true");
					
					if (actualTagname.getText().equalsIgnoreCase(tagname)) {

						Status = "Passed";
						testcase.info("Add new Tag and verify the same created : " + actualTagname.getText() + " : "
								+ Status);
						testcase.pass("Add new Tag and verify the same : :" + Status);
						System.out.println("Found a match, breaking out of loop now thanks...");
					} else {
						Status = "Failed";

						try {

							Assert.assertEquals(actualTagname.getText(), tagname);

						} catch (java.lang.AssertionError e) {
							testcase.info("actual tagname and expected category assertion Failed :" + e.getMessage());
							testcase.fail("Add new Tag and verify the same : " + Status);
						}

					}
					break;
				}else{
					System.out.println("couldnt find a match.. we are at index : "+ i+" and element grabbed is :"
							+ actualTagname.getText()+" which is the tag name we are not looking for");
				}
			} catch (StaleElementReferenceException e) {

			}

		}

	}

	public void addNewCategoryAndVerifyTheSameCategoryCreated(String categoryName, ExtentTest testcase)
			throws InterruptedException {

		addNewCategoryBtn.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			WebElement categoryFieldNameWait = wait.until(ExpectedConditions.elementToBeClickable(categoryNameField));
			categoryFieldNameWait.sendKeys(categoryName);
		} catch (StaleElementReferenceException e) {

		}

		saveCategoryBtn.click();
		Thread.sleep(5000);
		ArrayList<WebElement> list = (ArrayList<WebElement>) driver.findElements(By.xpath(".//tbody/tr"));

		for (int i = 1; i < list.size(); i++) {

			WebElement actualCategoryName = driver.findElement(By.xpath(".//tbody/tr[" + i + "]/td[2]"));

			if (actualCategoryName.getText().equals(categoryName)) {

				if (actualCategoryName.getText().equals(categoryName)) {

					Status = "Passed";
					testcase.info("Add new category and verify the same category created : "
							+ actualCategoryName.getText() + " : " + Status);
					testcase.pass("Add new category and verify the same :" + Status);
					System.out.println("Found a match, breaking out of loop now thanks...");
					break;
				} else {
					Status = "Failed";

					try {

						Assert.assertEquals(actualCategoryName.getText(), categoryName);

					} catch (java.lang.AssertionError e) {
						testcase.info("actual category and expected category assertion Failed :" + e.getMessage());
						testcase.fail("Add new category and verify the same : " + Status);
					}

				}

			} else {

				System.out.println("Couldnt find a match... keep searching for actual category we created");
			}

		}
	}


	public void addnewOpportunitiesTracksAndVerifyDataCreated(String name, String tag, String taskDescription,
			String category, String dueDate, String afterTrackStartOption, String assignee, ExtentTest testcase)
			throws InterruptedException {

		addNewBtn.click();
		newOpportunityTrackNameField.sendKeys(name);
		tagOpportunityTrackField.sendKeys(tag);
		taskDescriptionOpportunityTrackField.sendKeys(taskDescription);
		categoryOpportunityTrackDropDownMenu.click();

		ArrayList<WebElement> categoryArrayList = (ArrayList<WebElement>) driver
				.findElements(By.xpath("//div[@class='ui-selectmenu-menu ui-front ui-selectmenu-open']/ul/li"));

		for (int i = 0; i < categoryArrayList.size(); i++) {
			WebElement categoryElement = categoryArrayList.get(i);
			if (categoryElement.getText().equals(category)) {
				categoryElement.click();
				break;
			}
		}
		System.out.println("found elment and broke out loop");

		Thread.sleep(3000);
		dueOpportunityTrackField.sendKeys(dueDate);
		selectDropDownOptionByVisibleText(afterTrackStartsOpportunityTrackDropDown, afterTrackStartOption);
		selectDropDownOptionByVisibleText(assigneeOpportunityTrackDropDown, assignee);
		Thread.sleep(6000);
		saveOpportunityTrackBtn.click();

		String[] arrayOfNewOpportunityInfo = { name, tag, taskDescription, category, dueDate, afterTrackStartOption,
				assignee };

		ArrayList<WebElement> rows = (ArrayList<WebElement>) driver.findElements(By.xpath(".//tbody/tr"));

		for (int i = 1; i < rows.size(); i++) {

			WebElement actualName = driver.findElement(By.xpath(".//tbody/tr[" + i + "]" + "/td[1]/a"));

			if (actualName.getText().equals(name)) {
				System.out.println("Found a match : " + actualName.getText());
				// NAME TAG DUE DATES CALCULATED BASED ON
				WebElement actualTag = driver.findElement(By.xpath(".//tbody/tr[" + i + "]" + "/td[2]"));
				WebElement actualDueDateBasedOnText = driver.findElement(By.xpath(".//tbody/tr[" + i + "]" + "/td[3]"));
				String expectedDueDateBasedOnText = "The start date of the track";
				if (actualTag.getText().equals(tag)
						&& actualDueDateBasedOnText.getText().equals(expectedDueDateBasedOnText)) {

					Status = "Passed";
					testcase.pass("Add new track and verify the same : " + Status);
					break;
				} else {

					Status = "Failed";
					testcase.fail("Add new track and verify the same : " + Status);
					try {
						Assert.assertEquals(actualName.getText(), name);
						Assert.assertEquals(actualTag.getText(), tag);
						Assert.assertEquals(actualDueDateBasedOnText.getText(), expectedDueDateBasedOnText);

					} catch (java.lang.AssertionError e) {

						System.out.println("assersion failed : " + e.getMessage());
						testcase.info("Add new track and verify the same Assertion : " + e.getMessage());

					}
					break;
				}

			}

		}

	}

	public void clickAddNewMileStoneButton() {
		addNewMileStoneBtn.click();
	}

	public void addNewUserAndVerifyNewUserCreated(String firstname, String lastname, String email, String username,
			ExtentTest testcase) {

		firstnameField.sendKeys(firstname);
		lastnameField.sendKeys(lastname);
		emailField.sendKeys(email);
		usernameField.sendKeys(username);
		inviteUserBtn.click();

		String[] expectedInfoToVerify = { firstname + " " + lastname, email, username };

		System.out.println(firstname + " " + lastname);
		ArrayList<WebElement> list = getListOfWebElementsByXpath(accountSettingsUsersTableData);

		for (int i = 0; i < list.size(); i++) {

			WebElement element = list.get(i);

			for (int j = 0; j < expectedInfoToVerify.length; j++) {

				System.out.println(element.getText() + " vs " + expectedInfoToVerify[j].toString());
				if (element.getText().equalsIgnoreCase(expectedInfoToVerify[j].toString())) {

					if (element.getText().equalsIgnoreCase(expectedInfoToVerify[j].toString())) {
						Status = "Passed";
						testcase.pass("Verify creation of " + element.getText() + " : " + Status);
						System.out.println("Verify creation of " + element.getText() + " : " + Status);
					} else {
						Status = "Failed";
						testcase.fail("Verify creation of " + element.getText() + " : " + Status);
						System.out.println("Verify creation of " + element.getText() + " : " + Status);
					}

				} else {

					System.out.println("nope couldnt find match keep searching...");

				}

			}

		}
	}

	public void clickAddNewUser() {

		addNewBtn.click();
	}

	public void clickAccountSettingsLinkByTextName(String linkText) {
		ArrayList<WebElement> list = getListOfWebElementsByXpath(leftPanelLinkElementsLocator);

		for (int i = 0; i < list.size(); i++) {

			WebElement element = list.get(i);

			try {

				if (element.getText().equalsIgnoreCase(linkText)) {

					element.click();
					System.out.println("clicked on : " + element.getText());
				}

			} catch (StaleElementReferenceException e) {
				System.out.println(e.getMessage());
			}

		}
	}
	
	public void clickTracksLink(){
		
		tracksLink.click();
	}

	public void uploadFiled(String path) throws AWTException, InterruptedException {

		chooseFile_Upload.click();
		File file = new File(path);

		StringSelection stringSelection = new StringSelection(file.getAbsolutePath());
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_META);

		robot.keyPress(KeyEvent.VK_TAB);

		robot.keyRelease(KeyEvent.VK_META);

		robot.keyRelease(KeyEvent.VK_TAB);

		robot.delay(500);

		robot.keyPress(KeyEvent.VK_META);

		robot.keyPress(KeyEvent.VK_SHIFT);

		robot.keyPress(KeyEvent.VK_G);

		robot.keyRelease(KeyEvent.VK_META);

		robot.keyRelease(KeyEvent.VK_SHIFT);

		robot.keyRelease(KeyEvent.VK_G);

		robot.keyPress(KeyEvent.VK_META);

		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_META);

		robot.keyRelease(KeyEvent.VK_V);

		robot.keyPress(KeyEvent.VK_ENTER);

		robot.keyRelease(KeyEvent.VK_ENTER);

		robot.delay(500);

		robot.keyPress(KeyEvent.VK_ENTER);

		robot.keyRelease(KeyEvent.VK_ENTER);

		saveBtnAppearnceForAppearanceLogoUpload.click();
		Thread.sleep(5000);

	}

	public String getaccountSettingsPageHeaderText() {
		return accountSettingsPageHeaderTxt.getText();
	}

	public String getPageHeaderTextFromAccountSettingsPage() {
		return PageHeaderTextFromAccountSettingsPageTxt.getText();
	}

	public void clickAndVerifyEachLinkLeftPanel(ExtentTest testcase) throws InterruptedException {

		ArrayList<WebElement> list = getListOfWebElementsByXpath(leftPanelLinkElementsLocator);

		for (int i = 0; i < list.size(); i++) {
			WebElement element = list.get(i);
			System.out.println("clickAndVerifyEachLinkLeftPanel element text second try:" + element.getText());

		}
		int counter = 0;

		for (int i = 0; i < list.size(); i++) {

			WebElement element = list.get(i);

			try {

				System.out.println("clickAndVerifyEachLinkLeftPanel element text:" + element.getText());

			} catch (StaleElementReferenceException e) {
				System.out.println("Stale element exception " + e.getMessage());
				System.out.println("additional info " + e.getAdditionalInformation());
				System.out.println("supported URL" + e.getSupportUrl());
			}

			try {

				if (element.getText().equalsIgnoreCase("Account")) {
					System.out.println("inside if block");
					element.click();
					actualCurrentURL = driver.getCurrentUrl();
					actualPageHeader = getPageHeaderTextFromAccountSettingsPage();

					expectedPageHeader = "Account";
					expectedURLPATH = "/settings/account";

				} else if (element.getText().equalsIgnoreCase("Invoices")) {
					element.click();
					actualCurrentURL = driver.getCurrentUrl();
					actualPageHeader = getPageHeaderTextFromAccountSettingsPage();

					expectedPageHeader = "Invoices";
					expectedURLPATH = "/settings/account/invoices";

				} else if (element.getText().equalsIgnoreCase("Export")) {
					element.click();
					actualCurrentURL = driver.getCurrentUrl();
					actualPageHeader = getPageHeaderTextFromAccountSettingsPage();

					expectedPageHeader = "Account";
					expectedURLPATH = "/settings/account/export";

				} else if (element.getText().equalsIgnoreCase("Appearance")) {
					element.click();
					actualCurrentURL = driver.getCurrentUrl();
					actualPageHeader = getPageHeaderTextFromAccountSettingsPage();

					expectedPageHeader = "Appearance";
					expectedURLPATH = "/settings/account/appearance";

				} else if (element.getText().equalsIgnoreCase("Mail Drop Box")) {
					element.click();
					actualCurrentURL = driver.getCurrentUrl();
					actualPageHeader = getPageHeaderTextFromAccountSettingsPage();

					expectedPageHeader = "Mail Drop Box";
					expectedURLPATH = "/settings/dropbox";

				} else if (element.getText().equalsIgnoreCase("Users")) {
					element.click();
					actualCurrentURL = driver.getCurrentUrl();
					actualPageHeader = getPageHeaderTextFromAccountSettingsPage();

					expectedPageHeader = "Users";
					expectedURLPATH = "/settings/users";

				} else if (element.getText().equalsIgnoreCase("Opportunities")) {
					element.click();
					actualCurrentURL = driver.getCurrentUrl();
					actualPageHeader = getPageHeaderTextFromAccountSettingsPage();

					expectedPageHeader = "Opportunities";
					expectedURLPATH = "/settings/opportunities/milestones";

				} else if (element.getText().equalsIgnoreCase("Tracks")) {
					element.click();
					actualCurrentURL = driver.getCurrentUrl();
					actualPageHeader = getPageHeaderTextFromAccountSettingsPage();

					expectedPageHeader = "Account";
					expectedURLPATH = "/settings/tracks/opportunities";

				} else if (element.getText().equalsIgnoreCase("Task Categories")) {
					element.click();
					actualCurrentURL = driver.getCurrentUrl();
					actualPageHeader = getPageHeaderTextFromAccountSettingsPage();

					expectedPageHeader = "Task Categories";
					expectedURLPATH = "/settings/categories";

				} else if (element.getText().equalsIgnoreCase("Custom Fields")) {
					element.click();
					actualCurrentURL = driver.getCurrentUrl();
					actualPageHeader = getPageHeaderTextFromAccountSettingsPage();

					expectedPageHeader = "Custom Fields";
					expectedURLPATH = "/settings/customfields/party";

				} else if (element.getText().equalsIgnoreCase("Tags")) {
					element.click();
					actualCurrentURL = driver.getCurrentUrl();
					actualPageHeader = getPageHeaderTextFromAccountSettingsPage();

					expectedPageHeader = "Tags";
					expectedURLPATH = "/settings/tags/party";

				} else if (element.getText().equalsIgnoreCase("Integrations")) {
					element.click();
					actualCurrentURL = driver.getCurrentUrl();
					actualPageHeader = getPageHeaderTextFromAccountSettingsPage();

					expectedPageHeader = "Integrations";
					expectedURLPATH = "/settings/integrations";

				} else if (element.getText().equalsIgnoreCase("Trash")) {
					element.click();
					actualCurrentURL = driver.getCurrentUrl();
					actualPageHeader = getPageHeaderTextFromAccountSettingsPage();

					expectedPageHeader = "Trash";
					expectedURLPATH = "/settings/trash";

				}

				Thread.sleep(4000);

			} catch (StaleElementReferenceException e) {
			}

			System.out.println(actualCurrentURL + "vs" + expectedURLPATH);
			System.out.println(actualPageHeader + "vs" + expectedPageHeader);

			if (actualCurrentURL.contains(expectedURLPATH) && actualPageHeader.equalsIgnoreCase(expectedPageHeader)) {
				counter++;
				Status = "Passed";

				try {

					testcase.pass("clickAndVerifyEachLinkLeftPanel  : " + element.getText() + Status);
					System.out.println("Assertion verfication for :" + element.getText() + " : " + Status);

				} catch (StaleElementReferenceException e) {
				}

			} else {

				try {
					Assert.assertTrue(actualCurrentURL.contains(expectedURLPATH),
							"expected " + expectedURLPATH + ", but found " + actualCurrentURL);
					Assert.assertEquals(actualPageHeader, expectedPageHeader);
				} catch (java.lang.AssertionError e) {

					try {
						testcase.info("Assertion verfication failed :" + element.getText() + e.getMessage());

					} catch (StaleElementReferenceException z) {
					}

				}

			}

		}

		System.out.println("counter is at " + counter);
		if (counter <= 13) {
			Status = "Passed";
			testcase.pass("click and verify total elements of 13:" + Status);
			System.out.println("clicked and verified all Links : " + Status);
		} else {
			Status = "Failed";
			testcase.pass("click and verify total elements of 13 :" + Status);
			System.out.println("clicked and verified all Links : " + Status);

		}

		Thread.sleep(5000);
	}

	public void addNewMileStoneAndVerifyMileStoneInfoCreated(String mileStone, String description,
			String probabilityOfWinning, String daysUntilStale, ExtentTest testcase) throws InterruptedException {

		addNewMileStoneNameField.sendKeys(mileStone);

		mileStoneDescriptionField.sendKeys(description);

		probabilityOfWinningField.sendKeys(probabilityOfWinning);

		daysUntilStaleField.sendKeys(daysUntilStale);

		mileStoneSaveBtn.click();
		Thread.sleep(2000);
		System.out.println("right before getting the table rows");
		List<WebElement> tableRows = driver.findElements(By.xpath(".//tbody//tr"));
		System.out.println("hellloo");

		for (int i = 1; i < tableRows.size(); i++) {

			System.out.println("total rows" + i);
			WebElement actualNameAndDescription = driver.findElement(By.xpath(".//tbody//tr[" + i + "]/td[1]"));
			System.out.println("actualNameAndDescription Name = " + actualNameAndDescription.getText());

			System.out.println("TRUE OR FALSE : " + actualNameAndDescription.getText().contains(mileStone));
			System.out.println("TRUE OR FALSE : " + actualNameAndDescription.getText().contains(description));

			if (actualNameAndDescription.getText().contains(mileStone)
					&& actualNameAndDescription.getText().contains(description)) {

				WebElement actualProbabilityOfWinning = driver.findElement(By.xpath(".//tbody//tr[" + i + "]/td[2]"));
				WebElement actualDaysUntilStale = driver.findElement(By.xpath(".//tbody//tr[" + i + "]/td[3]"));

				if (actualNameAndDescription.getText().contains(mileStone)
						&& actualNameAndDescription.getText().contains(description)
						&& actualProbabilityOfWinning.getText().equals(probabilityOfWinning + "%")
						&& actualDaysUntilStale.getText().equals(daysUntilStale)) {

					Status = "Passed";
					testcase.info("validate mileStone  " + mileStone + ": " + Status);
					testcase.info("validate description " + description + " : " + Status);
					testcase.info("validate probabilityOfWinning " + probabilityOfWinning + "%" + " : " + Status);
					testcase.info("validate daysUntilStale : " + daysUntilStale + " : " + Status);
					testcase.pass("Add new milestone and verify the same : " + Status);
					System.out.println("Add new milestone and verify the same : " + Status);
					break;
				} else {
					Status = "Failed";
					testcase.fail("Add new milestone and verify the same : " + Status);

					try {

						Assert.assertTrue(actualNameAndDescription.getText().contains(mileStone),
								"mile Stone not found");
						Assert.assertTrue(actualNameAndDescription.getText().contains(description),
								"description not found");

						Assert.assertEquals(actualProbabilityOfWinning.getText(), probabilityOfWinning + "%");
						Assert.assertEquals(actualDaysUntilStale.getText(), daysUntilStale);

					} catch (java.lang.AssertionError e) {

						testcase.fail("Add new milestone and verify the same ASSERTION FAILURE : " + e.getMessage());
						System.out.println("Add new milestone and verify the same : " + Status + " : assertion error : "
								+ e.getMessage());

					}
				}

			}

		}

	}

}
