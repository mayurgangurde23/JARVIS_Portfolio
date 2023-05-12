package com.Jarvis.Library;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.beust.jcommander.Parameter;
import com.fasterxml.jackson.databind.Module.SetupContext;

import io.github.bonigarcia.wdm.WebDriverManager;
public class BaseClass {
	public Properties prop;
	public static WebDriver driver;
	public static ExtentSparkReporter spark;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public void lunchBrowser() throws IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
//		driver.get(prop.getProperty("url"));
//		driver.get(UtilityClass.getDatafromPropertyFile("url"));
		driver.get("https://customer-qa1.jarvisinvest.com");
	}
		public static void setUpBrowser() throws IOException {
			
			ChromeOptions option=new ChromeOptions();
			option.addArguments("----disable-notifications");
			option.addArguments("--remote-allow-origins=*");
			
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver(option);
			driver.get(UtilityClass.getDatafromPropertyFile("url"));
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
	
		public static void setExtentReport() {
			spark=new ExtentSparkReporter("Extent Report.html");
			spark.config().setTheme(Theme.STANDARD);
			spark.config().setReportName("JARVIS Test Automation Results Report");
			spark.config().setDocumentTitle("TN Automation Report");
			spark.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
			 extent=new ExtentReports();
			 extent.attachReporter(spark);
		}

		public WebDriver InitialiseBrowser(String browsername) throws IOException{
			if(browsername.equalsIgnoreCase("chrome")){
				driver=new ChromeDriver();
			}
				else if (browsername.equalsIgnoreCase("firefox")) {
					driver=new FirefoxDriver();
				}
					else if (browsername.equalsIgnoreCase("edge")) {
						driver=new EdgeDriver();
					}
						else if(browsername.equalsIgnoreCase("safari")) {
							driver = new SafariDriver();
						}
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
					driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
					driver.get(UtilityClass.getDatafromPropertyFile("url"));
					return driver;		
	}
	}