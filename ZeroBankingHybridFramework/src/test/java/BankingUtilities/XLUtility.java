package BankingUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtility {
	
	public FileInputStream fis;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	String path= null;
	XLUtility (String path)
	{this.path= path;}
	public int getRowCount(String sheetName) throws IOException
	{
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet= workbook.getSheet(sheetName);
		int rowcount=sheet.getLastRowNum();
		//workbook.close();
		fis.close();
		return rowcount;}
	public int getCellCount(String sheetName, int rownum) throws IOException {
		fis= new FileInputStream(path);
		workbook= new XSSFWorkbook(fis);
		sheet= workbook.getSheet(sheetName);
		 row= sheet.getRow(rownum);
		int cellcount= row.getLastCellNum();
		//workbook.close();
		fis.close();
		return cellcount;
		
	}
	public String getCellData(String sheetName, int rownum, int cellnum) throws IOException
	{
		fis = new FileInputStream(path) ;
		workbook= new XSSFWorkbook(fis);
		sheet= workbook.getSheet(sheetName);
		row =sheet.getRow(rownum);
		cell= row.getCell(cellnum);
		String data=cell.getStringCellValue();
	//	workbook.close();
		fis.close();
					return data;	
			
		}
			
	}
		
		
	
	
	
	


