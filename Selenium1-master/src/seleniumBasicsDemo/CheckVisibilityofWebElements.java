package seleniumBasicsDemo;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CheckVisibilityofWebElements {
	
	public static void main(String[] args) throws Exception {
		//System.setProperty("webdriver.gecko.driver", "C:\\driver\\geckodriver-v0.20\\geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", "C:\\drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "https://google.com";
		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
		String expectedTitle="Google";
		String actualTitle=driver.getTitle();
		if(expectedTitle.equals(actualTitle)){
			System.out.println("Verification successful - The corret title is displayed on the web page");
		}
		else{
			System.out.println("Verification Failed - An incorret title is displayed on the web page");
		}
		
		
		boolean GoogleSearchBtnPresent=driver.findElement(By.name("btnK")).isDisplayed();
		if(GoogleSearchBtnPresent==true){
			WebElement Search=driver.findElement(By.id("sb_ifc0"));
			
			Search.sendKeys("Selenium");
			Thread.sleep(3000);
		}
		driver.quit();
	}

}

