package myStoreTest;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNG012 {

	//Verify add to my cart
	WebDriver driver;
	@BeforeClass
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}

	@Test(priority=1)
	public void enterUrl() {
		driver.get("http://automationpractice.com/index.php");
		String actualTitle=driver.getTitle();
		String expectedTitle= "My Store";
		Assert.assertEquals(actualTitle, expectedTitle, "Mystore title displayed");
	}

	@Test(priority=2)
	public void  clickWomen() throws InterruptedException {
		driver.findElement(By.linkText("Women")).click();
		Thread.sleep(2000);}

	@Test(priority =3)
	public void clickTops() throws InterruptedException, IOException {
		driver.findElement(By.xpath("//*[@id=\"categories_block_left\"]/div/ul/li[1]/a")).click();
		Thread.sleep(3000);}

	@Test(priority=4)
	public void clickBlouses() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"subcategories\"]/ul/li[2]/div[1]/a/img")).click();

		WebElement mouseHover=driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img"));
		Actions act = new Actions(driver);
		act.moveToElement(mouseHover).build().perform();//hover mouse on the blouse to click on add to cart	
		Thread.sleep(3000);

		driver.findElement(By.xpath("//span[contains(text(),'More')]")).click();
		Thread.sleep(3000);// click on more options

		driver.findElement(By.id("quantity_wanted")).clear();
		driver.findElement(By.id("quantity_wanted")).sendKeys("2");

		Thread.sleep(1000);
		WebElement Combobox = driver.findElement(By.name("group_1"));// identify combobox for size

		Select sel = new Select(Combobox); 			//create object for select to select the size form combobox	
		sel.selectByVisibleText("M");// select method
	}
	@Test(priority=5)
	public void addToCart() throws InterruptedException, IOException {

		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)");

		driver.findElement(By.xpath("//span[contains(text(),'Add to cart')]")).click();
		Thread.sleep(2000);

		JavascriptExecutor executor = (JavascriptExecutor)driver;
		WebElement element = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a"));//proceed to checkout
		executor.executeScript("arguments[0].click();", element);	

		String actualaddCart=	driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a")).getText();
		String expectedaddCart= "Cart 2 Products";
		Assert.assertEquals(actualaddCart, expectedaddCart);
		
		File topsLowPrice=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(topsLowPrice, new File("C:\\Screenshots\\addcartItems.jpg"));

		}

	//4. Select and hover the mouse on the item and click on the remove this product from cart icon 
	@Test(priority=6)
	public void deleteItemFromCart() throws InterruptedException, IOException {
		WebElement item=driver.findElement(By.xpath("//div[@class='shopping_cart']/a"));
		WebElement image=driver.findElement(By.xpath("//a[@class='cart-images']"));
		WebElement del=driver.findElement(By.xpath("//a[@class='ajax_cart_block_remove_link']"));
		Actions act = new Actions(driver);
		act.moveToElement(item).build().perform();//view cart hover
		Thread.sleep(1000);
		act.moveToElement(image).build().perform();//image hover
		Thread.sleep(1000);
		act.moveToElement(del).click().build().perform();//delete button click
		Thread.sleep(2000);
		File topsLowPrice=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(topsLowPrice, new File("C:\\Screenshots\\deletedcartItems.jpg"));

	}
	@AfterClass
	public void tearDown() {
		driver.close();
	}


}
