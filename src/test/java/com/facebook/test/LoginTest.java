package com.facebook.test;

import org.testng.annotations.Test;

import com.base.Base;
import com.facebook.LoginPage;

public class LoginTest extends Base {

	LoginPage p = new LoginPage();

	@Test
	public void login() {
		p.loginTest();
		p.checkTitle();
	}

}
