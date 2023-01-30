package com.facebook;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.base.Base;
import com.base.ExtentReportsPlugin;

public class LoginPage extends Base{
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@id='email']")
	WebElement emailTextBox;
	@FindBy(xpath="//input[@id='pass']")
	WebElement passwordTextBox;
	@FindBy(xpath="//button[@name='login']")
	WebElement loginButton;
	@FindBy(xpath="//h2[@class='uiHeaderTitle']")
	WebElement SecurityPopup;
	
	ExtentReportsPlugin test= new ExtentReportsPlugin();
	
	
	public void loginTest() {
		try {
			PageFactory.initElements(driver, this);
			int a=2+2;
			ExtentReportsPlugin.testPass("Total -->"+a);
			//test.testPassWithScreenshot("");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void checkTitle() {
		try {
			if(driver.getTitle().toLowerCase().contains("facebook"))
				ExtentReportsPlugin.testPass("Title Matched! -> "+driver.getTitle());
			else
				ExtentReportsPlugin.testFail("Title  mismatched! -> "+driver.getTitle());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void checkPasswordTextBox() {
		try {
			PageFactory.initElements(driver, LoginPage.class);
			String var=passwordTextBox.getAttribute("placeholder").toLowerCase();
			if(var.contains("password")) {
				ExtentReportsPlugin.testPass("password text box displayed!!");
				if(passwordTextBox.isEnabled()) {
					ExtentReportsPlugin.testPass("password textis Enabled!!");
					passwordTextBox.sendKeys("123456");
				}else {
					ExtentReportsPlugin.testFail("password text box is not enabled!!");
				}
					
			}else {
				ExtentReportsPlugin.testFail("password text box is not displaying!!");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void checkEmailTextBox() {
		try {
			PageFactory.initElements(driver, this);
		String var=emailTextBox.getAttribute("placeholder").toLowerCase();
		if(var.contains("email")) {
			ExtentReportsPlugin.testPass("Email text box displayed!!");
			ExtentReportsPlugin.testPassWithScreenshot("");
			if(emailTextBox.isEnabled()) {
				ExtentReportsPlugin.testPass("Email textis Enabled!!");
				emailTextBox.sendKeys("shubhamraghuwanshi482@gmail.com");
			}else {
				ExtentReportsPlugin.testFail("Email text box is not enabled!!");
			}
				
		}else {
			ExtentReportsPlugin.testFail("Email text box is not displaying!!");
		}}catch(Exception e) {
			e.fillInStackTrace();
		}
	
	}
	
	public void verifyLoginButton() {

		try {
			PageFactory.initElements(driver, LoginPage.class);
		String var=loginButton.getAttribute("name").toLowerCase();
		if(var.contains("login")) {
			ExtentReportsPlugin.testPass("button displayed with correct text!!");
			if(loginButton.isDisplayed()) {
				ExtentReportsPlugin.testPass("button Enabled!!");
				loginButton.click();
			}else {
				ExtentReportsPlugin.testFail("button is not enabled!!");
			}
				
		}else {
			ExtentReportsPlugin.testFail("button is not displayed with correct text!!");
		}}catch(Exception e) {
			e.fillInStackTrace();
		}
	
	
	}
	
	public void VerifyErrorPage() {
		try {
			PageFactory.initElements(driver, LoginPage.class);
		String var=SecurityPopup.getText().toLowerCase();
		if(var.contains("enter security code")) {
			ExtentReportsPlugin.testPass("alert displayed");
		}else {
			ExtentReportsPlugin.testFail("alret is not displaying");
		}}catch(Exception e) {
			e.fillInStackTrace();
		}
	
	}
	
}
