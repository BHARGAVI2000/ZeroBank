package Week4;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RandomStringforTakesScreenshot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://zero.webappsecurity.com");
		String fileName ="automation"+getRandomString(4)+".png";
		File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("C:\\Screenshots\\"+ fileName));
		driver.quit();
	}
	//this for generate random string for the above screen schot to have different filename as 
	//it overwrite on the previous screenshot
	public static String getRandomString(int length) {
		StringBuilder sb= new StringBuilder();
		String characters="abcdefghijklmnopqrstuvwxyz1234567890";
		for(int i=0; i<length;i++) {
			int index =(int)(Math.random()*characters.length());
			sb.append(characters.charAt(index));
		}
		return sb.toString(); 

	}

}
