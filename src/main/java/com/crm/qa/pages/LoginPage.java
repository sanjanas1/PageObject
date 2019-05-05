package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Base;

public class LoginPage extends Base {
	
	@FindBy(xpath="//span[contains(text(),'Log In')]")
	WebElement login;
	
	@FindBy(name="email")
	WebElement EmailId;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[contains(text(),'Login')]")
	WebElement LoginBtn;
	
	public LoginPage(){
		PageFactory.initElements(dr, this);
	}
	
	public HomePage Login(String un, String pwd)
	{
	login.click();
	EmailId.sendKeys(un);
	password.sendKeys(pwd);
	LoginBtn.click();
	return new HomePage();
	}
	

}
