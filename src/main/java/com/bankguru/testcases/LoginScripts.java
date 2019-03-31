package com.bankguru.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.actions.HomePage;
import com.bankguru.actions.LoginPage;
import com.bankguru.actions.RegisterPage;

import CommonPage.CommonTestCase;

public class LoginScripts extends CommonTestCase {
	WebDriver driver;
	LoginPage loginPage;
	RegisterPage registerPage;
	String email, emailLogin, passLogin;
	HomePage homePage;

	@Parameters({ "browser", "version", "url" })
	@BeforeClass
	public void beforeClass(String browser, String version, String url) {
		driver = openMultiBrowser(browser, version, url);
		email = "andrew" + randomEmail() + "@gmail.com";

	}

	@Test
	public void TC_01() {
//		loginPage = new LoginPage(driver);
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
	}

	@AfterClass
	public void afterClass() {

	}
}
