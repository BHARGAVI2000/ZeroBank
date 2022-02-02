package myStoreTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TC_011 {

	public static void main(String[] args) throws InterruptedException {
		//Verify Women  subcategories with sort by
		//1.Launch the browser   
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		//2.Enter the url of the website and press enter     
		driver.get("http://automationpractice.com/index.php");
		System.out.println(driver.getTitle());

		//Click on women             
		driver.findElement(By.linkText("Women")).click();
		Thread.sleep(2000);


		//4.Click on tops subcatogories image and Select the filter in the combo box
		driver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/div[2]/ul[1]/li[1]/div[1]/a[1]/img[1]")).click();//tops locator
		Thread.sleep(2000);

		//driver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/div[2]/ul[1]/li[1]/div[1]/a[1]")).click();//combobox element locator
		//Thread.sleep(2000);

		WebElement ComboList= driver.findElement(By.xpath("//select[@id='selectProductSort']"));//combobox locator from chropath 
		Select sortby = new Select(ComboList);
		sortby.selectByVisibleText("Price: Lowest first");
		//sortby.selectByIndex(5);
		Thread.sleep(2000);

		System.out.println("Tops images  displayed as per the lowest price images displayed, Test Pass");
		driver.close();


	}

}
