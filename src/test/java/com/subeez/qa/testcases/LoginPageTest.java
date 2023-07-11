package com.subeez.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.subeez.qa.base.TestBase;
import com.subeez.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
	}
	@Test(priority = 1)
	public void verifySubeezLoginfuctionality_ValidCredentials() throws InterruptedException {
		loginPage.clickOnLoginButton();
		loginPage.enterUserName(prop.getProperty("userName"));
		loginPage.clickOnNextButton();
		// Thread.sleep(2000);
		loginPage.enterUserPassword(prop.getProperty("userPassword"));
		//loginPage.verifyForceLogin();
		loginPage.clickOnLogin_Button();
		boolean flag = loginPage.verifySubeezLogo();
		Assert.assertTrue(flag);
	}
	@Test(priority=2) 
	public void verifySubeezUserlogoutfuctionality(){ 
		loginPage.clickOnLoginButton();
		loginPage.enterUserName(prop.getProperty("userName"));
		loginPage.clickOnNextButton(); 
		loginPage.enterUserPassword(prop.getProperty("userPassword"));
		loginPage.clickOnLogin_Button();
		loginPage.verifyForceLogin(); 
		loginPage.clickOnLogin_Button(); 
		boolean flag =loginPage.verifySubeezLogo(); 
		Assert.assertTrue(flag);
		loginPage.userLogout(); 
		boolean flag1=loginPage.verifyUserLogout();
		Assert.assertTrue(flag1); }
	@Test(priority =3) 
	public void verifySubeezLoginwithInvalidCredentials(){ 
		loginPage.clickOnLoginButton();
		loginPage.enterUserName(prop.getProperty("userName"));
		loginPage.clickOnNextButton(); //Thread.sleep(2000);
		loginPage.enterUserPassword(prop.getProperty("invalidUserPwd"));
		loginPage.clickOnLogin_Button(); 
		boolean flag =loginPage.verifyErrorMsgWithInvalidPassowrd(); 
		Assert.assertTrue(flag); }

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
