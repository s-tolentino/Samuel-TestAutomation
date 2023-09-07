package com.core;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class JSExecutor extends DriverHandler{
	
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	
	public void click(By element) {
		js.executeScript("arguments[0].click();", element);
	}

	public void scrollToElement(By element) {
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void sendKeys(By element, String text) {
		js.executeScript("arguments[0].value=’" + text +"’;", element);
	}
}
