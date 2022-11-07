package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.PasswordResetPage;
import com.crm.qa.pages.SignUpPage;



public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	PasswordResetPage passwordResetPage;
	SignUpPage signUp;
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void SetUp() {
		
		initialization();
		
		loginPage=new LoginPage();
		
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		
	String title = loginPage.validateLoginPageTitle();
	
	//Assert.assertEquals(title, "Free CRM software for any business with sales, support and customer relationship management");
	Assert.assertEquals(title, "Cogmento CRM");
	}
	
	@Test(priority=2)
	public void  loginTest() throws InterruptedException {
		
		homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		Thread.sleep(5000);
			
	}
	
	@Test(priority=3)
	public void ForgotPasswordLinkTest() throws InterruptedException {
		
		passwordResetPage=loginPage.validateForgotPasswordLink();
		
		Thread.sleep(5000);
	}
	
	@Test(priority=4)
	public void SignUpLinkTest() throws InterruptedException {
		signUp=loginPage.validateSignUpLink();
		Thread.sleep(5000);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}
}
