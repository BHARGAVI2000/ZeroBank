package itest;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class customerlistener implements ITestListener{



public void onTestStart(ITestResult result) {
	// TODO Auto-generated method stub
	
}

public void onTestSuccess(ITestResult result) {
	// TODO Auto-generated method stub
	System.out.println("THE TEST PASSED");

}

public void onTestFailure(ITestResult result) {
	// TODO Auto-generated method stub
	System.out.println("THE TEST FAILED");

}

public void onTestSkipped(ITestResult result) {
	// TODO Auto-generated method stub
	
}

public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	// TODO Auto-generated method stub
	
}

public void onStart(ITestContext context) {
	// TODO Auto-generated method stub
	
}

public void onFinish(ITestContext context) {
	// TODO Auto-generated method stub
	
}}
