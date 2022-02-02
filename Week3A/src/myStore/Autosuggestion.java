package myStore;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Autosuggestion {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		//driver.findElement(By.name("q")).sendKeys("selenium");
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("selenium");
		Thread.sleep(2000);
		
		List<WebElement>listofElements=driver.findElements(By.xpath("//ul[@role='listbox']/li"));
		System.out.println(listofElements.size());
		//List<WebElement> results=driver.findElements(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]/div[2]/div[2]/ul/li"));
	for (WebElement webElement : listofElements) {
		System.out.println(webElement.getText());
	
		if(webElement.getText().equals("selenium download")) {
			webElement.click();
			break;
		}
	}
	
	Thread.sleep(2000);
	driver.quit();
	
		
	}
	}


