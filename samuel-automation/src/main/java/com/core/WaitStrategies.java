package com.core;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitStrategies extends DriverHandler{

	public void visibilityOfElementLocated(By element, int timeout) {
		try {
			new WebDriverWait(getDriver(), Duration.ofSeconds(timeout)).until(ExpectedConditions.visibilityOfElementLocated(element));
		} catch (Exception e) {
			//log
		}
	}

	public void invisibilityOfElementLocated(By element, int timeout) {
		try {
			new WebDriverWait(getDriver(), Duration.ofSeconds(timeout)).until(ExpectedConditions.invisibilityOfElementLocated(element));
		} catch (Exception e) {
			//log
		}

	}

	public void presenceOfElementLocated(By element, int timeout) {
		try {
			new WebDriverWait(getDriver(), Duration.ofSeconds(timeout)).until(ExpectedConditions.presenceOfElementLocated(element));
		} catch (Exception e) {
			//log
		}

	}
	
	public void waitForElementToBeClickable(By element, int timeout) {
		try {
			new WebDriverWait(getDriver(), Duration.ofSeconds(timeout)).until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			//log
		}
	}	

}
