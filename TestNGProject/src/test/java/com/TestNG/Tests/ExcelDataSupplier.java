package com.TestNG.Tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelDataSupplier {
@DataProvider(name="loginTestData ")
	public String[][] getData() throws Exception  {
		File excelFile= new File("./src/test/resources/TestExcel.xlsx");
		System.out.println(excelFile.exists());
        FileInputStream fis= new FileInputStream(excelFile);
        XSSFWorkbook workbook= new  XSSFWorkbook(fis);
        XSSFSheet sheet= workbook.getSheet("Sheet1");
        int noOfRows=sheet.getPhysicalNumberOfRows();
        int noOFColumns= sheet.getRow(0).getLastCellNum();
        System.out.println(sheet.getLastRowNum());
        String[][] data = new String[noOfRows-1][noOFColumns];
        for (int i = 0; i < noOfRows-1; i++) {
        	for(int j=0;j<noOFColumns;j++) {
        		DataFormatter df = new DataFormatter();
        		data[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));
        		//System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
        		
        	}
		}
        workbook.close();
        fis.close();
        return data;
        //for(String[]dataArr:data) {
        //System.out.println(Arrays.toString(dataArr));
	}}
        
        
        
        
	


