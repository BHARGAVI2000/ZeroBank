package seleniumbasics;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class seleniumFirstScript4 {

	public static void main(String[] args) throws InterruptedException, IOException {
	
	//System.setProperty("webdriver.edge.driver", "C:\\driver\\edgedriver_win64\\msedgedriver.exe");actual code
	//		WebDriver driver=new EdgeDriver();
		
		
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
	driver.get("http://www.facebook.com"); 
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
	driver.quit();

		 
	}

}
