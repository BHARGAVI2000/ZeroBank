package myStoreTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class elementStatusCapture {

	public static void main(String[] args) throws InterruptedException {


		//Launch browser
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//open url
		driver.get("http://automationpractice.com/index.php");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.id("email_create")).sendKeys("saritha740@yahoo.ca");
		driver.findElement(By.id("SubmitCreate")).click();
		//get title					 
		System.out.println(driver.getTitle());
		Thread.sleep(2000);

		//check the firstname field enabled
		System.out.println(driver.findElement(By.xpath("//input[@id='customer_firstname']")).isEnabled());
		Thread.sleep(2000);
		//check the lastname field enabled
		System.out.println(driver.findElement(By.id("customer_lastname")).isEnabled());
		Thread.sleep(2000);
		//check the radio button is selected
		System.out.println(driver.findElement(By.id("id_gender2")).isSelected());
		Thread.sleep(2000);
        //close browser
		driver.quit();

	}

}
