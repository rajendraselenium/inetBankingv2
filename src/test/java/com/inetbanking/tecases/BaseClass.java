package com.inetbanking.tecases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.helpers.Loader;
import org.apache.log4j.pattern.LoggerPatternConverter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.utils.FileUtil;
import com.beust.jcommander.Parameter;
import com.inetbanking.utilities.ReadConfig;

public class BaseClass {
   ReadConfig readconfig=new ReadConfig(); 
	public String baseURL=readconfig.getURL().trim();
	 public String user_id=readconfig.getUserName();
	 public String password=readconfig.getPassword();
	public String chromepath=readconfig.chromePath().trim();	
	public  WebDriver driver;
	public  Logger logs;
	
	
	@BeforeClass
	@Parameters("browserType")

	public void setUp(String browserType)
	{
		
		//System.setProperty("webdriver.chrome.driver", "E:\\Java selenium\\WebDriver3\\InetBankingv2\\Drivers\\chromedriver.exe");
		if( browserType.equalsIgnoreCase("chrome"))
				{
				System.setProperty("webdriver.chrome.driver", "E:\\Java selenium\\WebDriver3\\InetBankingv2\\Drivers\\chromedriver.exe");
				driver=new ChromeDriver();
				}
		else if ( browserType.equalsIgnoreCase("firefox"))
				{
				System.setProperty("webdriver.gecko.driver", "E:\\Java selenium\\WebDriver3\\InetBankingv2\\Drivers\\geckodriver.exe");
				driver=new FirefoxDriver();
				}
		else if( browserType.equalsIgnoreCase("IE"))
				{
				System.setProperty("webdriver.IE.driver", "E:\\Java selenium\\WebDriver3\\InetBankingv2\\Drivers\\IEDriverServer.exe");
				driver=new InternetExplorerDriver();
				}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		//System.out.println(chromepath);
		//System.setProperty("webdriver.chrome.driver",readconfig.chromePath());
		
		
		// Log4j configurartion	, log4j plugin updated in POM, copy lgo4j.properties in root project, logs folder and log file generated after refreshing
		
		
		driver.get(baseURL);
		
		logs=Logger.getLogger("BaseClass");
		PropertyConfigurator.configure("Log4j.properties");

		//logs.debug("URL opened");
		//logs.info("open browser");
System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
		
	}
	
	@AfterClass
	public void terDown()
	{
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String testName) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src= ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"/Screenshots/"+testName+".png");
		FileUtils.copyFile(src, target);
		System.out.println("screen shot taken");
		
		
	}
	
	
	public boolean isAlertPresent()
	{
		try{
		driver.switchTo().alert();
		return true;
	} 
		catch(Exception e)
	{
		return false;
				
	}
	}
	
	public String randomString()
	{
		String rndstr=RandomStringUtils.randomAlphabetic(7);
		return rndstr;
	}

	
}
