package com.TestNG.Tests;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTest {

	@Test
	public void TestGoogle() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Selenium Tutorials",Keys.ENTER);
		String expectedTitle = "Selenium Tutorials - Google Search";
		String actualTitle =driver.getTitle();
		Assert.assertEquals(actualTitle,expectedTitle, "Title is mismatched");
		driver.quit();
}

	@Test
	public void TestFacebook() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		driver.findElement(By.name("email")).sendKeys("Selenium Tutorials",Keys.ENTER);
		Thread.sleep(2000);
		
		SoftAssert softassert = new SoftAssert();
		
		//title assertion
		String expectedTitle = "Log into Facebook";
		String actualTitle =driver.getTitle();
		softassert.assertEquals(actualTitle,expectedTitle, "Title is mismatched");
		System.out.println(driver.getTitle());
		
		//url assertion
		
		String expectedUrl = "https://www.facebook.com/";
		String actualUrl =driver.getCurrentUrl();
		softassert.assertNotEquals(actualUrl,expectedUrl, "Url is mismatched");
		
		//text
		String expectedText = "";
		String actualText=driver.findElement(By.name("email")).getAttribute("value");
		softassert.assertEquals(actualText,expectedText, "Username text is mismatched");
		System.out.println(driver.getTitle());
		
		//border
		
		String expecteborder = "1px solid rgb(240, 40, 73)";
		String actualborder=driver.findElement(By.name("email")).getCssValue("border");
		softassert.assertEquals(actualborder,expecteborder, "border is mismatched");
		
		//error message
		
		String expecteErrormessage = "Thee email or mobile number you entered isn’t connected to an account. Find your account and log in.";
		String actualErrormessage=driver.findElement(By.xpath("//*[@id=\"email_container\"]/div[2]")).getText();
		softassert.assertEquals(actualErrormessage,expecteErrormessage, "user errormessage is mismatched");
		System.out.println(driver.getTitle());
		
		driver.quit();
		softassert.assertAll();
	}
}
