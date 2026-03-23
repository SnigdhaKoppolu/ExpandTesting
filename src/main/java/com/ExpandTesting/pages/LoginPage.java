package com.ExpandTesting.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ExpandTesting.utils.ElementInteraction;

public class LoginPage {
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//login page element
	@FindBy(xpath="//a[text()='Test Login Page']")
	private WebElement LoginPage;
	public void ClickOnLoginPage()
	{
		ElementInteraction.click(LoginPage);
	}
	
	
	//username
	@FindBy(xpath="//input[@id='username']")
	private WebElement username;
	public void enterUsername(String user)
	{
		ElementInteraction.sendkeys(username, user);
	}
	
	//password
	@FindBy(xpath="//input[@id='password']")
	private WebElement password;
	public void enterPassword(String pass)
	{
		ElementInteraction.sendkeys(password, pass);
	}
	
	@FindBy(xpath="//button[@id='submit-login']")
	private WebElement login;
	public void clickOnLogin()
	{
		ElementInteraction.click(login);
	}
	
	@FindBy(xpath="//div[@id='flash']/b")
	private WebElement loginMessage;
	public String getLoginMessage()
	{
		return loginMessage.getText();
	}
	
	
	
	
	
}
