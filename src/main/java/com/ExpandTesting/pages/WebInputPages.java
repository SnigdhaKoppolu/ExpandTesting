package com.ExpandTesting.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ExpandTesting.utils.ElementInteraction;
import com.ExpandTesting.utils.Waits;

public class WebInputPages {
	
	public WebInputPages(WebDriver driver)
	{
	   PageFactory.initElements(driver, this);	
	}
	//1.webelements
	//2.methods
	//3.constructor
	
	@FindBy(xpath="//a[text()='Web inputs']")
	private WebElement Webinputs;
	
	public void clickOnWebInputs() 
	{   
		ElementInteraction.click(Webinputs,10);	
	}
      
	//Display Inputs
	@FindBy(xpath="//button[text()='Display Inputs']")
	private WebElement displayInputs;
	public void clickOnDisplayInputs()
	{
		ElementInteraction.click(displayInputs);
		
	}
	
	@FindBy(xpath="//strong[@id='output-number']")
	private WebElement outputNum;
	public String displayOutputNumber()
	{
		return ElementInteraction.getText(outputNum);
		
	}
	
	
	@FindBy(xpath="//input[@id='input-number']")
	private WebElement inputnum;
	public void inputNumber(String num)
	{
		ElementInteraction.sendkeys(inputnum, num);
	}
	
	
	
}
