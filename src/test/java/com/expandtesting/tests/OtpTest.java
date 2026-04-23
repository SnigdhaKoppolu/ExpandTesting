package com.expandtesting.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.expandtesting.Files.PageTitles;
import com.expandtesting.base.SetUp;
import com.expandtesting.pages.OTPpage;
import com.expandtesting.utils.Waits;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class OtpTest extends SetUp {

	    OTPpage op;
	    Logger lg;

	    @BeforeMethod
	    public void setUp() {
	        initialization();
	        op = new OTPpage(driver);
	        lg = LogManager.getLogger(OtpTest.class);
	    }

	    @AfterMethod
	    public void tearDown() {
	        if (driver != null)
	            driver.quit();
	    }

	    //TC01: Valid OTP Login
	    @Epic(value = "OTP Page")
	    @Feature("OTP Login Feature")
	    @Description("Verify successful login with valid OTP code")
	    @Severity(SeverityLevel.CRITICAL)
	    @Test(priority = 1)
	    public void verifyLoginWithValidOtp() {
	        lg.info("TC01 - OTP Login with valid OTP started");
	        op.clickOnOtpPage();
	        Waits.staticWait();
	        String otp = op.getDisplayedOtp();
	        lg.info("OTP captured from landing page: " + otp);
	        
	        op.enterEmail(PageTitles.OtpEmail);
	        op.clickSendOtp();
	        Waits.staticWait();

	        op.enterOtp(otp);
	        op.clickVerifyOtp();
	        Waits.staticWait();

	        String msg = op.getFlashMessage();
	        Assert.assertEquals(msg, PageTitles.OtpSuccessMsg);
	    }

	    //TC02: Invalid OTP
	    @Epic(value = "OTP Page")
	    @Feature("OTP Login Feature")
	    @Description("Verify error message when invalid OTP is entered")
	    @Severity(SeverityLevel.NORMAL)
	    @Test(priority = 2)
	    public void verifyLoginWithInvalidOtp() {
	        lg.info("TC02 - OTP Login with invalid OTP started");

	        op.clickOnOtpPage();
	        Waits.staticWait();

	        op.enterEmail(PageTitles.OtpEmail);
	        op.clickSendOtp();
	        Waits.staticWait();

	        // Enter wrong OTP
	        op.enterOtp("000000");
	        op.clickVerifyOtp();
	        Waits.staticWait();

	        String msg = op.getErrorMessage(PageTitles.OtpInvalidMsg);
	        lg.info("Error message captured: " + msg);
	        Assert.assertEquals(msg, PageTitles.OtpInvalidMsg);
		        
	    }

	    //TC03: Empty OTP
	    @Epic(value = "OTP Page")
	    @Feature("OTP Login Feature")
	    @Description("Verify error message when OTP field is left blank")
	    @Severity(SeverityLevel.MINOR)
	    @Test(priority = 3)
	    public void verifyLoginWithEmptyOtp() {
	        lg.info("TC03 - OTP Login with empty OTP started");

	        op.clickOnOtpPage();
	        Waits.staticWait();

	        op.enterEmail(PageTitles.OtpEmail);
	        op.clickSendOtp();
	        Waits.staticWait();

	        op.enterOtp("");
	        op.clickVerifyOtp();
	        Waits.staticWait();
            
	        // Switch to the new method that uses the XPath above
	        String msg = op.getFieldErrorMessage();
	        lg.info("Validation message: " + msg);
	        Assert.assertEquals(msg, "Please enter a correct 6-digit OTP code.");
	        
	    }
	}


