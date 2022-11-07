package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory  ..Object Repositary
	
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[contains(@class,'ui fluid large blue submit button')]")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Forgot your password?')]")
	WebElement forgotPassword;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signUp;
	
	
	//Initialization the page objects
	public LoginPage() {
		PageFactory.initElements(driver,this);//instead of this we can use LoginPage.class
		
	}
	
	//Actions
	
	public String validateLoginPageTitle() {
		
		return driver.getTitle();
		
	}
	
	public HomePage login(String un,String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		
		loginBtn.click();
		
		return new HomePage();
	}
	
	public PasswordResetPage validateForgotPasswordLink() {
		
		forgotPassword.click();
		return new PasswordResetPage();
	}

	public SignUpPage validateSignUpLink() {
		
		signUp.click();
		return new SignUpPage();
		
	}

}
