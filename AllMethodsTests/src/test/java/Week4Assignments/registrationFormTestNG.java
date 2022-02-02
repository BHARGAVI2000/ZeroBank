package Week4Assignments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class registrationFormTestNG {

	WebDriver driver;
	@BeforeMethod
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();    
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	@Test
	public void registerDetails() throws InterruptedException {

		driver.get("http://demo.automationtesting.in/Register.html");

		String actualTitle= driver.getTitle();
		String expectedTitle="Register";
		Assert.assertEquals(actualTitle, expectedTitle);

		String actualText= driver.getTitle();
		String expectedText="Register";
		Assert.assertEquals(actualText, expectedText);
        Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input")).sendKeys("SAR");

		driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[2]/input")).sendKeys("S");
		driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[2]/div/textarea")).sendKeys("45ST.TROPEZ");	

		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("saritha740@yahoo.ca");

		driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("4168889999");

		driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[5]/div/label[2]/input")).click();
		driver.findElement(By.id("checkbox1")).click();


		driver.findElement(By.xpath("//*[@id=\"msdd\"]")).click();
		List<WebElement>language=driver.findElements(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[7]/div/multi-select/div[2]/ul/li"));
		System.out.println(language.size());


		for(WebElement languageList:language)

		{if (languageList.getText().equals("English" ))

		{
			languageList.click();
			break;
		}
		}
		WebElement Skills=driver.findElement(By.xpath("//select[@id='Skills']"));
		Select Combo=new Select(Skills);
		Combo.selectByValue("C");
		

		driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[10]/div/span/span[1]/span")).click();
		Thread.sleep(2000);
		
		List<WebElement>country=driver.findElements(By.xpath("//*[@id=\"select2-country-results\"]/li"));
				System.out.println(language.size());


		for(WebElement countryList:country)

		{if (countryList.getText().equals("India" ))
		{
		countryList.click();
		//languageList.click();
			break;}
		driver.findElement(By.xpath("//li[contains(text(),'India')]")).click();
		WebElement Year=	driver.findElement(By.xpath("//select[@id='yearbox']"));
		Select Combo2=new Select(Year);
		Combo2.selectByValue("2004");

		WebElement Month=	driver.findElement(By.xpath("//body/section[@id='section']/div[1]/div[1]/div[2]/form[1]/div[11]/div[2]/select[1]"));
		Select Combo3=new Select(Month);
		Combo3.selectByVisibleText("February");


		WebElement Day=	driver.findElement(By.xpath("//select[@id='daybox']"));
		Select Combo4=new Select(Day);
		Combo4.selectByIndex(1);

		driver.findElement(By.id("firstpassword")).sendKeys("SAR2022");
		driver.findElement(By.id("secondpassword")).sendKeys("SAR2022");
		driver.findElement(By.xpath("//button[@id='submitbtn']")).click();
		Thread.sleep(2000);}



	}
	@AfterMethod
	public void closeBrowser()
	{		
		driver.quit();
	}}






