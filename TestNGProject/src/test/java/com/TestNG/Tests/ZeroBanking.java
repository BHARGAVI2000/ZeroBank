package com.TestNG.Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ZeroBanking {
	
	
	WebDriver driver;
	@Parameters("browserName")
	@BeforeTest
	public void initialiseBrowser(@Optional("chrome") String BrowserName) {
		if (BrowserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
			driver= new ChromeDriver();
			driver.manage().window().maximize();
			
		} else if (BrowserName.equalsIgnoreCase("firefox"))
		{System.setProperty("webdriver.gecko.driver", "C:\\drivers\\geckodriver.exe");
		driver= new FirefoxDriver();
		}
		else if (BrowserName.equalsIgnoreCase("IE"))
		{System.setProperty("webdriver.ie.driver", "C:\\drivers\\IEDriverServer.exe");
			 driver=new InternetExplorerDriver();
			

		}
		
		
	
		
		
	}
	@AfterTest
	public void Teardown() {
		driver.quit();
	}
@Parameters("url")
	@Test
	public void setUp(String url) { 
		
		
		driver.get("http://zero.webappsecurity.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
@Parameters({"uname","pswd"})
	@Test
	public void verifyLogin(String uname, String pswd) {
		driver.findElement(By.id("signin_button")).click();
		driver.findElement(By.name("user_login")).sendKeys(uname);
		driver.findElement(By.id("user_password")).sendKeys(pswd);
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.id("details-button")).click();
		driver.findElement(By.id("proceed-link")).click();
		String actualTitle=driver.getTitle();
		String expectedTitle="Zero - Account Summary";
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	


}
	
	
