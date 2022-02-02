package myStore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_004 {

	public static void main(String[] args) throws InterruptedException {
		//1.Launch the browser       
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();      
  
		
		
		
		//2.Enter the url of the website and press enter   
		
		driver.get("http://automationpractice.com/index.php");
		System.out.print(driver.getTitle());
		
		
		//3.Click on women    
		

driver.findElement(By.xpath("//header/div[3]/div[1]/div[1]/div[6]/ul[1]/li[1]/a[1]")).click();

Thread.sleep(3000);
String actualText=driver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/h1[1]/span[1]")).getText();
System.out.print(actualText +",    My Store Women Subcategories displayed, test pass");

driver.close();


		
	}

}






               


		
		
	

	

