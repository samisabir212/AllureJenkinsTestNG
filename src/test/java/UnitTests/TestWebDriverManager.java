package UnitTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestWebDriverManager {
	
	
	public static void main(String[] args) throws InterruptedException {
		
		
		
	}
	
	
	public static void testMileStoneTrowdata(){
		
		
		
	}
	
	
	public static void launch() throws InterruptedException{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		Thread.sleep(5000);
		//driver.close();
		//driver.quit();
		
	}

}
