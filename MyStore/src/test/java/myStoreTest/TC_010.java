package myStoreTest;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_010 {

	public static void main(String[] args) throws InterruptedException, IOException {
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

		//Click on tops subcatogories image
		driver.findElement(By.xpath("//*[@id=\"subcategories\"]/ul/li[1]/div[1]/a/img")).click();
		
		//Output Tops subcategories Images should be displayed
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.linkText("T-shirts")).getText());
		System.out.println(driver.findElement(By.xpath("//*[@id=\"subcategories\"]/ul/li[2]/h5/a")).getText());
		File topsSubcategoriesImages=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(topsSubcategoriesImages, new File("C:\\Screenshots\\topsImages.jpg"));
		System.out.println("Tops subcategories T-shirts, Blouses imagetext and images displayed");	
		driver.close();
	}	
}


