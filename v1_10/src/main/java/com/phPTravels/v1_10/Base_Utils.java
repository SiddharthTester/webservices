package com.phPTravels.v1_10;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;

public class Base_Utils {

	public static WebDriver d;
	public static void selectBrowser(String browser) {
		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.firefox.marionate", "D:\\workspace\\v1_10\\resources\\geckodriver.exe");
			d = new FirefoxDriver();
		}
		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\workspace\\v1_10\\resources\\chromedriver.exe");
			d = new ChromeDriver();
		}

		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		d.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		d.manage().deleteAllCookies();
	}

}
