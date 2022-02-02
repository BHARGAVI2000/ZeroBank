package myStoreTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_009 {

	public static void main(String[] args) throws InterruptedException {

		//Verify Women with its tops subcategories link
		//1.Launch the browser     
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		//2.Enter the url of the website and press enter 		
		driver.get("http://automationpractice.com/index.php");
		System.out.println(driver.getTitle());

		//3.Click on women     		
		driver.findElement(By.linkText("Women")).click();
		Thread.sleep(2000);

		//4.Click on top subcatogories link   		
		driver.findElement(By.linkText("Tops")).click();
		String Tshirts=driver.findElement(By.linkText("T-shirts")).getText();
		String Blouses=driver.findElement(By.linkText("Blouses")).getText();


		//Output Tops subcategories links should be displayed
		System.out.println("Tops subcategories T-shirts, Blouses Links displayed, Test Pass,  "+Tshirts + Blouses);
		driver.close();
	}

}
