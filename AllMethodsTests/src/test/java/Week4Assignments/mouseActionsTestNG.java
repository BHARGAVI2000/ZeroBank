package Week4Assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class mouseActionsTestNG {
	WebDriver driver;

	//Mouse Double Click
	@BeforeMethod
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();    
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void doubleClick() throws InterruptedException {
		driver.get("https://api.jquery.com/dblclick/");
		driver.switchTo().frame(0);// switch to frame as the element(square) is in the frame
		WebElement	Square=driver.findElement(By.xpath("/html/body/div"));// square element locator
		Actions act = new Actions(driver);
		act.doubleClick(Square).build().perform();// double click
		Thread.sleep(2000);
	}

	//Mouse Right click
	@Test
	public void rightClick() throws InterruptedException
	{
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		WebElement Rightclick=driver.findElement(By.xpath("//span[contains(text(),'right click me')]"));
		Actions act = new Actions(driver);
		act.contextClick(Rightclick).build().perform();
		driver.findElement(By.xpath("/html/body/ul/li[3]/span")).click();
		Thread.sleep(2000);
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}
	@Test
	public void dragAndDrop() throws InterruptedException {
		//drag and drop
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		WebElement OsloCapital =driver.findElement(By.xpath("//div[@id='box1']"));//oslo capital locator
		WebElement Target1 =driver.findElement(By.xpath("//*[@id=\"box101\"]"));// norway state locator
		WebElement RomeCapital =driver.findElement(By.xpath("//div[@id='box6']"));
		WebElement Target2=driver.findElement(By.xpath("//*[@id=\"box106\"]"));
		Actions act = new Actions(driver);
		act.dragAndDrop(OsloCapital, Target1).build().perform();
		act.dragAndDrop(RomeCapital, Target2).build().perform();
		Thread.sleep(2000);
	}
	@AfterMethod
	public void closeBrowser()
	{		
		driver.quit();
	}}



