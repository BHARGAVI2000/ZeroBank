package seleniumBasicsDemo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WorkingwithWebElements{
	
	public static void main(String[] args){
		//System.setProperty("webdriver.gecko.driver", "C:\\driver\\geckodriver-v0.20\\geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", "C:\\drivers\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("http://newtours.demoaut.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		WebElement username=driver.findElement(By.name("userName"));
		username.sendKeys("tutorial");
		WebElement password=driver.findElement(By.name("password"));
		password.sendKeys("tutorial");
		driver.findElement(By.name("login")).click();
		
		WebElement block=driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]"));
		List<WebElement> radio_btn=block.findElements(By.tagName("input"));
		int s=radio_btn.size();
		System.out.println(s);
		for(int i=0; i<s; i++){
			System.out.println(radio_btn.get(i).getAttribute("value"));
		}
		driver.quit();
		}
}
