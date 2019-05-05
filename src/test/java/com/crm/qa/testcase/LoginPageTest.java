package com.crm.qa.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.Base;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends Base {
	LoginPage loginpage;
	HomePage homepage;
	public LoginPageTest()
	{
		super();
	}
	@BeforeMethod
	public void setup(){
		initialization();
	
	loginpage =new LoginPage();
	}
	
	@AfterMethod
	public void close()
	{
		dr.quit();
	}
	
	@Test
	public void AfterLoginTitleTest(){
		
		homepage= loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
	}	

}
