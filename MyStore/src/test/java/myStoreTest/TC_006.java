package myStoreTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_006 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//1.Launch the browser   
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();   
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		//2.Enter the url of the website and press enter
		driver.get("http://automationpractice.com/index.php");
		System.out.print(driver.getTitle());
		Thread.sleep(2000);

		//3.Click on Dresses               
		driver.findElement(By.xpath("//header/div[3]/div[1]/div[1]/div[6]/ul[1]/li[2]/a[1]")).click();

		//output Dresses page with its subcategories  should be displayed
		String actualText=driver.findElement(By.xpath("//p[contains(text(),'Subcategories')]")).getText();
		System.out.print(actualText +   ",    My Store Dresses Subcategories displayed, test pass");
		driver.close();
	}}
