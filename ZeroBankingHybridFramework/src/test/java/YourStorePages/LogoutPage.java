package yourStorePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import yourStoreBase.BaseClass;

public class LogoutPage extends BaseClass{
	WebDriver driver;

	public LogoutPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);}

	@FindBy(linkText="Logout")
	public WebElement lout;
	public void clickLogout() {
		lout.click();}

}
