package seleniumAdv2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class KeyPressEvent2 {

	public static void main(String[] args) throws InterruptedException {
		//System.setProperty("webdriver.gecko.driver", "C:\\drivers\\geckodriver.exe");
				//WebDriver driver = new FirefoxDriver();
				System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
				WebDriver driver = new ChromeDriver();
		driver.get("http://www.twoplugs.com");
		driver.findElement(By.xpath("//div[@class='text-center']//span[text()='Read more about trust & safety']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='text-center']//span[text()='Read more about trust & safety']")).sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//div[@class='text-center']//span[text()='Read more about trust & safety']")).sendKeys(Keys.PAGE_UP);
		//Thread.sleep(3000);
		}
}
