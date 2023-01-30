package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



public class Base {
	
	
	public static WebDriver driver;
	DesiredCapabilities capibilities;
	public static Properties prop;
	public static ExtentReportsPlugin test1= new ExtentReportsPlugin();
	//public static Logger logger;
	
	@BeforeMethod
	public static void basicSetup() {
		try {
			String value=null;
			test1.generate();
		//	logger.info("Test execution started.....");
			prop= new Properties();
			FileInputStream propFile = new FileInputStream("./Configuration/application.properties");
			prop.load(propFile);
			value = prop.getProperty("chromeDriver");
			System.out.println("------------------------------->"+value);
			System.setProperty("webdriver.chrome.driver",value);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			options.addArguments("disable-infobars");
			options.addArguments("version");
			driver= new ChromeDriver(options);
			driver.get("https://www.facebook.com");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@AfterMethod
	public  void endTest() {
		//logger.info("Test execution ended.....");
		driver.quit();
		test1.end();
	}
}
