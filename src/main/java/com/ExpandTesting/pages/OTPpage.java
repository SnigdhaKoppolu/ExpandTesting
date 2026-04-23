package com.expandtesting.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.expandtesting.utils.ElementInteraction;
import com.expandtesting.utils.Waits;


public class OTPpage{
	       
	public OTPpage(WebDriver driver) {
		
	    PageFactory.initElements(driver, this);
	    }

	    //OTP Page element
	    @FindBy(xpath = "//a[text()='OTP: One Time Password']")
	    private WebElement OTP;
	    public void clickOnOtpPage() {
	        ElementInteraction.click(OTP);
	    }

	    //Email field
	    @FindBy(xpath="//input[@id = 'email']")
	    private WebElement emailField;
	    public void enterEmail(String email) {
	        ElementInteraction.sendkeys(emailField, email);
	    }

	    //Request OTP button
	    @FindBy(xpath = "//button[@id='btn-send-otp']")
	    private WebElement sendOtpbtn;
	    public void clickSendOtp() {
	        ElementInteraction.click(sendOtpbtn);
	    }

	    //OTP input field
	    @FindBy(xpath= "//input[@id = 'otp']")
	    private WebElement otpField;
	    public void enterOtp(String otp) {
	        ElementInteraction.sendkeys(otpField, otp);
	    }

	    //Verify OTP button
	    @FindBy(xpath = "//button[@type='submit']")
	    private WebElement verifyOtpbtn;
	    public void clickVerifyOtp() {
	        ElementInteraction.click(verifyOtpbtn);
	    }
	    
	    //Display OTP (shown on page for practice)
	    @FindBy(xpath = "//li[contains(text(), 'OTP Code')]//b")
	    private WebElement displayedOtp;
	    public String getDisplayedOtp() {
	    // Explicit wait is better than static wait here
	    Waits.waitForElementVisible(displayedOtp);
	    return displayedOtp.getText();
	    }
	 
	   // Version 1: For tests that don't need to wait for a text change (fixes your red lines)
	    @FindBy(xpath = "//p[@id='otp-message']")
	    private WebElement errorMessage;
	    public String getErrorMessage(String expectedText) {
	        // We use the ID from your screenshot here
	        Waits.waitForSpecificText(errorMessage, expectedText);
	        return errorMessage.getText();
	    }
	   
	    //successful result message , for TC01
	    @FindBy(xpath="//div[@id='flash']")
	    private WebElement flashMessage;
	    public String getFlashMessage() {
	    //Adding the explicit wait here ensures the red box has appeared
	    Waits.waitForElementVisible(flashMessage); 
	    return flashMessage.getText();
	    }
	    
	 // This captures the "Please enter a correct 6-digit OTP code." message
	    @FindBy(xpath = "//div[@class='invalid-feedback']")
	    private WebElement fieldValidationError;

	    public String getFieldErrorMessage() {
	        // We wait for this specific element to become visible after clicking Verify
	        Waits.waitForElementVisible(fieldValidationError);
	        return fieldValidationError.getText();
	    }
	    
	 // Inside OTPpage.java

	 // Use this for TC01 (The success redirect)
	 //public String getSuccessMessage() {
	     //Waits.waitForElementVisible(successMessage); // id="flash"
	     //return successMessage.getText();
	 //}

	 // Use this for TC02 and TC03 (The error on same page)
	  //  @FindBy(xpath = "//p[@id='otp-message']")
	   // private WebElement errorMessage; 
	// public String getErrorMessage(String expectedText) {
	     //Waits.waitForText(errorMessage, expectedText); // id="otp-message"
	     //return errorMessage.getText();
	 }
	


