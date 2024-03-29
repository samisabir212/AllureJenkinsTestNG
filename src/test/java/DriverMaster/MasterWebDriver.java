package DriverMaster;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Constants.Constants;
import Util.Lib;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MasterWebDriver extends Constants {
	

	public static WebDriver driver;
	protected JavascriptExecutor jsExecutor;

	public static ExtentHtmlReporter extentReporter;
	public static ExtentReports extent;
	
	public MasterWebDriver() throws IOException {
		jsExecutor = ((JavascriptExecutor) driver);
	}
	
	
	
	@Parameters({"CompanyUsername"})
	@BeforeSuite()
	public void beforeSuite(String companyUsername) throws Exception {

		String currentDate = Lib.getcurrentdateyyyyMMddHHmm();
		extentReporter = new ExtentHtmlReporter("./RegressionResults/ssabir/ExtentReport/" + currentDate + ".html");
		extent = new ExtentReports();

		// attach the reporter which we created in Step 1
		extent.attachReporter(extentReporter);
		
		//create time stamp folder, return time stamp variable 
		String naveensChallengeLogsPath = "./RegressionResults/ssabir/Logs/NaveensChallenge/";
		naveensChallengeLogsPath=naveensChallengeLogsPath + Lib.getcurrentdateyyyyMMddHHmm();
		TIMESTAMPFOLDER = Lib.createTimeStampFolder(naveensChallengeLogsPath);
	}

	@BeforeClass
	public void beforClass() throws IOException {

		System.out.println("do something before the class scope beforClass");
		createParentTestOnlyOnce = 0;

	}

	@Parameters({ "osType", "browserType", "runLocal", "useGrid", "useAWS", "useSauceLabs", "accountStatus" })
	@BeforeMethod()
	public void beforeMethod(@Optional String osType, @Optional String browserType, @Optional String runLocal,
			@Optional String useGrid, @Optional String useAWS, @Optional String useSauceLabs,
			@Optional String accountStatus) throws IOException {

		if (runLocal.equalsIgnoreCase("true")) {

			MasterWebDriver.getLocalDriver(osType, browserType);

		} else if (useGrid.equalsIgnoreCase("true")) {

		} else if (useSauceLabs.equalsIgnoreCase("true")) {

		} else {
			
			System.out.println("do something else");
		
		}

	}

	@AfterMethod()
	public void afterMethod() {
		createParentTestOnlyOnce++;
		driver.close();
	}

	@AfterClass
	public void afterClass() {

		System.out.println("quiting browser");
		driver.quit();

	}

	@AfterSuite
	public void afterSuite() {

		extent.flush();
		System.out.println("Flush out report and do some stuff after the whole suite.");

	}
	
	
	
	
	
	
	
	
	

	public static WebDriver getLocalDriver(String osType, String browserType) throws IOException {

		try {

			if (browserType.equalsIgnoreCase("chrome")) {

				WebDriverManager.chromedriver().setup();
//				System.setProperty("webdriver.chrome.driver",
//						"/Users/sami/Desktop/eclipse-workspaceNeon/CapsuleCRM/src/resources/java/Drivers/chromedriver_74");
				driver= new ChromeDriver();
//
			} else if (browserType.equalsIgnoreCase("firefox")) {

				if (osType.equalsIgnoreCase("mac")) {

					System.setProperty("webdriver.gecko.driver",
							"/Users/sami/Desktop/RocketLauncher/Mac/Drivers/geckodriver_V_19_1");

				} else if (osType.equalsIgnoreCase("win")) {

					System.setProperty("webdriver.gecko.driver", "../Generic/driver/geckodriver.exe");

				}
				driver = new FirefoxDriver();

			}
			
		} catch (Exception e) {

			System.out.println("Unable to load browser: " + e.getMessage());

		}

		return driver;

	}
	
	
	public static MasterWebDriver loadUrl(String url) throws Exception {
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		return new MasterWebDriver();
	}

	
	public static void selectDropDownOptionByVisibleText(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}
	
	public static void selectDropDownOptionByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	
	public static void selectOptionWithText(String textToSelect) {
		try {
		
			WebElement autoOptions = driver.findElement(By.xpath(".//div[@class='searchresult']/ul"));
			WebDriverWait wait = new WebDriverWait(driver, 7);
			boolean isDisplayed = autoOptions.isDisplayed();
			System.out.println(isDisplayed);
			wait.until(ExpectedConditions.visibilityOf(autoOptions));
			List<WebElement> optionsToSelect = autoOptions.findElements(By.tagName("li"));
			for (WebElement option : optionsToSelect) {
				System.out.println(option.getText());
				if (option.getText().equals(textToSelect)) {
					System.out.println("Trying to select: " + textToSelect);
					option.click();
					break;
				}
			}

		} catch (NoSuchElementException e) {
			System.out.println(e.getStackTrace());
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
	
	public static ArrayList<WebElement> getListOfWebElementsByXpath(String locator) {
		ArrayList<WebElement> list = new ArrayList<WebElement>();
		list = (ArrayList<WebElement>) driver.findElements(By.xpath(locator));

		return list;

	}

	
	
	

}
