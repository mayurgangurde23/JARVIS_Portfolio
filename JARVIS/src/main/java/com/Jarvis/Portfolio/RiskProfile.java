package com.Jarvis.Portfolio;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RiskProfile {

	@FindBy(xpath ="(//button[text()='Invest Now'])[1]")private WebElement InvestNow;
	@FindBy(xpath="//button[text()='Start now']")private WebElement StartNow;
	@FindBy(xpath = "//span[text()='I want to achieve my financial goals']")private WebElement Q1;
	@FindBy(xpath = "//span[text()='I have invested in Bonds / Debt']")private WebElement Q2;
	@FindBy(xpath = "//span[text()='3 to 5 Years']")private WebElement Q3;
	@FindBy(xpath = "//span[text()='My spouse & children']")private WebElement Q4;
	@FindBy(xpath = "//span[text()='Between 20 - 30% of my total salary']")private WebElement Q5;
	@FindBy(xpath = "//span[text()='Between 10 - 15%']")private WebElement Q6;
	@FindBy(xpath = "//span[text()='I will partially Exit & preserve cash']")private WebElement Q7;
	@FindBy(xpath = "//span[text()='Between 10-20 lacs']")private WebElement Q8;
	@FindBy(xpath = "//span[text()='Between 40-50%']")private WebElement Q9;
	@FindBy(xpath = "//span[text()='Between 31 - 40']")private WebElement Q10;
	@FindBy(xpath = "//button[text()='Submit my responses']")private WebElement SubmitMyResponces;
	@FindBy(xpath = "(//button[text()='Submit my responses'])[2]")private WebElement SubmitMyResponces2;
	@FindBy(xpath="//input[@type='checkbox']")private WebElement Checkbox;
	@FindBy(xpath="//button[text()='I confirm my risk profile']")private WebElement ClickOnConfirm;
 
	public RiskProfile(WebDriver driver)
	{
		PageFactory.initElements(driver	,this);	
	}
	public void ClickOnInvestNow()
	{
		InvestNow.click();	
	}
	public void ClickOnStartnow() 
	{
		StartNow.click();
	}
	public void Atteptquestionnaire() throws InterruptedException
	{
		Q1.click();
		Thread.sleep(1000);
		Q2.click();
		Thread.sleep(1000);
		Q3.click();
		Thread.sleep(1000);
		Q4.click();
		Thread.sleep(1000);
		Q5.click();
		Thread.sleep(1000);
		Q6.click();
		Thread.sleep(1000);
		Q7.click();
		Thread.sleep(1000);
		Q8.click();
		Thread.sleep(1000);
		Q9.click();
		Thread.sleep(1000);
		Q10.click();
		Thread.sleep(1000);
	}
	public void ClickOnSubmitMyResponces()
	{
		SubmitMyResponces.click();
	}
	public void SubmitMyResponces()
	{
		SubmitMyResponces2.click();
	}
	public void SelectCheckbox()
	{
		Checkbox.click();
	}
	public void ConfirmRiskProfile() 
	{
		ClickOnConfirm.click();
	}
}
