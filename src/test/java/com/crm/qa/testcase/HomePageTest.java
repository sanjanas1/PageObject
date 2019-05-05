package com.crm.qa.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.Base;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends Base {
	LoginPage loginpage;
	HomePage homepage;
	ContactPage contactpage;
	
public	HomePageTest()
	{
		super();
	}
@BeforeMethod
public void setup()
{
	initialization();
	loginpage= new LoginPage();
	homepage= loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
}
@Test(priority=2)
public void verifyUserTest() throws InterruptedException
{
	Boolean flag = homepage.verifyuser();
	Assert.assertTrue(flag);
	Thread.sleep(5000);
	System.out.println("aaaaaaaaaaaaa");
}

@Test(priority=1)
public void ContactClick() throws InterruptedException
{
	contactpage = homepage.contactsClick();
	Thread.sleep(10000);
	System.out.println("bbbbbbbbbbb");
	
}

@AfterMethod
public void teardown()
{
	dr.quit();
}

	
}
