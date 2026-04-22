package com.expandtesting.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ExpandTesting.Files.PageTitles;
import com.ExpandTesting.base.SetUp;
import com.ExpandTesting.pages.RegisterPage;
import com.ExpandTesting.utils.Waits;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class RegisterPageTest extends SetUp {
	
	    RegisterPage rp;
	    Logger lg;

	    @BeforeMethod
	    public void setUp() {
	        initialization();
	        rp = new RegisterPage(driver);
	        lg = LogManager.getLogger(RegisterPageTest.class);
	    }
	    @AfterMethod
	    public void tearDown() {
	        if (driver != null)
	            driver.quit();
	    }
	    
	    //TC01: Successful Registration 
	    @Epic(value = "Register Page")
	    @Feature("Register Feature")
	    @Description("Verify successful registration with valid credentials")
	    @Severity(SeverityLevel.CRITICAL)
	    @Test(priority = 1)
	    public void verifySuccessfulRegistration() {
	        lg.info("TC01 - Successful Registration started");
	        rp.clickOnRegisterPage();
	        Waits.staticWait();
	        //appending timestamp to ensure a unique username for each time  test run
	        String uniqueUser = "testuser-" + System.currentTimeMillis();
	        rp.enterUsername(uniqueUser);
	        rp.enterPassword("Password@123");
	        rp.enterConfirmPassword("Password@123");
	        rp.clickRegister();
	        Waits.staticWait();

	        String msg = rp.getFlashMessage();
	        lg.info("Flash message: " + msg);
	        Assert.assertEquals(msg, PageTitles.RegisterSuccess);
	    }
	   

	    //TC02: Empty Username
	    @Epic(value = "Register Page")
	    @Feature("Register Feature")
	    @Description("Verify error when username is left blank")
	    @Severity(SeverityLevel.NORMAL)
	    @Test(priority = 2)
	    public void verifyRegisterWithEmptyUsername() {
	        lg.info("TC02 - Register with empty username started");
	        rp.clickOnRegisterPage();
	        Waits.staticWait();
	        rp.enterUsername("");
	        rp.enterPassword("Password@123");
	        rp.enterConfirmPassword("Password@123");
	        rp.clickRegister();
	        Waits.staticWait();

	        String msg = rp.getFlashMessage();
	        lg.info("Flash message: " + msg);
	        Assert.assertEquals(msg, PageTitles.RegisterErrAllFields);
	    }

	    //TC03: Empty Password
	    @Epic(value = "Register Page")
	    @Feature("Register Feature")
	    @Description("Verify error when password is left blank")
	    @Severity(SeverityLevel.NORMAL)
	    @Test(priority = 3)
	    public void verifyRegisterWithEmptyPassword() {
	        lg.info("TC03 - Register with empty password started");

	        rp.clickOnRegisterPage();
	        Waits.staticWait();
	        rp.enterUsername("testuser123");
	        rp.enterPassword("");
	        rp.enterConfirmPassword("Password@123");
	        rp.clickRegister();
            Waits.staticWait();

	        String msg = rp.getFlashMessage();
	        lg.info("Flash message: " + msg);
	        Assert.assertEquals(msg, PageTitles.RegisterErrAllFields);
	    }

	    //TC04: Password Mismatch 
	    @Epic(value = "Register Page")
	    @Feature("Register Feature")
	    @Description("Verify error when passwords do not match")
	    @Severity(SeverityLevel.NORMAL)
	    @Test(priority = 4)
	    public void verifyRegisterWithPasswordMismatch() {
	        lg.info("TC04 - Register with password mismatch started");
	        rp.clickOnRegisterPage();
	        Waits.staticWait();
	        rp.enterUsername("testuser123");
	        rp.enterPassword("Password@123");
	        rp.enterConfirmPassword("WrongPassword@999");
	        rp.clickRegister();
	        Waits.staticWait();

	        String msg = rp.getFlashMessage();
	        lg.info("Flash message: " + msg);
	        Assert.assertEquals(msg, PageTitles.RegisterErrPwdMismatch);
	    }
	}


