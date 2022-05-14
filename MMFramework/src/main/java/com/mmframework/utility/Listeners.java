/**
 * 
 */
package com.mmframework.utility;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.mmframework.base.BaseClass;

/**
 * @author znemadodzi
 *
 */
public class Listeners implements ITestListener{
	
	private static ExtentReports extent = ExtentManager.setExtent();
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	 public void onTestStart(ITestResult result) {
		 ExtentTest test = extent.createTest(result.getTestClass().getName()+ "::" + result.getMethod().getMethodName());
		extentTest.set(test);
		 System.out.println("****Test started : "+result.getName());
		  }
	 
	 public void onTestSuccess(ITestResult result) {
		  System.out.println("****Test is successful : "+result.getName());
		  String logText = "<b>Test Method" + result.getMethod().getMethodName() + " Successful</b>";
		  Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		  extentTest.get().log(Status.PASS, m);
		  }
	 
	 public void onTestFailure(ITestResult result) {
		  System.out.println("****Test failed : "+result.getName());
		  }
	 
	 public void onTestSkipped(ITestResult result) {
		  System.out.println("****Test skipped : "+result.getName());
		  String logText = "<b>Test Method" + result.getMethod().getMethodName() + " Skipped</b>";
		  Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		  extentTest.get().log(Status.SKIP, m);
		  }

	 public void onFinish(ITestResult context) {
		  System.out.println("****Tests completed : "+context.getName());
		  }
}
