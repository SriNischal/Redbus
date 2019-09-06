package com.atmecs.Flight;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import com.atmecs.orangrhr.FlightProperties;
import com.atmecs.orangrhr.Flightxls2;
public class Bookingsteps extends SelectFlight{
	//@Test(dataProvider = "destination", dataProviderClass = Flightxls2.class,priority=4)
	public void booking(String[] values) throws IOException, InterruptedException {
			FlightProperties fp = new FlightProperties();
			Thread.sleep(5000);
		driver.findElement(By.xpath(fp.readPropertiesFile("Iternitystep.ContinueDetails.txt"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(fp.readPropertiesFile("Emailaddressstep.EmailId.txt"))).sendKeys(values[2]);
		driver.findElement(By.xpath(fp.readPropertiesFile("Emailaddressstep.Continue.txt"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(fp.readPropertiesFile("travellers.Title.txt"))).click();
		driver.findElement(By.xpath(fp.readPropertiesFile("travellers.FirstName.txt"))).sendKeys(values[3]);
		driver.findElement(By.xpath(fp.readPropertiesFile("travellers.LastName.txt"))).sendKeys(values[4]);
		driver.findElement(By.xpath(fp.readPropertiesFile("locators.textarea.Title"))).click();
		driver.findElement(By.xpath(fp.readPropertiesFile("locators.textarea.FirstName"))).sendKeys(values[5]);
		driver.findElement(By.xpath(fp.readPropertiesFile("locators.textarea.LastName"))).sendKeys(values[6]);
		driver.findElement(By.xpath(fp.readPropertiesFile("travellers.Day.txt"))).click();
		driver.findElement(By.xpath(fp.readPropertiesFile("travellers.Month.txt"))).click();
		driver.findElement(By.xpath(fp.readPropertiesFile("travellers.year.txt"))).click();
		driver.findElement(By.xpath(fp.readPropertiesFile("travellers.Mobileno.txt"))).sendKeys(values[7]);
		driver.findElement(By.xpath(fp.readPropertiesFile("travellers.Continue.txt"))).click();
	}
}
