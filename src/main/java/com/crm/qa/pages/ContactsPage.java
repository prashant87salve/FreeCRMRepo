package com.crm.qa.pages;

import java.awt.Desktop.Action;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	//OP..PF
	
	@FindBy(xpath="//a[contains(teat(),'prashant ramesh salve')]")
	WebElement customer;
	
	//@FindBy(xpath="//button[@class='ui linkedin button']")
	//WebElement createContactBtn;
	
	//@FindBy(xpath="//button[contains(text(),'Create'))]")
    //WebElement createContactBtn;
	
	@FindBy(xpath="//a[@href='/contacts/new']")
    WebElement createContactBtn;
	
	@FindBy(name="first_name")
	WebElement firstName;
	
	//@FindBy(xpath="//input[contains(@name='first_name')]")
	//WebElement firstName;
	
	@FindBy(name="last_name")
	WebElement lastName;
	
	@FindBy(name="middle_name")
	WebElement middleName;
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
	WebElement saveBtn;
	
	
	@FindBy(xpath="//th[contains(text(),'Name')]")
	WebElement nameLabel;
	
	@FindBy(xpath="//button[contains(text(),'Show Filters')]")
	WebElement filterBtn;
	
	
	
	//Initialize object
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions
	public String validateContactsPageTitle() {
		
		return driver.getTitle();
	
	}
	
	public void clickOnCustomer() {
		
	}
	
	public void createNewContact(String fname,String lname, String mname) throws InterruptedException {
		
		//Actions action=new Actions(driver);
		//action.moveToElement(createContactBtn).build().perform();
		
		//String currentUrl=driver.getCurrentUrl();
		//System.out.println(currentUrl);
		createContactBtn.click();
		
		//filterBtn.click();
		
		
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		middleName.sendKeys(mname);
		
		Thread.sleep(5000);
		
		saveBtn.click();
		
		
	}
	
	public boolean validateNameLabel() {
		return nameLabel.isDisplayed();
		
	}

}
