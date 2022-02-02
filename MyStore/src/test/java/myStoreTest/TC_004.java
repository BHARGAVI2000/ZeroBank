package myStoreTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;

public class TC_004 {

	public static void main(String[] args) {
		//Verify search with search suggestions
		//1.Launch the browser  
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		//2.Enter the url of the website and press enter      
		driver.get("http://automationpractice.com/index.php");

		//3.Type in dresses that are available in the categories in the  search text field 
		driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys("dresses");// enter dresses in search box
		WebElement	searchitemsuggestion=driver.findElement(By.xpath("//li[contains(text(),'Evening Dresses > Printed Dress')]"));//locator for select item from search suggestion 
		Actions action= new Actions(driver);
		action.moveToElement(searchitemsuggestion).click().build().perform();
		String imageText = driver.findElement(By.xpath("//h1[contains(text(),'Printed Dress')]")).getText();
		System.out.println("Printed dress images displayed,  "+imageText);
		driver.close(); 


		//the below one is another  method using keyboard keys

		/*WebElement SearchSuggestion=driver.findElement(By.xpath("//input[@id='search_query_top']"));

		//SearchSuggestion.click();
		SearchSuggestion.sendKeys("blouse");

		SearchSuggestion.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		SearchSuggestion.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		WebElement Imagelink=driver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[2]/h5[1]/a[1]"));
		 */



	}}


