package seleniumbasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class seleniumFirstScript1 {

	public static void main(String[] args) throws InterruptedException {
	
		
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		

		
		WebDriver driver=new ChromeDriver();
		
		
		  driver.get("http://www.facebook.com"); 
		  
		  driver.manage().window().maximize();
		  Thread.sleep(4000); 
		 
		  driver.quit();
		 
		 
		
	}

}
