package com.core;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class BasePage extends BaseTest {

	Actions actions = new Actions(getDriver());
	JSExecutor js = new JSExecutor();

	public WebElement findWebElement(By element) {
		WebElement webElement = null;
		try {	
			Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver()).withTimeout(Duration.ofSeconds(30))
					.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
			
			webElement = wait.until(ExpectedConditions.presenceOfElementLocated(element));
		} catch (Exception e) {
			// log
		}
		return webElement;
	}

	public void click(By element, String name) {
		try {
			findWebElement(element).click();
			// log
		} catch (Exception e) {
			try {
				js.scrollToElement(element);
				js.click(element);
				// log
			} catch (Exception f) {
				// log
			}
		}
	}

	public void hover(By element) {
		actions.moveToElement(findWebElement(element)).perform();
	}

	public void type(By element, String text) {
		try {
			findWebElement(element).sendKeys(text);
			// log
		} catch (Exception e) {
			try {
				js.scrollToElement(element);
				js.sendKeys(element, text);
				// log
			} catch (Exception f) {
				// log
			}
		}
	}

	public String getText(By element) {
		return findWebElement(element).getText();
	}
}
