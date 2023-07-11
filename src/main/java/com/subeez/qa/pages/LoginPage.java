package com.subeez.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.subeez.qa.base.TestBase;
public class LoginPage extends TestBase{
	@FindBy(xpath="//button[@class='btn btn-sm btn-full btn-home']")
	WebElement loginButton;
	@FindBy(xpath="//input[@placeholder='Email Address']")
	WebElement enterEmailAddress;
	@FindBy(xpath="//button[normalize-space()='NEXT']")
	WebElement clickOnNextButton;
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement enterPassword;
	@FindBy(xpath="//button[normalize-space()='Login']")
	WebElement clickOnLoginButton;
	@FindBy(xpath="//div[@class='hs-site-logo']//a")
	WebElement subeezLogo;
	@FindBy(xpath="//span[@class='hs-desktop-profile-left']//img[@alt='profile_icon']")
	WebElement userProfile;
	@FindBy(xpath="//a[normalize-space()='Logout']")
	WebElement logoutOption;
	@FindBy(xpath="//img[@title='SUBEEZ']")
	WebElement SubeezLoginpageLogo;
	@FindBy(xpath="//div[@class='ng-star-inserted']")
	WebElement errorMsg;
	@FindBy(xpath="//input[@id='exampleCheck1']")
	WebElement forceLogin;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	//Login Page Actions//
	public void clickOnLoginButton() {
		loginButton.click();
	}
	public void enterUserName(String un) {
		enterEmailAddress.sendKeys(un);
	}
	public void clickOnNextButton() {
		clickOnNextButton.click();
	}
	public void enterUserPassword(String pwd) {
		enterPassword.sendKeys(pwd);
	}
	public void clickOnLogin_Button() {
		clickOnLoginButton.click();
	}
	public boolean verifySubeezLogo() {
		return subeezLogo.isDisplayed();
	}
	public void userLogout() {
		userProfile.click();
		logoutOption.click();
	}
	public boolean verifyUserLogout() {
		return	SubeezLoginpageLogo.isDisplayed();

	}
	public boolean verifyErrorMsgWithInvalidPassowrd() {
		return errorMsg.isDisplayed();
	}
	public void verifyForceLogin(){
			forceLogin.click();
	}

}
