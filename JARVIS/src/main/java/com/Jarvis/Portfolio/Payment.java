package com.Jarvis.Portfolio;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Payment {

	@FindBy(xpath ="//button[@id='mui-4']")private WebElement Pay;
	@FindBy(xpath ="//button[text()='I agree']")private WebElement IAgree;

	public Payment(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void ClickoPayButton()
	{
		Pay.click();
	}
	public void ClickOnIAgree()
	{
		IAgree.click();
	}
}
