package com.logintest;


import java.io.IOException;

import org.testng.annotations.Test;

import com.Jarvis.Library.LoginPage;
import com.Jarvis.Library.UtilityClass;
import com.Jarvis.Portfolio.InvestmentPreference;
import com.Jarvis.Portfolio.Payment;
import com.Jarvis.Portfolio.RiskProfile;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import com.jarvis.testutility.BaseTest;


public class TestClass extends BaseTest{

	ExtentReports extentReport = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter("report1.html");
	//@BeforeClass
	public void setup() throws IOException 
	{
		lunchBrowser();	
		loginpage=new LoginPage(driver);
		riskprofile=new RiskProfile(driver);
		investmentpreference=new InvestmentPreference(driver);
		payment=new Payment(driver);
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("JARVIS Test Automation Results Report");
		spark.config().setDocumentTitle("JARVIS Automation Report");
		spark.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		extentReport.attachReporter(spark);
	}
	@Test(priority=1)
	public void VerifyLoginFunctionality() throws IOException, InterruptedException
	{
		ExtentTest test = extentReport.createTest("VerifyLoginFunctionality");
		loginpage.ClickOnLoginWithPasswordLink();
		//TO Genrate Random mail.
		//L1.EnterEmailId((String) UtilityClass.generateRanodmEmail());
		loginpage.EnterEmailId(UtilityClass.getDatafromPropertyFile("Email"));
		loginpage.Enterpassword(UtilityClass.getDatafromPropertyFile("Password"));
		loginpage.ClickOnLogin();
		extentReport.flush();
	}
	@Test(priority = 2)
	public void ClickOnInvestNowButton()
	{
		ExtentTest test = extentReport.createTest("ClickOnInvestNowButton");
		riskprofile.ClickOnInvestNow();
		
	}
	@Test(priority = 3)
	public void ClickOnStartNowButton()
	{
		ExtentTest test = extentReport.createTest("ClickOnStartNowButton");
		riskprofile.ClickOnStartnow();
	}
	@Test(priority = 4)
	public void AttemptQuestionnaries() throws InterruptedException
	{
		ExtentTest test = extentReport.createTest("AttemptQuestionnaries");
		riskprofile.Atteptquestionnaire();
	}
	@Test(priority=5)
	public void ClickOnSubmitMyResponcesButton()
	{
		ExtentTest test = extentReport.createTest("ClickOnSubmitMyResponcesButton");
		riskprofile.ClickOnSubmitMyResponces();
	}
	@Test(priority = 6)
	public void ConfirmResponces() throws InterruptedException
	{
		ExtentTest test = extentReport.createTest("ConfirmResponces");
		riskprofile.SubmitMyResponces();
		Thread.sleep(2000);
	}
	@Test(priority =7)
	public void SelectCheckbox()
	{
		ExtentTest test = extentReport.createTest("SelectCheckbox");
		riskprofile.SelectCheckbox();
	}
	@Test(priority =8)
	public void ConfirmRiskProfile() 
	{	
		ExtentTest test = extentReport.createTest("ConfirmRiskProfile");
		riskprofile.ConfirmRiskProfile();
	}
	@Test(priority =9)
	public void SelectTenure1()
	{
		ExtentTest test = extentReport.createTest("SelectTenure1");
		investmentpreference.selectYear();
	}
	@Test(priority =10)
	public void SelectStrategy()
	{
		ExtentTest test = extentReport.createTest("SelectStrategy");
		investmentpreference.StrategySelection();
	}
	@Test(priority = 11)
	public void ClickOnSubmitMyStrategy()
	{
		ExtentTest test = extentReport.createTest("ClickOnSubmitMyStrategy");
		investmentpreference.SubmitStrategy();
	}
	@Test(priority =12)
	public void SelectAmount()
	{
		ExtentTest test = extentReport.createTest("SelectAmount");
		investmentpreference.SelectAmount();
	}
	@Test(priority = 13)
	public void SelectPlan()
	{
		ExtentTest test = extentReport.createTest("SelectPlan");
		investmentpreference.SelectPlan();
	}
	@Test(priority = 14)
	public void CLickOnContinueButton()
	{
		ExtentTest test = extentReport.createTest("CLickOnContinueButton");
		investmentpreference.ClickOnContinueButton();
	}
	@Test(priority = 15)
	public void ConfirmInvestmentPreference() throws InterruptedException
	{
		ExtentTest test = extentReport.createTest("ConfirmInvestmentPreference");
		investmentpreference.ClickConfirmPreference();
	}
	@Test(priority =16)
	public void UnlockPortfolioButton()
	{
		ExtentTest test = extentReport.createTest("ClickOnSubmitMyResponcesButton");
		investmentpreference.ClickonunlockNowButtton();
	}
	@Test(priority = 17)
	public void ClickOnPayNowButton()
	{
		ExtentTest test = extentReport.createTest("ClickOnPayNowButton");
		payment.ClickoPayButton();
	}
	@Test(priority = 18)
	public void ClickOnIAgreeButton()
	{
		ExtentTest test = extentReport.createTest("ClickOnIAgreeButton");
		payment.ClickOnIAgree();
	}
}

