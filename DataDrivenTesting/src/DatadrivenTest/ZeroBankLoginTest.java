package DatadrivenTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ZeroBankLoginTest {
WebDriver driver;
	
	@BeforeClass
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}

	@Test(dataProvider="credential")
	public void login(String uname, String password) throws InterruptedException {
		driver.get("http://zero.webappsecurity.com/index.html");
		String actualTitle=driver.getTitle();
		String expectedTitle= "Zero - Personal Banking - Loans - Credit Cards";
		Assert.assertEquals(actualTitle, expectedTitle, "Zero bank title displayed");
	
		driver.findElement(By.id("signin_button")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("user_login")).sendKeys(uname);
		driver.findElement(By.id("user_password")).sendKeys(password);
		driver.findElement(By.name("submit")).click();

		driver.findElement(By.id("details-button")).click();
		driver.findElement(By.id("proceed-link")).click();

		String actualTitle1 = driver.getTitle();
		String expectedTitle1= "Zero - Account Summary";
		

		Assert.assertEquals(actualTitle, expectedTitle,"fail");
		System.out.println("Login Successfully done, Account Summary page opened");
		
	driver.findElement(By.xpath("//*[@id=\"settingsBox\"]/ul/li[3]/a")).click();
	driver.findElement(By.id("logout_link")).click();
	System.out.println("logged out successfully1");
	
	
	}
	


@DataProvider(name="credential")
public Object[][] testdata() throws IOException {
		
	File src= new File("C:\\Users\\Aila\\eclipse-workspace\\exceldata\\ExcelTestData.xlsx");
	//FileInputStream fis = new FileInpuStream(src);
	FileInputStream fis = new FileInputStream(src);
	XSSFWorkbook workbook = new XSSFWorkbook(fis);
	XSSFSheet sheet = workbook.getSheetAt(0);
	
	int rowCount=sheet.getLastRowNum();//4
	System.out.println(rowCount);
	int cellCount=sheet.getRow(0).getLastCellNum();//2
	System.out.println(cellCount);
	String data[][]= new String [rowCount][cellCount];
	for (int i = 1; i < rowCount+1; i++) {
		Row r = sheet.getRow(i);
		for (int j = 0; j < cellCount; j++) {
		System.out.println(data[i-1][j]=r.getCell(j).getStringCellValue());
			
		}
			
	}
	workbook.close();
    fis.close();
	
	return data;
	
    }


	@AfterClass
	public void tearDown() {
    driver.close();}

		

}



