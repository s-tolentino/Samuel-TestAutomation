package com.core;

import java.io.File;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;

public class BaseTest extends DriverHandler{

	public static WebDriver driverConfig;
	
	@BeforeMethod
	public void beforeMethod(Method method, @Optional("chrome") String browser,  @Optional("no") String runAsHeadless) {
		try {
			driverConfig = BrowserFactory.browserSetup(browser, runAsHeadless);
			threadLocalDriver.set(driverConfig);
		}catch(Exception e) {
			
		}   
	}
	
	@AfterMethod
    public void tearDown(){
        getDriver().quit();
        threadLocalDriver.remove();
	}
	
	public static void takeScreenShot(String fileName) {
		Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		File srcFile=((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		try {
            String name = fileName + "_" + dateTimeFormat.format(calendar.getTime()) + ".png";
            FileUtils.copyFile(srcFile, new File(Constants.screenshotPath + name));
            //getExtentTest().addScreenCaptureFromPath(Constants.screenshotPath + name);
        } catch (Exception e) {
            //Log
        }
	}
}
