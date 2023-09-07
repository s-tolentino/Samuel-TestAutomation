package com.core;

public class Constants {
	static String extentReportPath = System.getProperty("user.dir").replace("\\", "/")
			+ "/target/extentReport/ExtentReport.html";
	static String screenshotPath = System.getProperty("user.dir").replace("\\", "/") + "/target/screenshots/";
	int timeout = 30;
}
