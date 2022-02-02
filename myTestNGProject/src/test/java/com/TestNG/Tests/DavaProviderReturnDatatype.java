package com.TestNG.Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DavaProviderReturnDatatype {

	@Test(dataProvider="dp1")
	public void TestLogin(Object i) {
		System.out.println(i);
	}
	
	@DataProvider(name="dp1")
	public Object[] LoginData() {
		Object[] data = new Object[4];
		
		data[0]= "1";
		data[1]= "sari";
		data[2]= "20.0";
		data[3]= "s";
		
		return data;
	}
	
	
	 

			
	
}
