package com.TestNG.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ObjectArray {
	@Test(dataProvider="dp1")
	public void TestLogin(Object[] s) {
		for(int i=0;i<s.length;i++)
		System.out.println(s[i]);{
			
			}
		System.out.println(">>>>>");
	}
	//jagged array when the column in each array is not equal , as well we want multiple datatypeswe canuse object array
	@DataProvider(name="dp1" )
	public Object[][] LoginData() {
		Object[][] data = new Object[][]{
		
		{"sari",12, "selenium",245},
		{"sari",12},
		{"sari",12, "selenium",122333}
		
};
		return data;
}}