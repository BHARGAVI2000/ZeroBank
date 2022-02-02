package TestNG;



	
	

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebDriver.Timeouts;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.Test;

	import okio.Timeout;
	public class TC_001 {

	 

		//public static void main(String[] args) throws InterruptedException {
			@Test
			public void AddPayee() throws InterruptedException {
			System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();    
			
			
			driver.get("http://zero.webappsecurity.com/");
			driver.findElement(By.id("signin_button")).click();
			driver.findElement(By.id("user_login")).sendKeys("username");
			driver.findElement(By.id("user_password")).sendKeys("password");
			driver.findElement(By.name("submit")).click();
			driver.findElement(By.id("details-button")).click();
			driver.findElement(By.id("proceed-link")).click();
			
			driver.findElement(By.linkText("Pay Bills")).click();
			driver.findElement(By.linkText("Add New Payee")).click();
			
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='np_new_payee_name']")).sendKeys("HydroOne Utility");
			Thread.sleep(2000);
			driver.findElement(By.id("np_new_payee_address")).sendKeys("200 RobertSpec Pkwy, Mississauga,ON L6R1K9");
			Thread.sleep(2000);
			driver.findElement(By.id("np_new_payee_account")).sendKeys("123234434");					
			driver.findElement(By.id("np_new_payee_details")).sendKeys("Natural Gas Utility");
			driver.findElement(By.id("add_new_payee")).click();
			Thread.sleep(2000);
			String Actual=driver.findElement(By.xpath("//div[@id='alert_content']")).getText();
			
			Thread.sleep(2000);
			String Expected ="The new payee HydroOne Utility was successfully created.";
					
			if(Actual.equals(Expected)) {
				System.out.println("Test Pass");}
				else
				{	System.out.println("Test Fail");
			}
					
				driver.quit();
				
				
				
			}
		}
		 
		





