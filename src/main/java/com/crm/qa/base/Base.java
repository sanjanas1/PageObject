package com.crm.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	public static WebDriver dr;
	public static Properties prop;
	public Base()
	{   
		try {
			prop= new Properties();
			FileInputStream file = new FileInputStream("F:/eclipse/workspace/PageObjectModel/src/main/java/com/crm/qa/config/config.properties");
			prop.load(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
public static void initialization()
{
	String browsername=prop.getProperty("browser");
	if(browsername.equalsIgnoreCase("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", "E:/WebAutomation/Scenarios/chromedriver.exe");
		dr= new ChromeDriver();
	}
	else if(browsername.equalsIgnoreCase("firefox"))
	{
		dr= new FirefoxDriver();
	}
	dr.manage().window().maximize();
	dr.manage().deleteAllCookies();
	
	dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	dr.get(prop.getProperty("url"));
	
}


}
