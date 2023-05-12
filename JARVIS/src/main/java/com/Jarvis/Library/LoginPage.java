package com.Jarvis.Library;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import bsh.This;

public class LoginPage {

	@FindBy(xpath="//button[text()='Login with ']")private WebElement ClickonLink;
//	@FindBy(xpath="//label[text()='Email']")private WebElement Email;
	@FindBy(xpath="//*[@id=\"mui-2\"]")private WebElement Email;
	@FindBy(xpath="//*[@id=\"mui-6\"]")private WebElement Password;	
	@FindBy(xpath="//button[text()='Login']")private WebElement ClickOnLoginButton;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void ClickOnLoginWithPasswordLink()
	{
		ClickonLink.click();
	}
	public void EnterEmailId(String email) throws InterruptedException
	{
		
		Email.sendKeys(email);
//		Email.sendKeys(UtilityClass.generateRanodmEmail());
		Thread.sleep(3000);
	}
	public void Enterpassword(String password)
	{
		Password.sendKeys(password);
	}
	public void ClickOnLogin() throws InterruptedException
	{
		ClickOnLoginButton.click();
		Thread.sleep(2000);
	}
}
