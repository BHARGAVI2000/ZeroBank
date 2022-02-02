package loginPageSample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class loginPageObject {
	
	WebDriver driver;
	By Name=By.name("uid");
	By Password =By.name("password");
	By Login = By.name("btnLogin");
	
	
	
	// In this we don't use main method and test annotations
	public loginPageObject(WebDriver driver) {
	this.driver=driver;
    PageFactory.initElements(driver, this);
	
}
 public void Setname(String Uname){
	 driver.findElement(Name).sendKeys(Uname);
 }
 
 public void Setpassword(String Upassword){
	 driver.findElement(Password).sendKeys(Upassword);
 }
	 
	 public void Clicklog()
	 {
		 driver.findElement(Login).click();
	 }
 }

 
 
 
 
 



