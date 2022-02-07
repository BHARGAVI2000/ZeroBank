package YourStorePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BankingBase.BaseClass;

public class MyAccountPage extends BaseClass {
	WebDriver driver;

	public MyAccountPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);}

	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/a")
	public WebElement account;
	public void clickMyAccount() {
		account.click();}

	@FindBy(linkText="Register")
	public WebElement reg;
	public void clickRegister() {
		reg.click();}

}
