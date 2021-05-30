package com.inetbanking.testCases;


import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;

public class BaseClass {
	
	public ReadConfig readconfig = new ReadConfig();
	public String baseURL = readconfig.getApplicationURL();
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();
	public static WebDriver driver;
	
	public static Logger logger;
	
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br)
	{
		logger = Logger.getLogger("ebanking");
		 PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equalsIgnoreCase("chrome"))
		{ 
		
		System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
		driver = new ChromeDriver();}
		
		else if(br.equalsIgnoreCase("firefox"))
		{
		
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
			driver = new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseURL);
		
		
	}

	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public void captureScreen(WebDriver ldriver, String tr)
	{
		TakesScreenshot ts = ((TakesScreenshot)ldriver);
		File f = ts.getScreenshotAs(OutputType.FILE);
		
		File dest = new File("./ScreenShots/"+tr+".png");
		
		try {
		FileUtils.copyFile(f, dest);
		}
		catch(Exception e)
		{}
		}
	
	public String randomString()
	{
		return RandomStringUtils.randomAlphabetic(8);
	}
}
