package myStore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_002 {

	public static void main(String[] args) {
		
		
		
		//1.Launch the browser       
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//2.Enter the url of the website and click enter   
		
		driver.get("http://automationpractice.com/index.php");
		
		System.out.print(driver.getTitle());
		
	   //3.Click on sign in       
		
		driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
		
		//output Authentication page should be opened

		String actualText=driver.findElement(By.xpath("//h1[contains(text(),'Authentication')]")).getText();
		System.out.print(actualText    +",    Authentication page displayed, test pass");
		
        driver.close();
	}

}
