package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;


import base.BaseClass;
import pages.HomePage;
import pages.LoginPage;


public class TC001Login extends BaseClass {

	
	
	@Test
	public void verifyLogin() {
	
	
		HomePage hp = new HomePage(driver);
		
		hp.doClickSingInbtn();
		
		LoginPage lp=new LoginPage(driver);
		
		lp.doLogin("username", "password");
		
		String actual = driver.getTitle();
		String expected="Zero -Account Summary";
		
		Assert.assertEquals(actual, expected);
		
		
				
	}
	
	
}
