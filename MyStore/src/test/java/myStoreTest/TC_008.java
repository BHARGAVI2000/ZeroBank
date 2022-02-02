package myStoreTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TC_008 {

	public static void main(String[] args) throws InterruptedException {

		//Verify Women with mouse hover	
		//1.Launch the browser       
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();   
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);    

		//2.Enter the url of the website and click enter   
		driver.get("http://automationpractice.com/index.php");
		System.out.println(driver.getTitle());

		//3.Click on Women             
		WebElement MouseHover=driver.findElement(By.xpath("//header/div[3]/div[1]/div[1]/div[6]/ul[1]/li[1]/a[1]"));		
		Actions action = new Actions(driver);
		action.moveToElement(MouseHover).build().perform();
		Thread.sleep(3000);
		System.out.print("Women categories items appeared , test pass");
		
		System.out.println(driver.findElement(By.xpath("//li[@class='sfHover']/ul")).getText());
		driver.close();
	}

}


