package myStore;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class TC_001 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		//Verify search with valid data

		/*
		
		//1.Launch the browser  
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//2.Enter the url of the website 
		driver.get("http://automationpractice.com/index.php");
		
		//3.Type in dresses available in the catalog in the search text field then click on search        
		driver.findElement(By.id("search_query_top")).sendKeys("T-Shirts" );
		
		// Output T-shirts image must be displayed
	    WebElement img=driver.findElement(By.linkText("Faded Short Sleeve T-shirts"));
	    System.out.println("Image displayed and Test is passed" +img);
	   driver.close();
	}
*/
	
	//Verify search  invalid data
	
	
		
		
		
		
	//1.Launch the browser  
		/*	System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			
			//2.Enter the url of the website 
			driver.get("http://automationpractice.com/index.php");
			
			//3.Type in dresses not available in the catalog in the search text field then click on search        
			driver.findElement(By.id("search_query_top")).sendKeys("kurtis" );
			
			// Output error message" No results were found for your search kurtis" displayed
		   
		    System.out.println("no images should be displayed/No results were found for your search kurtis , Test pass" );
		    driver.close();
*/
	
		    		    
		 /*   //1.Launch the browser  
		    System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();*/
		    
		    
		   /* //2.Enter the url of the website and press enter    
			driver.get("http://automationpractice.com/index.php");
			
			
		   // 3. Leave the blank in the search text box and click search button
		    
		      // driver.findElement(By.id("search_query_top")).click();
            //Output 
		       System.out.println("Please enter a search keyword should be displayed" );
			    driver.close();

	
}*/
	
	
	//Verify search with search suggestions
	
	
//	1.Launch the browser  
	
	//1.Launch the browser  
	
System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
	//2.Enter the url of the website and press enter      
	
	
	driver.get("http://automationpractice.com/index.php");
	
	//3.Type in dresses that are available in the categories in the  search text field 
		 
	
	/*	WebElement SearchSuggestion=driver.findElement(By.xpath("//input[@id='search_query_top']"));
	
	//SearchSuggestion.click();
	SearchSuggestion.sendKeys("blouse");
	
	SearchSuggestion.sendKeys(Keys.ARROW_DOWN);
	Thread.sleep(2000);
	SearchSuggestion.sendKeys(Keys.ENTER);
	Thread.sleep(2000);
	WebElement Imagelink=driver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[2]/h5[1]/a[1]"));
	
	System.out.println("Blouse Images displayed,  "+Imagelink.getText());
	driver.close();*/
		   driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys("dresses");
	//List<WebElement > autolist= driver.findElements(By.xpath("//*[@id=\"search\"]/div[3]/ul/li"));
		   List<WebElement>listofElements=driver.findElements(By.xpath("//body[1]/div[3]/ul/li"));
	System.out.println(listofElements.size());
	for (WebElement webElement : listofElements) {
		System.out.println(webElement.getText());
		
		if(webElement.getText().equals("T-shirts > Faded Short Sleeve T-shirts"));
		{
		webElement.click();
		break;
		}
	}
	
	

		
	}}
	
	
	
	
	
