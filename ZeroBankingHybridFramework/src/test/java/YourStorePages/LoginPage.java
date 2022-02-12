package yourStorePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import yourStoreBase.BaseClass;

public class LoginPage extends BaseClass {


	WebDriver driver;
	public LoginPage(WebDriver driver)
	{this.driver=driver;
	PageFactory.initElements(driver, this);

	}
	@FindBy(linkText="Login")
	public WebElement login;
	public void clicklogin() {
		login.click();

	}
	@FindBy(id="input-email")
	public WebElement email;
	public void setEmailID(String emailid) {
		email.sendKeys(emailid);
	}

	@FindBy(id="input-password")
	public WebElement pswd;
	public void setPassword(String password) {
		pswd.sendKeys(password);
	}


	@FindBy(xpath="//input[@type='submit']")
	public WebElement loginbtn;
	public void clickSubmitBtn() {
		loginbtn.click();
	}


}
