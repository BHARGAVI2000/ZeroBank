package yourStorePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import yourStoreBase.BaseClass;



public class RegisterPage extends BaseClass {

	WebDriver driver;

	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);}

	@FindBy(linkText="Register")
	public WebElement register;
	public void clickRegister() {
		register.click();
	}
	@FindBy(id="input-firstname")
	public WebElement fname;
	public void setFirstName(String firstname) {
		fname.sendKeys(firstname);}

	@FindBy(id="input-lastname")
	public WebElement lname;
	public void setLastName(String lastname) {
		lname.sendKeys(lastname);}


	@FindBy(id="input-email")
	public WebElement email;
	public void setEmail(String emailid) {
		email.sendKeys(emailid);
	}
	@FindBy(id="input-telephone")
	public WebElement telephone;
	public void setTelephoneNumber(String telephoneNumber) {
		telephone.sendKeys(telephoneNumber);}

	@FindBy(id="input-password")
	public WebElement pswd;
	public void setPassword(String password) {
		pswd.sendKeys(password);}

	@FindBy(id="input-confirm")
	public WebElement confirmPswd;
	public void setConfirmPassword(String ConfirmPswd) {
		confirmPswd.sendKeys(ConfirmPswd);}

	@FindBy(name="agree")
	public WebElement checkbox;
	public void clickAgreecheckbox() {
		checkbox.click();}


	@FindBy(xpath="//*[@id=\"content\"]/form/div/div/input[2]")
	public WebElement continuebtn;
	public void clickcontinuebtn() {
		continuebtn.click();}

}
