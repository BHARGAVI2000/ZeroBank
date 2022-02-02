package Week4Assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class alerts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//alert box with ok button
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();    
		
		driver.get("http://demo.automationtesting.in/Alerts.html");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		/*driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/a[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'alert box:')]")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();*/
		
		
		
		/*alert box with ok button and cancel
		 driver.findElement(By.xpath("//a[contains(text(),'Alert with OK & Cancel')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'click the button to display a confirm box')]")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().dismiss();*/
		
		
		
		
		//alert box with text box
		driver.findElement(By.xpath("//a[contains(text(),'Alert with Textbox')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'click the button to demonstrate the prompt box')]")).click();
		Thread.sleep(2000);
		
		driver.switchTo().alert().sendKeys("How are you");
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		driver.quit();
		
		
		
		
		
		
		
		
	}

}
