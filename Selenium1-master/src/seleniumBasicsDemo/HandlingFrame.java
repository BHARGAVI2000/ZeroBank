package seleniumBasicsDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandlingFrame {
	
	public static void main(String[] args) throws InterruptedException {
		//System.setProperty("webdriver.gecko.driver", "C:\\driver\\geckodriver-v0.20\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();    
		driver.get("http://www.firstcry.com/");
		driver.switchTo().frame("iframe_Login");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='Email']")).sendKeys("Naresh");
		driver.findElement(By.xpath("//div[@class='_pop_close _pop_reg_bg']")).click();
		driver.quit();
	}
		
}
