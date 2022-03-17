package com.banking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;
	public  LoginPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(name="uid")
	public WebElement userID;
	public void enterUserID(String userid) {
		userID.sendKeys(userid);
	}


	@FindBy(name="password")
	public WebElement pswd;
	public void enterPassword(String password) 
	{pswd.sendKeys(password);}


	@FindBy(name="btnLogin")
	public WebElement login;
	public void clickLoginBtn() {
		login.click();

	}


}



