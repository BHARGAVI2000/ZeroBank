package myStoreTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_002 {

	public static void main(String[] args) throws InterruptedException {		
		//Verify search  invalid data
		//1.Launch the browser  
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);


		//2.Enter the url of the website and press enter    
		driver.get("http://automationpractice.com/index.php");


		//3.Type in dresses not available in the catalog in the search text field then click on search  
		driver.findElement(By.id("search_query_top")).sendKeys("kurtis" );
		driver.findElement(By.name("submit_search")).click();
		String actual=   driver.findElement(By.xpath("//p[contains(text(),'No results were found for your search \"kurtis\"')]")).getText();


		// Output error message" No results were found for your search kurtis" displayed   
		System.out.println("No results were found for your search kurtis , Test pass  " +actual);
		driver.close();
	}

}
