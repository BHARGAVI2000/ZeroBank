package com.banking.testCases;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.banking.utilities.ReadConfig;

public class BaseClass {

	ReadConfig readconfig= new ReadConfig();
	public String baseURL=readconfig.getApplicationURL();
	public String username= readconfig.getUsername();
	public String password=readconfig.getPassword();
	public static  WebDriver driver;	
	//public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {

		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", readconfig.getChromepath());
			driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);  	

		} else  if (br.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxpath());
			driver= new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			//Logger logger= logger.
		}
		else  if (br.equals("ie")) {

			System.setProperty("webdriver.ie.driver", readconfig.getIEPath());
			driver= new InternetExplorerDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			//Logger logger= logger.
		}
		driver.get(baseURL);

	}

	@AfterClass
	public void tearDown() {
		driver.quit();

	}


}





