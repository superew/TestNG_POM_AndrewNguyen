package com.bankguru.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.bankguru.ui.RegisterPageUI;

import CommonPage.commonFunction;

public class RegisterPage extends commonFunction {

	public RegisterPage(WebDriver driver) {
		super(driver);
	}

	public void inputEmailToRegister(String value) {
		waitVisible(RegisterPageUI.EMAIL_TXT);
		input(RegisterPageUI.EMAIL_TXT, value);
	}

	public void clickSubmit() {
		waitVisible(RegisterPageUI.SUBMIT_BTN);
		click(RegisterPageUI.SUBMIT_BTN);
	}

	public String getUserName() {
		waitVisible(RegisterPageUI.USER_LBL);
		return getText(RegisterPageUI.USER_LBL);
	}

	public String getPass() {
		waitVisible(RegisterPageUI.PASS_LBL);
		return getText(RegisterPageUI.PASS_LBL);
	}

	public LoginPage navagateToLoginPage(String url) {
		openUrl(url);
		return PageFactory.initElements(driver, LoginPage.class);
	}

}
