package com.core;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory extends DriverHandler{

	public static WebDriver browserSetup(String browser, String useHeadless) {
		
		WebDriver webDriver = null;

		switch (browser.toLowerCase()) {

		case "chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions cOptions = new ChromeOptions();
			if (useHeadless.equalsIgnoreCase("yes")) {
				cOptions.addArguments("--headless");
				cOptions.addArguments("--window-size=1325,744");
			} else {
				webDriver = new ChromeDriver(cOptions);
			}
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions fCptions = new FirefoxOptions();
			if (useHeadless.equalsIgnoreCase("yes")) {
				fCptions.addArguments("--headless");
				fCptions.addArguments("--window-size=1325,744");
			} else {
				webDriver = new FirefoxDriver(fCptions);
			}
			break;

		case "ie":
			WebDriverManager.iedriver().setup();
			InternetExplorerOptions ieCptions = new InternetExplorerOptions();
			if (useHeadless.equalsIgnoreCase("yes")) {
				// IECptions Assignment
			} else {
				webDriver = new InternetExplorerDriver(ieCptions);
			}
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			EdgeOptions eCptions = new EdgeOptions();
			if (useHeadless.equalsIgnoreCase("yes")) {
				eCptions.addArguments("--headless");
				eCptions.addArguments("--window-size=1325,744");
			} else {
				webDriver = new EdgeDriver(eCptions) ;
			}
			break;

		default:
			throw new IllegalArgumentException("Browser not found: " + browser);
		}
		
		webDriver.manage().window().maximize();
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		return webDriver;
//      Log.setTestStep("PASSED", "Start automation test in " + browser + " browser");
	}

}
