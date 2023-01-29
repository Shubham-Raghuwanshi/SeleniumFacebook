package com.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {
	
	public static WebDriver driver;
	DesiredCapabilities capibilities;
	public static ExtentReportsPlugin test1= new ExtentReportsPlugin();
	
	@BeforeMethod
	public static void basicSetup() {
		test1.generate();
		System.out.println("------------------------------->"+System.getProperty("chromeDriver"));
		System.setProperty("webdriver.chrome.driver","E:\\Driver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("disable-infobars");
		options.addArguments("version");
		driver= new ChromeDriver(options);
		driver.get("https://www.facebook.com");
	}
	
	
	@AfterMethod
	public  void endTest() {
		driver.quit();
		test1.end();
	}
}
