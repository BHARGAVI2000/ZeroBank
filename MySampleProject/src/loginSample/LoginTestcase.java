package loginSample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import loginPageSample.loginPageObject;

public class LoginTestcase {

	public static void main(String[] args) {
		
	
	
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
				
		driver.get("http://demo.guru99.com/V4");
		
		
		
		
		driver.findElement(By.name("uid")).sendKeys("mngr375526");
		driver.findElement(By.name("password")).sendKeys("yjaquqU");
		driver.findElement(By.name("btnLogin")).click();
		driver.close();
		
		
		
	}
	}




