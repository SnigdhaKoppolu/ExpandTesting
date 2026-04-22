package com.ExpandTesting.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.ExpandTesting.utils.ElementInteraction;

public class RegisterPage {
	
	    public RegisterPage(WebDriver driver) {
	        PageFactory.initElements(driver, this);
	    }

	    //Register page element
	    @FindBy(xpath = "//a[text()='Test Register Page']")
	    private WebElement RegisterPage;

	    public void clickOnRegisterPage() {
	        ElementInteraction.click(RegisterPage);
	    }

	    //username 
	    @FindBy(xpath="//input[@id = 'username']")
	    private WebElement username;

	    public void enterUsername(String user) {
	        ElementInteraction.sendkeys(username, user);
	    }

	    //password 
	    @FindBy(xpath="//input[@id = 'password']")
	    private WebElement password;

	    public void enterPassword(String pass) {
	        ElementInteraction.sendkeys(password, pass);
	    }

	    //confirm password
	    @FindBy(xpath="//input[@id = 'confirmPassword']")
	    private WebElement confirmpassword;

	    public void enterConfirmPassword(String pass) {
	        ElementInteraction.sendkeys(confirmpassword, pass);
	    }

	    //register button
	    @FindBy(xpath = "//button[@type='submit']")
	    private WebElement register;

	    public void clickRegister() {
	        ElementInteraction.click(register);
	    }

	    //result message
	    @FindBy(xpath = "//div[@id='flash']")
	    private WebElement flashMessage;

	    public String getFlashMessage() {
	        return flashMessage.getText();
	    }
	}


