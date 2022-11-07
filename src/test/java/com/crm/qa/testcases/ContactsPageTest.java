/*
 * Hiiiiiiiiiiiiiii
 * Byyyyyyyyyyyyyyy
 * kuuuuuuuuuuuuuuu
 * 
 * 
 * 
 * 
 */


package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactactsPage;
	
	String sheetName="Contacts";
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void SetUp() {
		
		initialization();
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		contactactsPage=homePage.clickOnContactsLink();
		
	}
	
	
	@Test(priority=1)
	public void ContactsPageTitleTest() {
		String title=contactactsPage.validateContactsPageTitle();
		Assert.assertEquals(title,"Cogmento CRM");

	}

	
	 @Test(priority=2)
	 public void NameLabelTest() {
		Boolean flag=contactactsPage.validateNameLabel();
		Assert.assertTrue(flag);

	}
	 
	 @DataProvider
		public Object[][] getCRMData() {
			Object data[][]=TestUtil.getTestData(sheetName);
			return data;

		}
		
	@Test(priority=3,dataProvider = "getCRMData")
		//public void createNewContactTest() {
		public void createNewContactTest(String fname,String lname, String mname) throws InterruptedException {
			homePage.clickOnContactsLink();
			//contactactsPage.createNewContact("PP", "RR", "SS");
			contactactsPage.createNewContact(fname, lname, mname);

		}
	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
