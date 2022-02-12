package yourStoreBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import yourStoreUtilities.TakeScreenShot;
import yourStoreUtilities.XTentReport;


public class BaseClass {

	public static ExtentReports Report;
	public static Properties config = new Properties();
	public static WebDriver driver = null;
	public static Logger app_logs = Logger.getLogger("qaLogger");
	public static ExtentTest test;

	@BeforeSuite()
	public static void init() throws IOException {


		if (driver == null) {
			// load config property file
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\config.properties");//actual code
			config.load(fis);
			app_logs.debug("loading the config property file");

			if (config.getProperty("browser").equals("chrome")
					) {

				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"\\src\\test\\resources\\drivers\\chromedriver.exe");
				driver = new ChromeDriver();
				//app_logs.debug("chrome browser launched");

			} else if (config.getProperty("browser").equals("firefox")) {
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (config.getProperty("browser").equals("edge")) {
				System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\msedgedriver.exe");
				driver = new EdgeDriver();
			}
			driver.manage().window().maximize();
			driver.get(config.getProperty("testsiteURL"));
			//driver.get("https://demo.opencart.com");

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


		}
	}

	@AfterSuite()
	public void tearDown() throws AddressException, MessagingException, IOException {

		if(driver!=null) {
			driver.close();
			//	driver.quit();
		}
	}}















