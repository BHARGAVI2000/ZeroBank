package itest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(itest.customerlistener.class)


public class test1 {
	
	@Test
	public void login() {
		
	Assert.assertTrue(false);
		
	}
}