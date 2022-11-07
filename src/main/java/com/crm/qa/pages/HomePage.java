package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	//OR
	
	@FindBy(xpath="//span[contains(text(),'Prashant Salve')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//span[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	
	//Initialize page objects
	
	public HomePage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle() {
		
		return driver.getTitle();
	}

	public boolean validateUsernameLabel() {
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}

}
