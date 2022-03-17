package com.banking.testCases;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.banking.pageObjects.LoginPage;

public class LoginTest_001 extends BaseClass{

	@Test
	public void loginTest() {

		
		LoginPage lp = new LoginPage(driver);
		lp.enterUserID(username);
		lp.enterPassword(password);
		lp.clickLoginBtn();
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) 
		{
			Assert.assertTrue(true);

		}else {Assert.assertTrue(false);}

	}
}