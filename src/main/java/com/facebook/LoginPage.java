package com.facebook;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base;
import com.base.ExtentReportsPlugin;

public class LoginPage extends Base{
		
	
	@FindBy(id="password")
	WebElement pswd;
	ExtentReportsPlugin test= new ExtentReportsPlugin();
	
	
	public void loginTest() {
		PageFactory.initElements(driver, LoginPage.class);
		int a=2+2;
		ExtentReportsPlugin.testPass("Something"+a);
		//test.testPassWithScreenshot("");
		
	}
	
	public void checkTitle() {
		if(driver.getTitle().toLowerCase().contains("facebook"))
			ExtentReportsPlugin.testPass("Title Matched! -> "+driver.getTitle());
	}
	
	
}
