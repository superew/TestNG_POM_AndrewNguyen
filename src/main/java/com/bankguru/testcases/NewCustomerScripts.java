package com.bankguru.testcases;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.actions.HomePage;
import com.bankguru.actions.LoginPage;
import com.bankguru.actions.NewCustomer;
import com.bankguru.actions.RegisterPage;

import CommonPage.CommonTestCase;

public class NewCustomerScripts extends CommonTestCase {
	WebDriver driver;
	NewCustomer newCustomer;
	LoginPage loginPage;
	RegisterPage registerPage;
	HomePage homePage;
	String email, emailLogin, passLogin, cusName, cusName2, cusName3, DoB, addressField, addressField2;
	String cityField, cityField2, cityField3, stateField, stateField2, stateField3, pinfield, pinfield2, pinfield3;
	String pinfield4;

	@Parameters({ "browser", "version", "url" })
	@BeforeClass
	public void beforeClass(String browser, String version, String url) {
		driver = openMultiBrowser(browser, version, url);
		email = "andrew" + randomEmail() + "@gmail.com";
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		registerPage = loginPage.clickHereLink();

		registerPage.inputEmailToRegister(email);
		registerPage.clickSubmit();
		emailLogin = registerPage.getUserName();
		passLogin = registerPage.getPass();

		loginPage = registerPage.navagateToLoginPage("http://demo.guru99.com/v4/");
		loginPage.inputUserName(emailLogin);
		loginPage.inputPass(passLogin);
		homePage = loginPage.clickLogin();
		verifyEqual(homePage.getTextWelcome(), "Welcome To Manager's Page of Guru99 Bank");
		
		cusName = "name123";
		cusName2 = "name!@# ";
		cusName3 = " namefgnsfn";
		DoB = "02/02/2002";
		addressField = " 123 sfasf";
		addressField2 = "123 arew, WELwvu";
		cityField = "city123";
		cityField2 = "aaasfsaf@$";
		cityField3 = " aasfs";
		stateField = "asasf1231";
		stateField2 = "wvv#$%^";
		stateField3 = " wewegw";
		pinfield = "1234Pin";
		pinfield2 = "123";
		pinfield3 = "123@#%in";
		pinfield4 = " 323";
	}

	@BeforeMethod
	public void beforeMethod() {
		newCustomer = homePage.clickNewCustomer();
	}

	@Test
	public void TC_01_emptyName() {
		newCustomer.inputKeysCustomerName(Keys.TAB);
		
		verifyEqual(newCustomer.getMsgCustomerLabel(), "Customer name must not be blank");
	}
	
	@Test
	public void TC_02_numbericName() {
		newCustomer.inputCustomerName(cusName);
		
		verifyEqual(newCustomer.getMsgCustomerLabel(), "Numbers are not allowed");
	}

	@Test
	public void TC_03_specialChar() {
		newCustomer.inputCustomerName(cusName2);

		verifyEqual(newCustomer.getMsgCustomerLabel(), "Special characters are not allowed");
	}
	
	@Test
	public void TC_04_firstCharNameBlank() {
		newCustomer.inputCustomerName(cusName3);

		verifyEqual(newCustomer.getMsgCustomerLabel(), "First character can not have space");
	}
	
	@Test
	public void TC_05_addressBlank() {
		newCustomer.inputCustomerName(cusName);
		newCustomer.selectGenderMale();
		newCustomer.inputKeysAddress(Keys.TAB);
		verifyEqual(newCustomer.getMsgAddress(), "Address Field must not be blank");
	}
	
	@Test
	public void TC_06_addressFirstBlank() {
		newCustomer.inputCustomerName(cusName);
		newCustomer.selectGenderMale();
		newCustomer.inputAddress(addressField);
		verifyEqual(newCustomer.getMsgAddress(), "First character can not have space");
	}
	
	@Test
	public void TC_08_cityBlank() {
		newCustomer.inputCustomerName(cusName);
		newCustomer.selectGenderMale();
		newCustomer.inputAddress(addressField2);
		newCustomer.inputKeysCity(Keys.TAB);
		verifyEqual(newCustomer.getMsgCity(), "City Field must not be blank");
	}
	
	@Test
	public void TC_09_numbericCity() {
		newCustomer.inputCity(cityField);
		verifyEqual(newCustomer.getMsgCity(), "Numbers are not allowed");
	}
	
	@Test
	public void TC_10_specialCharCity() {
		newCustomer.inputCity(cityField2);

		verifyEqual(newCustomer.getMsgCity(), "Special characters are not allowed");
	}
	
	@Test
	public void TC_11_firstCharCityBlank() {
		newCustomer.inputCity(cityField3);

		verifyEqual(newCustomer.getMsgCity(), "First character can not have space");
	}
	
	@Test
	public void TC_12_stateBlank() {
		newCustomer.inputKeysState(Keys.TAB);
		verifyEqual(newCustomer.getMsgState(), "State must not be blank");
	}
	
	@Test
	public void TC_13_numbericState() {
		newCustomer.inputState(stateField);;
		verifyEqual(newCustomer.getMsgState(), "Numbers are not allowed");
	}
	
	@Test
	public void TC_14_specialCharState() {
		newCustomer.inputState(stateField2);
		verifyEqual(newCustomer.getMsgState(), "Special characters are not allowed");
	}
	
	@Test
	public void TC_15_firstCharStateBlank() {
		newCustomer.inputState(cityField3);
		verifyEqual(newCustomer.getMsgState(), "First character can not have space");
	}
	
	@Test
	public void TC_16_characterPin() {
		newCustomer.inputPin(pinfield);
		verifyEqual(newCustomer.getMsgPin(), "Characters are not allowed");
	}
	
	@Test
	public void TC_17_pinBlank() {
		newCustomer.inputKeysPin(Keys.TAB);
		verifyEqual(newCustomer.getMsgPin(), "PIN Code must not be blank");
	}
	
	@Test
	public void TC_18_pin6Digit() {
		newCustomer.inputPin(pinfield2);
		verifyEqual(newCustomer.getMsgPin(), "PIN Code must have 6 Digits");
	}
	
	@Test
	public void TC_19_specialCharPin() {
		newCustomer.inputPin(pinfield3);
		verifyEqual(newCustomer.getMsgPin(), "Special characters are not allowed");
	}
	
	@Test
	public void TC_20_firstCharPinBlank() {
		newCustomer.inputPin(pinfield4);
		verifyEqual(newCustomer.getMsgPin(), "First character can not have space");
	}
	
	@Test
	public void TC_22_phoneBlank() {
		newCustomer.inputKeysPhone(Keys.TAB);
		verifyEqual(newCustomer.getMsgPhone(), "");
	}
	
	
	
	
	@AfterClass
	public void afterClass() {

	}
}
