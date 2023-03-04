package com.gcr.scripts;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.gcr.commands.ActionDriver;
import com.gcr.config.StartBrowser;
import com.gcr.reuse.CommonFunctions;

public class TC4_WebTables_Handling<Webelement> extends StartBrowser{
	@Test
	public void Table_Elements() throws Exception {
		CommonFunctions cfs = new CommonFunctions();
		ActionDriver ad = new ActionDriver();
		cfs.loginsample();
		//System.out.print(ad.findElements(By.xpath("//*[@id=\"customers\"]"), "Table headers")); 
	    //List<WebElements> = allElement = ad.findElementBy.xpath("//*[@id=\"customers\"]//tr");
		WebElement tabledata = driver.findElement(By.xpath("//table[contains(@id,'cust')]"));
		//Count Rows
		java.util.List<WebElement> rows = tabledata.findElements(By.xpath("//*[@id=\"customers\"]//tr"));
		int rowsCount = rows.size();
		System.out.println("Rows Count is: "+rowsCount);
		System.out.println("********************************************");
		java.util.List<WebElement> coln = tabledata.findElements(By.xpath("//*[@id=\"customers\"]//th"));
		int colCount = coln.size();
		System.out.println("Column Count is: "+colCount);
		System.out.println("********************************************");
		java.util.List<WebElement> alldata = tabledata.findElements(By.xpath("//*[@id=\"customers\"]//td"));
		int datasize = alldata.size();
		System.out.println("All Data Count is: "+datasize);
		for(WebElement ele:alldata)
		{
			String value =((WebElement) ele).getText();
			if (value.contains("Ola"))
					{
					System.out.println("Data Found");
					break;
					}

			}
		}

}
