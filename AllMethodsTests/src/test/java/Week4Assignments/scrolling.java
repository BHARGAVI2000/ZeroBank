package Week4Assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class scrolling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();    
		
		driver.get("https://www.countries-ofthe-world.com/flags-of-the-world.html");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement Country =driver.findElement(By.xpath("//td[contains(text(),'India')]"));
		
		JavascriptExecutor Js= (JavascriptExecutor)driver;
		Js.executeScript("arguments[0].scrollIntoView();", Country);
		Thread.sleep(2000);
		
		System.out.println(Country.getText());
		
		driver.quit();
		
		
		
		
	}

}
