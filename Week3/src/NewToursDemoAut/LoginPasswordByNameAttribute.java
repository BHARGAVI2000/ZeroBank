package NewToursDemoAut;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPasswordByNameAttribute {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();    
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
		// TODO Auto-generated method stub
		driver.get("http://demo.guru99.com/test/newtours/");
		System.out.println(driver.findElement(By.xpath("//font[contains(text(),'Name:')]")).getText());
		System.out.println(driver.findElement(By.xpath("//font[contains(text(),'Password:')]")).getText());
		
		driver.quit();
	}


}
