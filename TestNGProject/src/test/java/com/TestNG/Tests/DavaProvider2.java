package com.TestNG.Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DavaProvider2 {

	@Test(dataProvider="loginTestData")
	public void verifyLogin(String user, String pswd) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
				
		driver.get("http://zero.webappsecurity.com");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("signin_button")).click();
		driver.findElement(By.name("user_login")).sendKeys(user);
		driver.findElement(By.id("user_password")).sendKeys(pswd);
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.id("details-button")).click();
		driver.findElement(By.id("proceed-link")).click();
		String actualTitle=driver.getTitle();
		String expectedTitle="Zero - Account Summary";
		Assert.assertEquals(actualTitle, expectedTitle);
		Thread.sleep(2000);
		driver.quit();
	}
	
	@DataProvider(name="loginTestData")
	public Object[][] loginData() {
		Object[][] data = new Object[2][2] ;
		
		data[0][0]= "username";
		data[0][1]="password";
		data[1][0]="user1";
		data[1][1]="pass1";
		
		return data;
	}
}
