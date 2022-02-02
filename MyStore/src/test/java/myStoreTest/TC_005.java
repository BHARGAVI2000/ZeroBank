package myStoreTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_005 {

	public static void main(String[] args) throws InterruptedException {

		//Verify the sign in link
		//1.Launch the browser       
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		//2.Enter the url of the website and click enter   
		driver.get("http://automationpractice.com/index.php");
		System.out.print(driver.getTitle());
		Thread.sleep(2000);

		//3.Click on sign in       
		driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();	

		//output Authentication page should be opened
		String actualText=driver.findElement(By.xpath("//h1[contains(text(),'Authentication')]")).getText();
		System.out.println("Authentication page displayed, test pass   "  + actualText );
		System.out.println( actualText );

		driver.close();

	}

}
