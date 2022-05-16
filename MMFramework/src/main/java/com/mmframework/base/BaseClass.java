package com.mmframework.base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.mmframework.actiondriver.Action;
import com.mmframework.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static Properties prop;
	public static ExtentReports extent;
	public static ExtentTest test;
	// Declare ThreadLocal Driver
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();//public static WebDriver driver; Remember the changes that were made
//	public ExtentHtmlReporter htmlReporter;
//	public ExtentReports extent;
	@BeforeSuite(groups = {"Smoke", "Sanity", "Regression"})
	public void loadConfig() throws IOException {
		//ExtentManager.setExtent();
	//	 htmlReporter = new ExtentHtmlReporter("extent.html");

			// create ExtentReports and attach reporter(s)
		//    extent = new ExtentReports();
		//	extent.attachReporter(htmlReporter);
		DOMConfigurator.configure("log4j.xml");
		
		try {
			prop = new Properties();
			System.out.println("super constructor invoked");
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir")	+ "\\Configuration\\config.properties");
			prop.load(ip);
			System.out.println("driver: " + driver);

		} catch (FileNotFoundException e) {
			e.printStackTrace();	
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static WebDriver getDriver() {
		// Get Driver from threadLocalmap
		return driver.get();
	}

	public void launchApp(String browserName) {
	 //   String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			// Set Browser to ThreadLocalMap
			driver.set(new ChromeDriver());
		} else if (browserName.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
		} else if (browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver.set(new InternetExplorerDriver());
		}
			
		//	public static void launchApp() {
		//		WebDriverManager.chromedriver().setup();
		//		String browserName = prop.getProperty("browser");
		//
		//		if(browserName.contains("Chrome")) {
		//			driver = new ChromeDriver();
		//		} else if(browserName.contains("FireFox")) {
		//			driver = new FirefoxDriver();
		//		} else if(browserName.contains("IE")) {
		//			driver = new InternetExplorerDriver();
		//		}

		//Maximize the screen
		getDriver().manage().window().maximize();
		Action.implicitWait(getDriver(),30);
		Action.pageLoadTimeOut(getDriver(), 30);
		getDriver().get(prop.getProperty("url"));
		
//	
//		//Delete all the cookies
//		getDriver().manage().deleteAllCookies();
//		//Implicit TimeOuts
//		getDriver().manage().timeouts().implicitlyWait
//		(Integer.parseInt(prop.getProperty("implicitWait")),TimeUnit.SECONDS);
//		//PageLoad TimeOuts
//		getDriver().manage().timeouts().pageLoadTimeout
//		(Integer.parseInt(prop.getProperty("pageLoadTimeOut")),TimeUnit.SECONDS);
//		//Launching the URL
	
	}
	
	@AfterSuite
	public void afterSuite() {
	//	 extent.flush();
	}

	
}
