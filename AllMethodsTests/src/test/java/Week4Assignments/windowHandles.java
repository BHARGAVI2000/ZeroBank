  package Week4Assignments;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowHandles {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		/*
		 * // this is for multiple window
		 *  System.setProperty("webdriver.chrome.driver",
		 * "C:\\drivers\\chromedriver.exe"); WebDriver driver = new ChromeDriver();
		 * driver.manage().window().maximize();
		 * driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		 * 
		 * 
		 * String parentHandle=driver.getWindowHandle();
		 * System.out.println("parent window- "+parentHandle);
		 * driver.findElement(By.id("newWindowBtn")).click();
		 * Set<String>handles=driver.getWindowHandles();
		 * 
		 * for (String handle : handles) {
		 * 
		 * System.out.println(handle); if (!handle.equalsIgnoreCase(parentHandle)) {
		 * driver.switchTo().window(handle);
		 * 
		 * driver.findElement(By.id("firstName")).sendKeys("saritha");
		 * Thread.sleep(3000); driver.close();
		 * 
		 * 
		 * }
		 * 
		 * } driver.switchTo().window(parentHandle);
		 * driver.findElement(By.id("name")).sendKeys("Aila"); Thread.sleep(3000);
		 */
		// driver.quit();

		// this is for multiple tab
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");

		String parentHandle = driver.getWindowHandle();
		System.out.println("parent window- " + parentHandle);
		driver.findElement(By.id("newTabBtn")).click();
		Set<String> handles = driver.getWindowHandles();

		for (String handle : handles) {

			System.out.println(handle);
			if (!handle.equalsIgnoreCase(parentHandle)) {
				driver.switchTo().window(handle);

				driver.findElement(By.id("alertBox")).click();
				driver.switchTo().alert().accept();
				Thread.sleep(3000);
				driver.close();

			}

		}
		driver.switchTo().window(parentHandle);
		driver.findElement(By.id("name")).sendKeys("Aila");
		Thread.sleep(3000);
		driver.quit();

	}

}
