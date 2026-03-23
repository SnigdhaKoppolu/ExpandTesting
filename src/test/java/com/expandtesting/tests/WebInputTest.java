package com.expandtesting.tests;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ExpandTesting.Files.PageTitles;
import com.ExpandTesting.base.SetUp;
import com.ExpandTesting.pages.WebInputPages;
import com.ExpandTesting.utils.Waits;



public class WebInputTest extends SetUp{
	WebInputPages wi;
	Logger lg;
	
 @BeforeTest
 public void setup() {
	 initialization();
	 wi = new WebInputPages(driver);
	 lg = LogManager.getLogger(WebInputTest.class);
 }
  @Test
  public void verifyWebInputPageIsPresent()
  {   lg.info("VerifyWebInputPage test started");
	  wi.clickOnWebInputs();
	  Assert.assertEquals(driver.getTitle(), PageTitles.WebInputTitle);
  
  }
	
  @Test
  public void verifyDisplayInputs()
  {
	  Waits.staticWait(); 
	 wi.clickOnWebInputs();
	 Waits.staticWait();
	  wi.inputNumber("123"); 
	 Waits.staticWait();
	 wi.clickOnDisplayInputs();
	String str =  wi.displayOutputNumber();
	
	//System.out.println("My Number"+str);
	
	Assert.assertEquals(str, "123");
	
	
  }
  
  //need to write more testcases
 
}





