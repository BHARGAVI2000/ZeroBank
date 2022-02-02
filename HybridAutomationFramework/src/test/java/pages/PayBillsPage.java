package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import base.BasePage;

public class PayBillsPage extends BasePage {
	
	
	public PayBillsPage(WebDriver driver) {
		super(driver);
		}
	@FindBy(xpath="//a[contains(text(),'Add New Payee')]")
	public WebElement lnkAddPayee;
	
	@FindBy(id="np_new_payee_name")
	public WebElement txtPayeeName;
	
	@FindBy(id="np_new_payee_address")
	public WebElement txtPayeeAddress;
	
	@FindBy(id="np_new_payee_account")
	public WebElement txtPayeeAccount;
	
	@FindBy(id="np_new_payee_details")
	public WebElement txtPayeeDetails;
	
	@FindBy(id="add_new_payee")
	public WebElement btnAddPayee;
	
	@FindBy(id="alert_container")
	public WebElement alertContainer;
	
	@FindBy(xpath="//a[contains(text(),'Pay Saved Payee')]")
	public WebElement lnkPaySavedPayee;
	
	@FindBy(xpath="//select[@id='sp_payee']")
	public WebElement drpdownPayee;
	
	public void doClickAddPayee() {
		lnkAddPayee.click();
		
	}
	
	public void doAddPayee(String pname, String paddress, String paccount, String pdetails) {
		txtPayeeName.sendKeys(pname);
		txtPayeeAddress.sendKeys(paddress);
		txtPayeeAccount.sendKeys(paccount);
		txtPayeeDetails.sendKeys(pdetails);
		btnAddPayee.click();
		
	}
	
	public void doClickPaySavedPayee() {
		lnkPaySavedPayee.click();
	}
	
	public void doPaySavedPayee(String pname) {
		Select s=new Select(drpdownPayee);
		s.selectByVisibleText(pname);
	}
	
	@FindBy(xpath="//select[@id='sp_account']")
	public WebElement drpdownspaccount;
	
	public void doSpAccount(String spaccount) {
		Select s=new Select(drpdownspaccount);
		s.selectByVisibleText(spaccount);
	}
	
	@FindBy(id="sp_amount")
	public WebElement spAmount;
	
	public void doSpAmount(String amount) {
		spAmount.sendKeys(amount);
	}
	
	@FindBy(id="sp_date")
	public WebElement spDate;
	
	public void doSpDate(String date) {
		spDate.sendKeys(date);
	}
	
	@FindBy(id="sp_description")
	public WebElement txtSpDescription;
	
	public void doSpDescription(String description) {
		txtSpDescription.sendKeys(description);
	}
	
	@FindBy(id="pay_saved_payees")
	public WebElement btnPaySavedPayee;
	
	public void doClickbtnPaySavedPayee() {
		btnPaySavedPayee.click();
	}

}
