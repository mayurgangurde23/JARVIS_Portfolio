package com.Jarvis.Portfolio;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InvestmentPreference {
	@FindBy(xpath ="//button[text()='3 Yr']")private WebElement SelectYear;	
	@FindBy(xpath ="//div[text()='Pure equity strategy']")private WebElement SelectStrategy;	
	@FindBy(xpath ="//button[text()='Submit my strategy']")private WebElement SubmitStrategy;
	@FindBy(xpath ="//button[text()='₹1,00,000']")private WebElement Amount;
	@FindBy(xpath ="//div[text()='Jarvis Portfolio Plus']")private WebElement Plan;
	@FindBy(xpath ="//button[text()='Continue']")private WebElement ContinueButton;	
	@FindBy(xpath ="(//button[text()='Confirm'])[1]")private WebElement ConfirmPreference;	
	@FindBy(xpath ="//div[text()='Unlock now']")private WebElement UnlockNow;	
	
	public InvestmentPreference(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void selectYear()
	{
		SelectYear.click();
	}
	public void StrategySelection()
	{
		SelectStrategy.click();
	}
	public void SubmitStrategy()
	{
		SubmitStrategy.click();
	}
	public void SelectAmount()
	{
		Amount.click();
	}
	public void SelectPlan()
	{
		Plan.click();
	}
	public void ClickOnContinueButton()
	{
		ContinueButton.click();
	}
	public void ClickConfirmPreference() throws InterruptedException
	{
		ConfirmPreference.click();
		Thread.sleep(250000);
	}
	public void ClickonunlockNowButtton() 
	{
		UnlockNow.click();	
	}
}

