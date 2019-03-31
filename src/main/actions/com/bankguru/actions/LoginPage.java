package com.bankguru.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.bankguru.ui.LoginPageUI;

import CommonPage.commonFunction;

public class LoginPage extends commonFunction{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public RegisterPage clickHereLink() {
		waitVisible(LoginPageUI.HERE_LINK);
		click(LoginPageUI.HERE_LINK);
		return PageFactory.initElements(driver, RegisterPage.class);
	}
	
	public void inputUserName(String value) {
		waitVisible(LoginPageUI.USER_TXT);
		input(LoginPageUI.USER_TXT, value);
	}
	
	public void inputPass(String value) {
		waitVisible(LoginPageUI.PASS_TXT);
		input(LoginPageUI.PASS_TXT, value);
	}
	
	public HomePage clickLogin() {
		waitVisible(LoginPageUI.LOGIN_BTN);
		click(LoginPageUI.LOGIN_BTN);
		return PageFactory.initElements(driver, HomePage.class);
	}

}
