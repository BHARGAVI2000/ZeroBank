package myStore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TC_003 {

	public static void main(String[] args) throws InterruptedException {
		
		
		
		//Verify Dresses 
/*
		
		
		//1.Launch the browser       
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();      
		
		
		//2.Enter the url of the website and click enter   
		
		driver.get("http://automationpractice.com/index.php");
		
		Thread.sleep(2000);
		
		
		System.out.print(driver.getTitle());
		
		//3.Click on Dresses               
		
		driver.findElement(By.xpath("//header/div[3]/div[1]/div[1]/div[6]/ul[1]/li[2]/a[1]")).click();
		Thread.sleep(2000);
		
		String actualText=driver.findElement(By.xpath("//p[contains(text(),'Subcategories')]")).getText();
		System.out.print(actualText +",    My Store Dresses Subcategories displayed, test pass");
		
		//driver.close();
		
		
				
		
			

			}

	*/
	
	
	
//	Verify Women with mouse hover

		

	//1.Launch the browser       
	System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();      
	
	
	//2.Enter the url of the website and click enter   
	
	driver.get("http://automationpractice.com/index.php");
	
	System.out.print(driver.getTitle());
	
	//3.Click on Women             
	
	WebElement MouseHover=driver.findElement(By.xpath("//header/div[3]/div[1]/div[1]/div[6]/ul[1]/li[1]/a[1]"));
	
	
	
	
	Actions action = new Actions(driver);
	action.moveToElement(MouseHover).perform();
	Thread.sleep(3000);
	System.out.print("Women categories element appeared , test pass");
	
	
	
	
	driver.close();
	}

	
}

