package com.atmecs.Flight;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.atmecs.orangrhr.FlightProperties;
import com.atmecs.orangrhr.Flightxls2;

public class SearchPage extends Flight {

	@Test(dataProvider = "destination", dataProviderClass = Flightxls2.class, priority = 2)
	public void selectBrowser(String[] values) throws IOException, Exception {
		try {
			Logger log=Logger.getLogger(SearchPage.class.getClass());
			PropertyConfigurator.configure("C:\\Users\\Srinischal.Thiparani\\eclipse-workspace\\Redbus\\Resources\\ConfigProperties\\log4j.properties");
			FlightProperties fp = new FlightProperties();
			driver.findElement(By.xpath("//input[@id='RoundTrip']")).click();

			driver.findElement(By.xpath(fp.readPropertiesFile("searchpage.From.txt"))).sendKeys(values[0]);
			driver.findElement(By.xpath(fp.readPropertiesFile("searchpage.From.txt"))).sendKeys(Keys.ENTER);

			driver.findElement(By.xpath(fp.readPropertiesFile("searchpage.To.txt"))).sendKeys(values[1]);
			log.info("Nischal");
			driver.findElement(By.xpath(fp.readPropertiesFile("searchpage.To.txt"))).sendKeys(Keys.ENTER);

			clickOnElement(driver, "//input[@id='DepartDate']");
			clickOnElement(driver, fp.readPropertiesFile("searchpage.Departon.txt"));
			clickOnElement(driver, "//input[@id='ReturnDate']");
			clickOnElement(driver, fp.readPropertiesFile("searchpage.ReturnDate.txt"));
			selectDropdown(fp.readPropertiesFile("searchpage.Adults.txt"), "1");
			selectDropdown(fp.readPropertiesFile("searchpage.Children.txt"), "1");
			// driver.findElement(By.xpath(fp.readPropertiesFile("searchpage.searchFlight.txt"))).click();
			ClickElement(driver, fp.readPropertiesFile("searchpage.searchFlight.txt"));
			
			
		} catch (Exception e)

		{
			e.printStackTrace();
		}
	}

	
	public void selectDropdown(String xpath, String visibleText) {
		WebElement element = driver.findElement(By.xpath(xpath));
		Select noOfpeople = new Select(element);
		noOfpeople.selectByVisibleText(visibleText);
	}

	public void clickOnElement(WebDriver driver, String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}
	
	public static void sendKeys(WebDriver driver, String xpath,String value) {
		driver.findElement(By.xpath(xpath)).sendKeys(value);
	}
	
	

	public static void ClickElement(WebDriver driver, final String xpath) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).pollingEvery(1, TimeUnit.SECONDS)
				.withTimeout(30, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		wait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				driver.findElement(By.xpath(xpath)).click();
				return true;
			}
		});
	}
}