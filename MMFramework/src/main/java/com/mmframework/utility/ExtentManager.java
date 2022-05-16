/**
 * 
 */
package com.mmframework.utility;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;//1
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme; 

/**
 * @author znemadodzi
 *
 */
public class ExtentManager {
	public static ExtentReports setupExtentReport() {
		
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
		Date date = new Date();
		String actualDate =format.format(date);
		
		String reportPath = System.getProperty("user.dir")+"/reports/ExecutionReport_"+actualDate+".html";
		
		ExtentSparkReporter sparkReport = new ExtentSparkReporter(reportPath);
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(sparkReport);
		
		sparkReport.config().setDocumentTitle("DocumentTitle");
		sparkReport.config().setTheme(Theme.DARK);
		sparkReport.config().setReportName("ReportName");
		
		return extent;
		
	}
	//	private static ExtentReports extent;//2
	//
	//	public static ExtentReports setExtent() {
	//		String fileName = getReportName();
	//		String directory = System.getProperty("user.dir") + "/reports/";
	//		new File(directory).mkdirs();
	//		String path = directory + fileName;
	//		ExtentHtmlReporter htmlReporter= new ExtentHtmlReporter(path);
	//		//htmlReporter= new ExtentHtmlReporter("./test-output/ExtentReport/extent.html");
	//		//htmlReporter= new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/"+"MyReport.html");
	//		//htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
	//		htmlReporter.config().setEncoding("utf-8");
	//		htmlReporter.config().setDocumentTitle("Automation Test Report");
	//		htmlReporter.config().setReportName("OrangeHRM Test Automation Report");
	//		htmlReporter .config().setTheme(Theme.DARK);
	//
	//		extent = new ExtentReports();
	//		extent.setSystemInfo("HostName", "MyHost");
	//		extent.setSystemInfo("ProjectName", "MMFramework");
	//		extent.setSystemInfo("Tester", "znemadodzi");
	//		extent.setSystemInfo("OS", "Win10");
	//		extent.setSystemInfo("Browser", "Chrome");
	//		extent.attachReporter(htmlReporter);
	//
	//
	//		return extent;
	//	}
	//
	//	public static String getReportName(){
	//		Date d = new Date();
	//		String fileName = "Automation Report" + "_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";
	//		return fileName;
	//	}
	//
	//
	//	public static void endReport() {
	//		extent.flush();
	//	}

}

