package com.ExpandTesting.utils;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ExpandTesting.base.SetUp;
import com.ExpandTesting.timeouts.TimeUnits;

public class Waits extends SetUp {

	public static WebDriverWait wb;

	/**
	 * @Description: this element will return false if the element is not clickable
	 *               else it will return true
	 */
	public static boolean isElementClickable(WebElement ele) {
		wb = new WebDriverWait(driver, Duration.ofSeconds(TimeUnits.ELE_TIME));
		try {

			wb.until(ExpectedConditions.elementToBeClickable(ele));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Element is not Clickable");
			return false;
		}
	}

	
	/**
	 * @Description: this element will return false if the element is not clickable
	 *               else it will return true
	 *             
      */
	public static boolean isElementClickable(WebElement ele, int sec) {
		wb = new WebDriverWait(driver, Duration.ofSeconds(sec));
		// wb.until(ExpectedConditions.elementToBeClickable(ele));
		wb = new WebDriverWait(driver, Duration.ofSeconds(TimeUnits.ELE_TIME));
		try {

			wb.until(ExpectedConditions.elementToBeClickable(ele));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Element is not Clickable");
			return false;
		}
	}

	
	// static wait for 5 seconds
	public static void staticWait() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void waitForSpecificText(WebElement element, String text) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    // This specifically waits for the old text to change to the new text
	    wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}
	
	public static void waitForText(WebElement element, String text) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}
	
	
	public static void waitForElementVisible(WebElement element) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(element));
	    }
}
