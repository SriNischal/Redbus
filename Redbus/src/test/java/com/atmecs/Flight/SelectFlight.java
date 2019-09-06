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

public class SelectFlight extends SearchPage {
	//@Test(priority=3)
	public void select() throws IOException, InterruptedException {
        FlightProperties fp = new FlightProperties();
		
		/*
		 * WebDriverWait wait = new WebDriverWait(driver,20); WebElement Book; Book=
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(fp.
		 * readPropertiesFile("selectflight.book.txt")))); Book.click();
		 */
		 ClickElement(driver, fp.readPropertiesFile("selectflight.book.txt"));

}
    public static void ClickElement(WebDriver driver, final String xpath) {
    	FluentWait<WebDriver> wait= new FluentWait<WebDriver>(driver).pollingEvery(1, TimeUnit.SECONDS)
    			.withTimeout(30, TimeUnit.SECONDS).ignoring(ElementNotInteractableException.class);
    	wait.until(new Function<WebDriver, Boolean>() {
    		public Boolean apply(WebDriver driver) {
    			driver.findElement(By.xpath(xpath)).click();
    			return true;
    		}
		});
    }
}
