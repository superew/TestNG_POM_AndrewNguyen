package com.bankguru.actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.bankguru.ui.NewCustomerUI;

import CommonPage.commonFunction;

public class NewCustomer extends commonFunction {

	public NewCustomer(WebDriver driver) {
		super(driver);
	}

	public void inputCustomerName(String value) {
		waitVisible(NewCustomerUI.CUS_NAME);
		input(NewCustomerUI.CUS_NAME, value);
	}

	public String getMsgCustomerLabel() {
		waitVisible(NewCustomerUI.CUS_MSG);
		return getText(NewCustomerUI.CUS_MSG);
	}

	public void inputKeysCustomerName(Keys key) {
		waitVisible(NewCustomerUI.CUS_NAME);
		inputKeys(NewCustomerUI.CUS_NAME, key);
	}
	
	public void selectGenderMale() {
		waitVisible(NewCustomerUI.GEN_MALE_CBX);
		click(NewCustomerUI.GEN_MALE_CBX);
	}
	
	public void inputDOB(String value) {
		waitVisible(NewCustomerUI.DOB_TXT);
		input(NewCustomerUI.DOB_TXT, value);
	}
	public void inputKeysAddress(Keys key) {
		waitVisible(NewCustomerUI.ADD_TXT);
		inputKeys(NewCustomerUI.ADD_TXT, key);
	}
	
	public String getMsgAddress() {
		waitVisible(NewCustomerUI.ADD_MSG);
		return getText(NewCustomerUI.ADD_MSG);
	}
	
	public void inputAddress(String value) {
		waitVisible(NewCustomerUI.ADD_TXT);
		input(NewCustomerUI.ADD_TXT, value);
	}
	
	public void inputKeysCity(Keys key) {
		waitVisible(NewCustomerUI.CITY_TXT);
		inputKeys(NewCustomerUI.CITY_TXT, key);
	}
	
	public String getMsgCity() {
		waitVisible(NewCustomerUI.CITY_MSG);
		return getText(NewCustomerUI.CITY_MSG);
	}
	
	public void inputCity(String value) {
		waitVisible(NewCustomerUI.CITY_TXT);
		input(NewCustomerUI.CITY_TXT, value);
	}
	
	public void inputKeysState(Keys key) {
		waitVisible(NewCustomerUI.STATE_TXT);
		inputKeys(NewCustomerUI.STATE_TXT, key);
	}
	
	public String getMsgState() {
		waitVisible(NewCustomerUI.STATE_MSG);
		return getText(NewCustomerUI.STATE_MSG);
	}
	
	public void inputState(String value) {
		waitVisible(NewCustomerUI.STATE_TXT);
		input(NewCustomerUI.STATE_TXT, value);
	}
	
	public void inputKeysPin(Keys key) {
		waitVisible(NewCustomerUI.PIN_TXT);
		inputKeys(NewCustomerUI.PIN_TXT, key);
	}
	
	public String getMsgPin() {
		waitVisible(NewCustomerUI.PIN_MSG);
		return getText(NewCustomerUI.PIN_MSG);
	}
	
	public void inputPin(String value) {
		waitVisible(NewCustomerUI.PIN_TXT);
		input(NewCustomerUI.PIN_TXT, value);
	}
	
	public void inputKeysPhone(Keys key) {
		waitVisible(NewCustomerUI.MOBILE_TXT);
		inputKeys(NewCustomerUI.MOBILE_TXT, key);
	}
	
	public String getMsgPhone() {
		waitVisible(NewCustomerUI.MOBILE_MSG);
		return getText(NewCustomerUI.MOBILE_MSG);
	}
	
	public void inputPhone(String value) {
		waitVisible(NewCustomerUI.MOBILE_TXT);
		input(NewCustomerUI.MOBILE_TXT, value);
	}
}
