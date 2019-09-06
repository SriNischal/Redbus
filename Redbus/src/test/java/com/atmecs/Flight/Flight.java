package com.atmecs.Flight;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Flight {
	static WebDriver driver;

//	@Test(priority = 1)
//	@Parameters("selecteddriver")

	public void setBrowser(String selecteddriver) {

		switch (selecteddriver) {
		/*
		 * case "chrome": System.setProperty("webdriver.chrome.driver",
		 * "C:\\Users\\Srinischal.Thiparani\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe"
		 * ); driver = new ChromeDriver(); driver.manage().window().maximize();
		 * 
		 * break;
		 */
		case "firefox":
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\Srinischal.Thiparani\\Downloads\\geckodriver-v0.24.0-win64 (1)\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			break;
		}
		driver.get("https://www.cleartrip.com");

	}

}