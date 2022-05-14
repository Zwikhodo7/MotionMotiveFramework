/**
 * 
 */
package com.mmframework.extentReports;
import java.util.HashMap;
import java.util.Map;

import com.relevantcodes.extentreports.ExtentReports;


/**
 * @author znemadodzi
 *
 */

public class ExtentManager
{
	static Map extentTestMap = new HashMap();
	private static ExtentReports extent;

	public synchronized static ExtentReports getReporter()
	{
		if(extent == null)
		{
			//Set HTML reporting file location
			String workingDir = System.getProperty("user.dir");


			String operSys = System.getProperty("os.name").toLowerCase();
			if (operSys.contains("win"))
			{
				extent = new ExtentReports(workingDir+"\\ExtentReports\\ExtentReportResults.html", true);
			}
			else if (operSys.contains("nix") || operSys.contains("nux")|| operSys.contains("aix"))
			{

			}
			else if (operSys.contains("mac"))
			{
				extent = new ExtentReports(workingDir+"/ExtentReports/ExtentReportResults.html", true);
			}
		}
		return extent;
	}
}