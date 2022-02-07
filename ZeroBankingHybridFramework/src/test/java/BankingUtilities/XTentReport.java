package BankingUtilities;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class XTentReport {
	public static ExtentReports report;
	public static ExtentReports  getReport() {
		
		//report = new ExtentReports(System.getProperty("user.dir")+"\\target\\surefire-reports\\old\\myReport18.html",false,DisplayOrder.NEWEST_FIRST);
		report = new ExtentReports(System.getProperty("user.dir")+"\\test-output\\myReport18.html",false,DisplayOrder.NEWEST_FIRST);
		report.addSystemInfo("QA", "Saritha");
		
		report.addSystemInfo("QA", "Saritha");
		report.addSystemInfo("Host", "LocalHost");
		report.addSystemInfo("OS", "Windows10");
		report.addSystemInfo("Browser", "Chrome");
		report.addSystemInfo("selenium", "3.14");
		return report;
	}

}














//report = new ExtentReports(System.getProperty("user.dir")+"\\test-output\\myReport18.html",false,DisplayOrder.NEWEST_FIRST);
		//String path="C:\\Users\\Aila\\eclipse-workspace\\ZeroBankingHybridFramework\\test-output\\myReport14.html";
		//report= new ExtentReports(path, false);

//String path ="C:\\Users\\Aila\\eclipse-workspace\\ZeroBankingHybridFramework\\test-output\\myReport10.html";
		//   path1= new ExtentReports(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\extent.html",true,DisplayOrder.OLDEST_FIRST);
		//extent.loadConfig(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\extentconfig\\ReportsConfig.xml"));



