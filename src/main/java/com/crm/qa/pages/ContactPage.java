package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.Base;
import com.crm.qa.commonutilities.Utilities;

public class ContactPage extends Base {

	@FindBy(xpath="//a[contains(@href,'contacts/new')]")
	WebElement New;
	@FindBy(name="first_name")
	WebElement Firstname;
	@FindBy(name="last_name")
	WebElement Lastname;
	@FindBy(name="channel_type")
	WebElement social;
	@FindBy(xpath="//*[@id='dashboard-toolbar']/div[2]/div/button[2]")
	WebElement save;
	
	@FindBy(xpath="//*[@id='main-nav']/a[3]/span")
	WebElement contacts;
	
	public ContactPage()
	{
		PageFactory.initElements(dr, this);
	}
	public void createNewContacts(String ftname, String ltname) throws InterruptedException
	{
		Utilities testutil =new Utilities();
		//int flag=0;
		
		contacts.click();
		testutil.explicitwaitForClick(dr,New,9000);
		New.click();
		Firstname.sendKeys(ftname);
		Lastname.sendKeys(ltname);
		social.click();
	    List<WebElement> myelement= dr.findElements(By.name("channel_type"));
	     for(WebElement e: myelement){
	    	 System.out.println(e.getText());
	    	 if(e.getText().equalsIgnoreCase("LinkedIn")){
		        e.click();
	    	 }
	    	 
	     }
	     save.click();
		
	     System.out.println("sanjana");
	     Thread.sleep(10000);
	     
	   //  save.click();

	  	}
	public boolean verifyContact(String name)
	{
		contacts.click();
		return dr.findElement(By.xpath("//td[contains(text(),'"+name+"')]")).isDisplayed();
	}
	
	
}
