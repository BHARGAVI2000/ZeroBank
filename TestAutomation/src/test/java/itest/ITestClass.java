package itest;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ITestClass {
	
	
	
	
	@Test
	public void testcase1() {
		System.out.println("Testcase 1  running");
		Assert.assertTrue(true);
	}
	@Test
	public void testcase2() {
		System.out.println("Testcase 2  running");
		Assert.assertTrue(false);
	}
	
	
	@AfterMethod
	public void tearDown(ITestResult testResult) {
		
		if(testResult.getStatus()==ITestResult.FAILURE) {
		System.out.println("This is a Failed Test: 	" +testResult.getMethod().getMethodName());
	}
		if(testResult.getStatus()==ITestResult.SUCCESS) {
			System.out.println("Ihis is Passed Test: 	" +testResult.getName());
		}
		
 } 
	

}



