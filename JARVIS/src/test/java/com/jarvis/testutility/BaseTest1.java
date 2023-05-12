package com.jarvis.testutility;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Driver;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.internal.ITestResultNotifier;

import com.Jarvis.Library.BaseClass;
import com.Jarvis.Library.LoginPage;
import com.Jarvis.Library.UtilityClass;
import com.Jarvis.Portfolio.InvestmentPreference;
import com.Jarvis.Portfolio.Payment;
import com.Jarvis.Portfolio.RiskProfile;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class BaseTest1 extends BaseClass{

	@BeforeSuite
	public void InitializeBrowser() throws IOException {
		setUpBrowser();
	}
	@AfterSuite
	public void teardown(){
		driver.quit();
	}
	@BeforeTest
	public void beforeTest() {
		setExtentReport();
	}
	@AfterTest
	public void afterTest() throws IOException {
		extent.flush();
		Desktop.getDesktop().browse(new File("Extent Report.html").toURI());
	}
	@BeforeMethod
	public void createExtentTest(ITestResult result,Method m) {
		//test=extent.createExtentTest(m.getName());
		test = extent.createTest(m.getName());
	}
	@AfterMethod
	public void captureScreenshot(ITestResult result,Method m) {
		if(result.getStatus()==ITestResult.FAILURE) {
			UtilityClass.captureScreenshot(result.getMethod().getMethodName(),driver);
			test.log(Status.FAIL,m.getName());
		}
		else {
			test.log(Status.PASS,m.getName());
		}
	}
	@BeforeClass
	public void pageobjects() {
		loginpage=new LoginPage(driver);
		riskprofile=new RiskProfile(driver);
		investmentpreference=new InvestmentPreference(driver);
		payment=new Payment(driver);
	}
		 public LoginPage loginpage;
		 public RiskProfile riskprofile;
		 public InvestmentPreference investmentpreference;
		 public Payment payment;
}



