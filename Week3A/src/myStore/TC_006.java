package myStore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TC_006 {

	public static void main(String[] args) throws InterruptedException {
		//Verify add to cart

		//1.Launch the browser    
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();      
		
			
		//2.Enter the url of the website and click enter   
		
		driver.get("http://automationpractice.com/index.php");
		System.out.print(driver.getTitle());
		
		// 3.Click  women tab   
		driver.findElement(By.linkText("Women")).click();
		Thread.sleep(2000);


		//  4. Select the category  
		// driver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/div[2]/ul[1]/li[2]/div[1]/a[1]/img[1]")).click();
	
	                                                                                                  
	  //5. Click on the sub category and select the item from the instock and then click add to cart and close
		 
		
		 driver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/div[2]/ul[1]/li[2]/h5[1]/a[1]")).click();
		 driver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/a[1]/img[1]")).click();
		 driver.findElement(By.id("product")).click();
		 driver.findElement(By.xpath("//body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[2]/div[2]/a[1]/span[1]")).click();
					
		}
	
	//1.Launch the browser       
	//2.Enter the url of the website and press enter            
                 //   3.Type in the text in the search text box and click search              
}           //   4. Select the item from the instock and then click add to cart and close




		