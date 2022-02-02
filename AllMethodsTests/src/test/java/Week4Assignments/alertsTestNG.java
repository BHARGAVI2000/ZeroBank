package Week4Assignments;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class alertsTestNG {

	WebDriver driver;
    @Parameters("browser")
	@Test(priority=1)
	public void launchBrowser(String browser) {
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.automationtesting.in/Alerts.html");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test(priority=2)
	public void alertaccept() throws InterruptedException, IOException {
		driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/a[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'alert box:')]")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		File scrImage =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrImage, new File("C:\\ScreenShots\\image.jpg"));
	}

	@Test(priority=3)
	public void alertdismiss() throws InterruptedException {
		driver.findElement(By.xpath("//a[contains(text(),'Alert with OK & Cancel')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'click the button to display a confirm box')]")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().dismiss();}

	@Test(priority=4)
	public void alertTextBox() throws InterruptedException {
		driver.findElement(By.xpath("//a[contains(text(),'Alert with Textbox')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'click the button to demonstrate the prompt box')]")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().sendKeys("How are you");
		Thread.sleep(2000);
		driver.switchTo().alert().accept();}

	@Test(priority=5)
	public void closeBrowser()
	{		
		driver.quit();
	}
}






