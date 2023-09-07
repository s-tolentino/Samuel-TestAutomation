package com.core;

import org.openqa.selenium.WebDriver;

public class DriverHandler{
	public static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<WebDriver>();

	public static WebDriver getDriver() {
		return threadLocalDriver.get();
	}
	
	public static void openUrl(String url) {
        getDriver().get(url);
    }

    public static void refreshPage() {
        getDriver().navigate().refresh();
    }
}
