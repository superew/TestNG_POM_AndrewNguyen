package com.bankguru.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.bankguru.ui.HomePageUI;

import CommonPage.commonFunction;

public class HomePage extends commonFunction {
	public HomePage(WebDriver driver) {
		super(driver);
	}

	public String getTextWelcome() {
		waitVisible(HomePageUI.WELCOME_LBL);
		return getText(HomePageUI.WELCOME_LBL);
	}
	
	public NewCustomer clickNewCustomer() {
		waitVisible(HomePageUI.NEW_CUSTOMER_LINK);
		click(HomePageUI.NEW_CUSTOMER_LINK);
		return PageFactory.initElements(driver, NewCustomer.class);
	}
}
