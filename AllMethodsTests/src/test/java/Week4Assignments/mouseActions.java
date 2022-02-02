package Week4Assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class mouseActions {

	public static void main(String[] args) throws InterruptedException {

		//Mouse Double Click
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();    
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("https://api.jquery.com/dblclick/");

		//JavascriptExecutor Js= (JavascriptExecutor)driver;
		//Js.executeScript("window.scrollBy(0,2500)");//scrolling to the element , square
		driver.switchTo().frame(0);// switch to frame as the element(square) is in the frame

		WebElement	Square=driver.findElement(By.xpath("/html/body/div"));// square element locator
		Actions act = new Actions(driver);
		act.doubleClick(Square).build().perform();// double click

		/*//Mouse Right click
	System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();    
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");


	WebElement Rightclick=driver.findElement(By.xpath("//span[contains(text(),'right click me')]"));
	Actions act = new Actions(driver);
	act.contextClick(Rightclick).build().perform();
	driver.findElement(By.xpath("/html/body/ul/li[3]/span")).click();
	Thread.sleep(2000);
	System.out.println(driver.switchTo().alert().getText());
	driver.switchTo().alert().accept();*/

		//drag and drop
		/*	
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();    
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

		WebElement OsloCapital =driver.findElement(By.xpath("//div[@id='box1']"));//oslo capital locator
		WebElement Target1 =driver.findElement(By.xpath("//*[@id=\"box101\"]"));// norway state locator
		WebElement RomeCapital =driver.findElement(By.xpath("//div[@id='box6']"));
		WebElement Target2=driver.findElement(By.xpath("//*[@id=\"box106\"]"));
		Actions act = new Actions(driver);
		act.dragAndDrop(OsloCapital, Target1).build().perform();

		act.dragAndDrop(RomeCapital, Target2).build().perform();*/








	}

}
