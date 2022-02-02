package DatadrivenTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class demoTours {
	WebDriver driver;
@BeforeClass
public void launchBrowser() {
	System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
     driver=  new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);}
    
    @Test(dataProvider="TestData")
    public void loginTest(String uname, String pswd) throws InterruptedException
    {
    driver.get("https://demo.guru99.com/test/newtours/");
    String ActualTitle=driver.getTitle();
    String expectedTitle="Welcome: Mercury Tours";
    Assert.assertEquals(ActualTitle, expectedTitle);
    System.out.println("Title is matched, url page is successful");
    
    
    driver.findElement(By.name("userName")).sendKeys(uname);
    driver.findElement(By.name("password")).sendKeys(pswd);
    driver.findElement(By.name("submit")).click();
  String actualText=  driver.findElement(By.xpath("//h3[contains(text(),'Login Successfully')]")).getText();
  String expectedText= "Login Successfully";
  Assert.assertEquals(actualText, expectedText, "login not successful");
  System.out.println("Text is matched, login is successful ");
  driver.findElement(By.linkText("SIGN-OFF")).click();
 System.out.println("logged out successfully");
  
	}
  @DataProvider(name="TestData")
  public String[][] testData() throws IOException {
	  
	File src= new File("C:\\Users\\Aila\\eclipse-workspace\\DataDrivenTesting\\exceldata\\NewTourTestData.xlsx") ;
	FileInputStream fis=  new FileInputStream(src);
	XSSFWorkbook workbook = new XSSFWorkbook(fis);
	XSSFSheet sheet = workbook.getSheetAt(0);
	int rowcount=sheet.getLastRowNum();
	System.out.println("row count"+rowcount);
	int colcount=sheet.getRow(0).getLastCellNum();
	System.out.println("row count"+colcount);
	
	String data[][]= new String[rowcount][colcount];
	for (int i = 1; i <= rowcount; i++) {
		XSSFRow r=sheet.getRow(i);
		for (int j = 0; j <colcount; j++) {
		 data[i-1][j]	=r.getCell(j).getStringCellValue();
		//System.out.println(data[i-1][j]=r.getCell(j).getStringCellValue();	
		}}
	workbook.close();
	fis.close();
	return data;
  }

@AfterClass
	public void closeBrowser() {
		driver.quit();
	
	}}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
    
    
    
	

		
		
	