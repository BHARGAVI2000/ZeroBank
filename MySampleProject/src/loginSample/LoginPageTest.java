package loginSample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import loginPageSample.loginPageObject;

public class LoginPageTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "c:\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		loginPageObject LPO= new loginPageObject(driver);
		driver.get("http://demo.guru99.com/V4");
		LPO.Setname("mngr375526");
		LPO.Setpassword("yjaquqU");
		LPO.Clicklog();
		driver.close();

	}//mngr379205    //AbYjavE

}
