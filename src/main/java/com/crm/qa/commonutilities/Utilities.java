package com.crm.qa.commonutilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.Base;

public class Utilities extends Base {
	
	public static int srow;

	public  Object[][] testdata(String sheetname ) throws IOException
	{
//	File file =new File("F:/eclipse/workspace/PageObjectModel/src/main/java/com/crm/qa/testdata/Contact.xlsx");
	FileInputStream fis= new FileInputStream("F:/eclipse/workspace/PageObjectModel/src/main/java/com/crm/qa/testdata/Contact.xlsx");
	XSSFWorkbook book = new XSSFWorkbook(fis);
	XSSFSheet sheet= book.getSheet(sheetname);
    srow = sheet.getLastRowNum();
	int scol= sheet.getRow(0).getLastCellNum();
	Object[][] contactdata =new Object[srow][scol];
	for(int i=sheet.getFirstRowNum()+1;i<=srow;i++)
	{
		for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
		{
			System.out.println("****************************************"+sheet.getRow(i).getCell(j).toString());
			contactdata[i-1][j]= sheet.getRow(i).getCell(j).toString();
		}
	}
		
return contactdata;	
}

	public void explicitwaitForClick(WebDriver driver, WebElement locator, int timeout)
	{
		new WebDriverWait(driver,timeout).ignoring(ElementNotVisibleException.class).until(ExpectedConditions.elementToBeClickable(locator));
				
	}
	public void explicitwaitForVisibile(WebDriver driver, WebElement locator, int timeout)
	{
		new WebDriverWait(driver,timeout).ignoring(ElementNotVisibleException.class).until(ExpectedConditions.visibilityOf(locator));
				
	}
	
}
