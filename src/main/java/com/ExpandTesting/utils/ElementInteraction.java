package com.ExpandTesting.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.ExpandTesting.base.SetUp;

public class ElementInteraction extends SetUp{
	

	public static void click(WebElement ele)

	{
		if (Waits.isElementClickable(ele) == true) {
			ele.click();
		}
	}

	public static void click(WebElement ele, int sec)

	{
		if (Waits.isElementClickable(ele) == true) {
			ele.click();

		}
	}
	
	public static void clickUsingJS(WebElement element) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click();", element);
	}
	
	// sendkeys
	public static void sendkeys(WebElement ele, String data) {
		ele.sendKeys(data);
	}

	// getText
	public static String getText(WebElement ele) {
		return ele.getText();
	}

}
