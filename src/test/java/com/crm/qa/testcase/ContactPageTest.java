package com.crm.qa.testcase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.Base;
import com.crm.qa.commonutilities.Utilities;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class ContactPageTest extends Base {
	LoginPage loginpage;
	HomePage homepage;
	ContactPage contactpage;
	Utilities testutil;
	public ContactPageTest()
	{
		super();
	}
//@BeforeMethod
public void setup()
{
	initialization();
	loginpage= new LoginPage();
	homepage= loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
	contactpage = homepage.contactsClick();
	testutil= new Utilities();
}


@Test(priority=1, dataProvider="getContactdata")
public void createContact(String FirstName, String LastName) throws InterruptedException
{
	
	contactpage.createNewContacts(FirstName,LastName);
	// Assert.assertTrue(contactpage.verifyContact("Nikhil Kumar"));
	
}
@DataProvider
public Object[][] getContactdata() throws IOException
{
	setup();
	Object data[][]= testutil.testdata("Sheet1");
	return data;
}
@AfterMethod
public void teardown()
{
	dr.quit();
}
}
