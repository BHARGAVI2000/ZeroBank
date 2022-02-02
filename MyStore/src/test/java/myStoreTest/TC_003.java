package myStoreTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_003 {

	public static void main(String[] args) {	
		//Verify search with blank data

		//1.Launch the browser  
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		//2.Enter the url of the website and press enter    
		driver.get("http://automationpractice.com/index.php");

		// 3. Leave the blank in the search text box and click search button
		driver.findElement(By.id("search_query_top")).click();//SEARCH INPUT LOCATOR
		driver.findElement(By.name("submit_search")).click(); //SEARCH ICON CLICK
		String actual= driver.findElement(By.xpath("//p[contains(text(),'Please enter a search keyword')]")).getText();//search output locator

		//Output 
		System.out.println("Please enter a search keyword should be displayed  "+actual );
		driver.close();
	}

}
