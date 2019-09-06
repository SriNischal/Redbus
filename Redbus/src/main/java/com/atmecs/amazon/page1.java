package com.atmecs.amazon;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class page1 {
	WebDriver driver;
//@Test
	public void page() {
	System.setProperty("webdriver.gecko.driver",
			"C:\\Users\\Srinischal.Thiparani\\Downloads\\geckodriver-v0.24.0-win64 (1)\\geckodriver.exe");
	driver = new FirefoxDriver();
	driver.get("https://www.swiggy.com/");
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//a[@class=\"x4bK8\"]")).click();
	driver.findElement(By.xpath("//input[@id=\"mobile\"]")).sendKeys("9393818194");
	driver.findElement(By.xpath("//a[@class=\"a-ayg\"]")).click();
	driver.findElement(By.xpath("//input[@id=\"otp\"]")).sendKeys("976364");

	
}
}
