package com.expandtesting.tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ExpandTesting.Files.PageTitles;
import com.ExpandTesting.base.SetUp;
import com.ExpandTesting.pages.LoginPage;
import com.ExpandTesting.utils.Waits;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class LoginTest extends SetUp {

	LoginPage lp;

	@BeforeTest
	public void setUp() {
		initialization();
		lp = new LoginPage(driver);
	}

	@AfterTest
	public void teardown() {
		if (driver != null)
			driver.close();
	}

	@Epic(value = "Login Page")
	@Feature("Login Feature")
	@Description("verify the login functionality with invalid credentials")
	@Severity(SeverityLevel.CRITICAL)

	@Test(priority = 1)
	public void verifyLoginFunWithValidCredentials() {
	    // 1. Navigate to the actual login form first
	    lp.ClickOnLoginPage(); 
	    
	    // 2. Add a wait to ensure the page has transitioned
	    Waits.staticWait(); 
	    
	    // 3. Now enter credentials
	    lp.enterUsername("practice");
	    lp.enterPassword("SuperSecretPassword!");
	    lp.clickOnLogin();
	    
	    String str = lp.getLoginMessage();
	    System.out.println("Login message : " + str);
	    Assert.assertEquals(str, PageTitles.LogiMessage);
	}
	@Test(priority = 2, enabled = false)
	public void verifyLoginFunWithInValidCredentials() {
		lp.ClickOnLoginPage();
		Waits.staticWait();
		lp.enterUsername("practice");
		lp.enterPassword("SuperSecretPassword!");
		lp.clickOnLogin();
		Waits.staticWait();
		
		String str = lp.getLoginMessage();

		System.out.println("Login message : " + str);
		Assert.assertNotEquals(lp.getLoginMessage(), PageTitles.LogiMessage);
	}
	
	

}
