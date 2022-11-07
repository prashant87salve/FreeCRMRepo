package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {

	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void SetUp() {
		
		initialization();
		
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		
		
	}
		
	@Test(priority=1)
	public void homePageTitleTest() {
		
		String title=driver.getTitle();
		Assert.assertEquals(title, "Cogmento CRM","Home Page title is not matched");
	}
	
	@Test(priority=2)
	public void UsernameLabelTest() {
		
		Assert.assertTrue(homePage.validateUsernameLabel());
	}
	
	@Test(priority=3)
	public void ContactsLinkTest() throws InterruptedException {
		contactPage=homePage.clickOnContactsLink();
		Thread.sleep(5000);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
