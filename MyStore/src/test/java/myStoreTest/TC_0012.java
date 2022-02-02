package myStoreTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TC_0012 {

	public static void main(String[] args) throws InterruptedException {

		//Verify add to my cart
		//1.Launch the browser       	 
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		//2.Enter the url of the website and press enter     
		driver.get("http://automationpractice.com/index.php");
		System.out.println(driver.getTitle());

		//add to cart
		driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[1]/a")).click();//click on women
		Thread.sleep(3000);


		driver.findElement(By.xpath("//*[@id=\"categories_block_left\"]/div/ul/li[1]/a")).click();
		Thread.sleep(3000);//click on tops

		driver.findElement(By.xpath("//*[@id=\"subcategories\"]/ul/li[2]/div[1]/a/img")).click();
		Thread.sleep(3000);	//click on blouses	

		WebElement mouseHover=driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img"));

		Actions act = new Actions(driver);
		act.moveToElement(mouseHover).build().perform();	//hover mouse on the blouse to click on add to cart

		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[2]/span")).click();
		Thread.sleep(3000);// click on more options


		driver.findElement(By.xpath("//*[@id=\"quantity_wanted\"]")).clear();//clear quantity
		driver.findElement(By.xpath("//*[@id=\"quantity_wanted\"]")).sendKeys("2"); //enter the quatity

		Thread.sleep(2000);
		WebElement Combobox = driver.findElement(By.xpath("//*[@id=\"group_1\"]"));// identify combobox for size
		Select sel = new Select(Combobox); 			//create object for select to select the size form combobox	
		sel.selectByVisibleText("M");// select method
		driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button/span")).click();//click on add
		Thread.sleep(2000);

		JavascriptExecutor executor = (JavascriptExecutor)driver;
		WebElement element = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a"));//proceed to checkout
		executor.executeScript("arguments[0].click();", element);	


		String addCart=	driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a")).getText();
		System.out.println("Items added to cart, Test pass," +addCart);						
		Thread.sleep(2000);


		//4. Select and hover the mouse on the item and click on the remove this product from cart icon 				
		WebElement item=	driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a"));//view my shopping cart locator
		WebElement image=driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/div/div/div/dl/dt/a/img"));//image to be deleted locator

		WebElement del= driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/div/div/div/dl/dt/span/a"));//del icon locator
		act.moveToElement(item).build().perform();//view cart hover
		Thread.sleep(2000);
		act.moveToElement(image).build().perform();//image hover
		Thread.sleep(2000);
		act.moveToElement(del).click().build().perform();//delete button click
		Thread.sleep(2000);
		driver.close();
	}

}
