package Week3;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_001 {

	  public static void main(String[] args) {
		 
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("http://zero.webappsecurity.com");
		driver.manage().window().maximize();
		
		//String A =driver.getPageSource();
		//System.out.println(A);
		String A =driver.getCurrentUrl();
		System.out.println(A);
		
		
		//WebElement btnSignIn=driver.findElement(By.id("signin_button"));
		//btnSignIn.click();
		driver.findElement(By.id("signin_button")).click();
		driver.findElement(By.name("user_login")).sendKeys("username");
		driver.findElement(By.id("user_password")).sendKeys("password");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.id("details-button")).click();
		driver.findElement(By.id("proceed-link")).click();
		
	}

}
