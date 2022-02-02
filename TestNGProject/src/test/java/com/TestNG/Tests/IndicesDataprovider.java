package com.TestNG.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class IndicesDataprovider {
	//used when to monitor or debug the failed tc , eg 2tc failed out of 100 
	@Test(dataProvider="dp1")
	public void TestLogin(String s) {
		
	}
	@DataProvider(name="dp1", indices= {0,1} )
	public String[] LoginData() {
		String[] data = new String[]{
		
		"sari",
		"naveen",
		"kirthu",
		"viggu"
		};return data;
	}
}
