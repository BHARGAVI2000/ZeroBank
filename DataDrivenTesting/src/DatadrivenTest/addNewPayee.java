package DatadrivenTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class addNewPayee {


	WebDriver driver;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();    
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);}

	@Test(priority=1)
	public void enterUrl() {
		driver.get("http://zero.webappsecurity.com/index.html");
		String actualTitle=driver.getTitle();
		String expectedTitle= "Zero - Personal Banking - Loans - Credit Cards";
		Assert.assertEquals(actualTitle, expectedTitle, "Zero bank title displayed");

	}
	@Test(priority=2)
	public void login() {
		driver.findElement(By.id("signin_button")).click();
		driver.findElement(By.id("user_login")).sendKeys("username");
		driver.findElement(By.id("user_password")).sendKeys("password");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.id("details-button")).click();
		driver.findElement(By.id("proceed-link")).click();
	}


	@Test(dataProvider= "PayeeData",priority =3)
	public void payBills(String P1, String P2, String P3, String P4) {
		driver.findElement(By.linkText("Pay Bills")).click();
		driver.findElement(By.linkText("Add New Payee")).click();
		driver.findElement(By.xpath("//input[@id='np_new_payee_name']")).sendKeys(P1);
		driver.findElement(By.id("np_new_payee_address")).sendKeys(P2);
		driver.findElement(By.id("np_new_payee_account")).sendKeys(P3);					
		driver.findElement(By.id("np_new_payee_details")).sendKeys(P4);
		driver.findElement(By.id("add_new_payee")).click();
		String Actual=driver.findElement(By.xpath("//div[@id='alert_content']")).getText();
		String Expected ="The new payee Payee2 was successfully created.";
		Assert.assertEquals(Actual, Expected);
	}

	@DataProvider(name="PayeeData")
	public String[][] testData() throws IOException {

		File src= new File("C:\\Users\\Aila\\eclipse-workspace\\DataDrivenTesting\\exceldata\\NewPayeeDetailsData.xlsx");
		FileInputStream fis= new FileInputStream(src);
		XSSFWorkbook workbook= new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int rowCount=sheet.getLastRowNum();
		int colCount= sheet.getRow(0).getLastCellNum();
		String Data[][]= new String[rowCount][colCount];
		for (int i = 1; i <= rowCount; i++) {
			XSSFRow  currentRow=sheet.getRow(i);
			for (int j = 0; j < colCount; j++) {

				Data[i-1][j]=	currentRow.getCell(j).getStringCellValue();
			}}
		workbook.close();
		fis.close();
		return Data;
	}
	@AfterClass
	public void closeBrowser() {
		driver.quit();}

}











