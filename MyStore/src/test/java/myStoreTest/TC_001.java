package myStoreTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_001 {

	public static void main(String[] args) throws InterruptedException {


		//Verify search with valid data
		//1.Launch the browser       
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		//2.Enter the url of the website and press enter   
		driver.get("http://automationpractice.com/index.php");
		System.out.println(driver.getTitle());

		//  3.Type in dresses available in the catalog in the search text field then click on search            
		driver.findElement(By.id("search_query_top")).sendKeys("T-Shirts" );
		Thread.sleep(2000);

		// Output T-shirts image must be displayed
		WebElement img=driver.findElement(By.linkText("Faded Short Sleeve T-shirts"));
		System.out.println("Image displayed and Test is passed" +img);
		Thread.sleep(2000);
		driver.close();
	}

}
