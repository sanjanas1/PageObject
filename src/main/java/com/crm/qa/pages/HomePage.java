package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Base;


public class HomePage extends Base {
	
@FindBy(xpath="//*[@id='top-header-menu']/div[2]/span[1]")
WebElement verifyUser;

@FindBy(xpath="//*[@id='main-nav']/a[3]/span")
WebElement contacts;

public HomePage()
{
	PageFactory.initElements(dr, this);
}

public boolean verifyuser()
{
	return verifyUser.isDisplayed();
	
}
public ContactPage contactsClick()
{
	contacts.click();
	return new ContactPage();
}

}
