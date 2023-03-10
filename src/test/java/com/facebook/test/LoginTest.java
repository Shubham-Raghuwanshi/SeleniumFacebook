package com.facebook.test;

import org.testng.annotations.Test;

import com.base.ReusableComponents;
import com.base.TestDataProvider;
import com.facebook.LoginPage;

public class LoginTest extends ReusableComponents {

	LoginPage p = new LoginPage();

	@Test(dataProvider = "testdata", dataProviderClass = TestDataProvider.class)
	public void login() {
		try {
			p.loginTest();
			p.checkTitle();
			Thread.sleep(2000);
			p.checkEmailTextBox();
			p.checkPasswordTextBox();
			p.verifyLoginButton();
			Thread.sleep(2000);
			p.VerifyErrorPage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
