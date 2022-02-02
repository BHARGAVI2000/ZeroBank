package myStoreTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_007 {

	public static void main(String[] args) throws InterruptedException {

		//1.Launch the browser   
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();   
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		//2.Enter the url of the website and press enter
		driver.get("http://automationpractice.com/index.php");
		System.out.print(driver.getTitle());
		Thread.sleep(2000);

		//3.Click on Women             
		driver.findElement(By.linkText("Women")).click();

		//output Women page with its categories and images should be displayed
		String TopsSubCategories=driver.findElement(By.xpath("//*[@id=\"subcategories\"]/ul/li[1]/h5/a")).getText();
		String DressesSubCategories=driver.findElement(By.xpath("//*[@id=\"subcategories\"]/ul/li[2]/h5/a")).getText();
		Thread.sleep(2000);
		System.out.println(TopsSubCategories + DressesSubCategories +",  My Store Women Subcategories tops,dresses displayed, test pass");
		driver.close();
	}

}
