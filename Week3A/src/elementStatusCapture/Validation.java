package elementStatusCapture;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Validation {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://automationpractice.com/index.php");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.linkText("Sign in")).click();

		driver.findElement(By.id("email_create")).sendKeys("saritha740@yahoo.ca");
		driver.findElement(By.id("SubmitCreate")).click();

		System.out.println(driver.getTitle());
		Thread.sleep(2000);


		System.out.println(driver.findElement(By.xpath("//input[@id='customer_firstname']")).isEnabled());

		Thread.sleep(2000);
		System.out.println(driver.findElement(By.id("customer_lastname")).isEnabled());
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.id("id_gender2")).isSelected());
		Thread.sleep(2000);
		driver.quit();

	}


}
