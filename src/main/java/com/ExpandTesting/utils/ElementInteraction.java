package com.ExpandTesting.utils;

import org.openqa.selenium.WebElement;

public class ElementInteraction {

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

	// sendkeys
	public static void sendkeys(WebElement ele, String data) {
		ele.sendKeys(data);
	}

	// getText
	public static String getText(WebElement ele) {
		return ele.getText();
	}

}
