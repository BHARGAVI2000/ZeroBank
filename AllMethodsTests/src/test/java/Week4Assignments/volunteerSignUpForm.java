package Week4Assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class volunteerSignUpForm {


	WebDriver driver;
	@Parameters("browser")
	@BeforeMethod
	public void launchBrowser(String browser) {
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);}
	@Parameters({"userEmail","password"})
	@Test
	public void createAccount(String user, String password) {
		driver.get("https://www.formsite.com/");
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/a")).click();
		driver.findElement(By.id("UserEmail")).sendKeys(user);
		driver.findElement(By.id("Password1")).sendKeys("password");
		driver.findElement(By.xpath("//button[contains(text(),'Create account')]")).click();
		String actualTitle= driver.getTitle();
		String expectedTitle= "Formsite - Sign Up";
		Assert.assertEquals(actualTitle, expectedTitle);
		//System.out.println("getTitle()");
		String actualText= driver.findElement(By.xpath("//*[@id=\"menu-top-1\"]/h1/a")).getText();
		String expectedText= "Formsite - Logging in...";
		Assert.assertEquals(actualText, actualText);
		//System.out.println(driver.findElement(By.xpath("//*[@id=\"menu-top-1\"]/h1/a")).getText());
	}

	@AfterMethod
	public void closeBrowser()
	{		
		driver.quit();
	}

}
