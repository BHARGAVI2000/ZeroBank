package Week4Assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Slider {

	public static void main(String[] args) throws InterruptedException {
		
		//frames
		
		//driver.switchTo().frame(0) , followed by driver.switchTo().defaultContent()
		
		
		/*System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();    
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		   
		driver.get("https://jqueryui.com/slider/");
		
		driver.switchTo().frame(0);
		WebElement element = driver.findElement(By.xpath("//body/div[@id='slider']/span[1]"));
		Actions action= new Actions(driver);
		action.dragAndDropBy(element, 300,0).perform();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[contains(text(),'Demos')]")).click();
		driver.quit();*/
		
		
		
		//slider 2nd example
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();    
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("http://demo.automationtesting.in/Slider.html");
		
		WebElement element = driver.findElement(By.xpath("//body/section[1]/div[1]/div[1]/div[1]/div[1]/a[1]"));
		Actions act = new Actions(driver);
		//act.dragAndDropBy(element, 500, 0).build().perform();
		act.moveToElement(element).dragAndDropBy(element, 500, 0).build().perform();
		driver.quit();
		
		
		
		
		
		

	}

}
