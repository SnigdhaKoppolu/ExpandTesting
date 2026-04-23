package com.expandtesting.tests;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.expandtesting.Files.PageTitles;
import com.expandtesting.utils.Waits;
import com.expandtesting.base.SetUp;
import com.expandtesting.pages.WebInputPages;



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
	
  @AfterTest
  public void tearDown()
  {
	  if(driver!=null)
		  driver.quit();
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





