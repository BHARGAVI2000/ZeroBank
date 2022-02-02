package NewToursDemoAut;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HyperlinksCount {

	public static void main(String[] args) {
		
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();    
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	driver.get("http://demo.guru99.com/test/newtours/");
	List<WebElement >links	=driver.findElements(By.tagName("a"));

	System.out.print("Total Links:  "+links.size());
	for(int i=0;i<links.size();i++) {
		
		System.out.println(links.get(i).getText());
		
	}
	driver.quit();
	
	}
}
