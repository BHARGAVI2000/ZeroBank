package Week4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameterization {
	WebDriver driver;

	@Test
	@Parameters("browserName")
	public void login(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
			driver= new ChromeDriver();
			driver.manage().window().maximize();

		} else if (browserName.equalsIgnoreCase("firefox"))
		{System.setProperty("webdriver.gecko.driver", "C:\\drivers\\geckodriver.exe");
		driver= new FirefoxDriver();
		}
		else if (browserName.equalsIgnoreCase("IE"))
		{System.setProperty("webdriver.ie.driver", "C:\\drivers\\IEDriverServer.exe");
		driver=new InternetExplorerDriver();
		}

    	driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://zero.webappsecurity.com");
		System.out.println(driver.getTitle());
		driver.quit();
	}
	}
