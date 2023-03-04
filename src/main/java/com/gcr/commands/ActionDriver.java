package com.gcr.commands;

import java.util.Set;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.list;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.gcr.config.StartBrowser;

public class ActionDriver {
	
	public WebDriver driver;
	
	public ActionDriver()
	{
		driver = StartBrowser.driver;
	}

	/**
	 * Used for navigating to application
	 * @param url -- Application URL
	 */
	public void navigateToApplication(String url)
	{
		try {
			driver.get(url);
			StartBrowser.childTest.pass("Successfully Navigated to  :"+url);
		} catch (Exception e) {
			StartBrowser.childTest.fail("Navigation Unsuccessful :"+url);
		}
	}
	/**
	 * used for perform click action on buttons, radio buttons, links and check boxes
	 * @param locator -- Get it from object repository
	 * @param eleName -- Name of the element
	 * @throws Exception
	 */
	public void click(By locator, String eleName) throws Exception
	{
		try {
		driver.findElement(locator).click();
		StartBrowser.childTest.pass("Successfully perfomred click action on : "+eleName);
	} catch (Exception e) {
		StartBrowser.childTest.fail("Unable to perfomre click action on: "+eleName,
				MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
		StartBrowser.childTest.info(e);
		throw e;
	}
	}
	/**
	 * used for perform click action on Weblement tables
	 * @param locator -- Get it from object repository
	 * @param eleName -- Name of the element
	 * @return 
	 * @return 
	 * @throws Exception
	 */
	//public List findElements(By locator, String eleName) throws Exception
	//{
		//List allLinks;
		//try {
		//	java.util.List<WebElement> allLinks = driver.findElements(locator);
			//StartBrowser.childTest.pass("Successfully found table element on : "+eleName);
		//	return (List) allLinks;
	//} catch (Exception e) {
		//	StartBrowser.childTest.fail("Unable to find table element: "+eleName,
		//	MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
		//	StartBrowser.childTest.info(e);
	//	throw e;
	//}


	//}
	/**
	 * used to type in text box
	 * @param locator  -- get it from OR
	 * @param testData -- get it from excel sheets 
	 * @param eleName  -- Name of the element
	 * @throws Exception
	 */
	public void type(By locator, String testData, String eleName) throws Exception
			{
		try {
			driver.findElement(locator).sendKeys(testData);
			StartBrowser.childTest.pass("Successfully perfomred type action on : "+eleName +" With data :"+testData);
		} catch (Exception e) {
			StartBrowser.childTest.fail("Unable to perfomr type action on : "+eleName +" With data :"+testData,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			StartBrowser.childTest.info(e);
			throw e;
		}
			}
	
	public String getTitle()
	{
		String title = null;
		try {
			title= driver.getTitle();
			StartBrowser.childTest.pass("Title of the page is :"+title);
		} catch (Exception e) {
			StartBrowser.childTest.fail("Unable to get tiel");
		}
		return title;
	}
	/**
	 * used to perform mousehover action on element
	 * @param locator -- OR
	 * @param eleName -- Name of the element
	 * @throws Exception
	 */
	public void mouseHover(By locator, String eleName) throws Exception
	{
		try {
			WebElement we=driver.findElement(locator);
			Actions a = new Actions(driver);
			a.moveToElement(we).build().perform();
			StartBrowser.childTest.pass("Successfully performed mousehover action on :"+eleName );
		} catch (Exception e) {
			StartBrowser.childTest.fail("Unable to performe mousehover action action on :"+eleName,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			StartBrowser.childTest.info(e);
			throw e;
		}
	}
	/**
	 * select value from DD using Visible text
	 * @param locator -- OR
	 * @param visibleText -- Dropdown value
	 * @param eleName -- Name of the dropdown
	 * @throws Exception
	 */
	public void selectByVisibleText(By locator, String visibleText, String eleName) throws Exception
	{
		try {
			WebElement we=driver.findElement(locator);
			Select s = new Select(we);
			s.selectByVisibleText(visibleText);
			StartBrowser.childTest.pass("Successfully Selected value  :"+visibleText + " From Dropdown :"+eleName);
		} catch (Exception e) {
			StartBrowser.childTest.pass("Unable to selecte value  :"+visibleText + " From Dropdown :"+eleName,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			StartBrowser.childTest.info(e);
			throw e;
		}
	}
	
	/**
	 * Get text from element
	 * @param locator -- get it from OR
	 * @param eleName
	 * @return
	 * @throws Exception
	 */
	public String getText(By locator, String eleName) throws Exception
	{
		try {
			String text=driver.findElement(locator).getText();
			StartBrowser.childTest.pass("Successfully got text from element : "+eleName + "And Text is : "+text);
			 return text;
		} catch (Exception e) {
			StartBrowser.childTest.fail("Unable to performe type action action on :"+eleName,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			StartBrowser.childTest.info(e);
			throw e;
		}
	}
	/**
	 * wait for a specific element for given time
	 * @param locator -- get it from OR
	 * @param time -- max time to wait for element
	 * @param eleName -- name of the element
	 * @throws Exception
	 */
	public void explicitWait(By locator, int time, String eleName) throws Exception
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, time);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			StartBrowser.childTest.pass("Successfully waited for "+eleName );
		} catch (Exception e) {
			StartBrowser.childTest.fail("Unable to find element :"+eleName ,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			StartBrowser.childTest.info(e);
			throw e;
		}
	}
	/**
	 * Used for handling alert, it will click Ok button of alert
	 * @param eleName -- Name of the alert
	 * @throws Exception
	 */
	public void handleAlert(String eleName) throws Exception
	{
		try {
			//this will perform click action on alert OK button
			driver.switchTo().alert().accept();
			StartBrowser.childTest.pass("Successfully handled alert "+eleName );
		} catch (Exception e) {
			StartBrowser.childTest.fail("Unable to Handle Alert :"+eleName ,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			StartBrowser.childTest.info(e);
			throw e;
		}
	}
	/**
	 * Used to get alert message from alert box
	 * @param eleName -- Name of the alert
	 * @return -- alert message
	 * @throws Exception
	 */
	public String getAlertText(String eleName) throws Exception
	{
		try {
			String aMsg=driver.switchTo().alert().getText();
			StartBrowser.childTest.pass("Alert message is "+aMsg );
			return aMsg;
		} catch (Exception e) {
			StartBrowser.childTest.fail("Unable get alert msg :"+eleName,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			StartBrowser.childTest.info(e);
			throw e;
		}
	}
	/**
	 * Used to switch to frame by WebElement
	 * @param locator -- get it from OR
	 * @throws Exception
	 */
	public void switchToFrame(By locator) throws Exception
	{
		try {
			WebElement we=driver.findElement(locator);
			driver.switchTo().frame(we);
			StartBrowser.childTest.pass("Successfully switched to frame");
		} catch (Exception e) {
			StartBrowser.childTest.fail("Unable switch to frame :",
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			StartBrowser.childTest.info(e);
			throw e;
		}
		
	}
	/**
	 * used to switch to Child window
	 * @throws Exception
	 */
	public void switchToChildWindow() throws Exception
	{
		try {
			String pwindow=driver.getWindowHandle();
			Set<String> windows=driver.getWindowHandles();
			//remove parent window
			windows.remove(pwindow);
			//switch to child window
			driver.switchTo().window(windows.iterator().next());
			StartBrowser.childTest.pass("Successfully switched to Child window : "+driver.getTitle());
		} catch (Exception e) {
			StartBrowser.childTest.fail("Unable switch to Cild window :",
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			StartBrowser.childTest.info(e);
			throw e;
		}
	}
	
	
	/**
	 * used to perform drag and drop 
	 * @throws Exception
	 */
	public void dragAndDrop(By locator1, By locator2) throws Exception
	{
		try {
			Actions act = new Actions(driver);
			WebElement src=driver.findElement(locator1);
			WebElement dst = driver.findElement(locator2);
			act.dragAndDrop(src, dst).perform();
			StartBrowser.childTest.pass("Successfully drag and drop performed on : "+driver.findElement(locator1));
		} catch (Exception e) {
			StartBrowser.childTest.fail("Unable switch to Cild window :",
			MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			StartBrowser.childTest.info(e);
			throw e;
		}
	}
	
	/**
	 * used as dynamic wait for element to load  
	 * @throws Exception
	 */
	public void waitFOrEle(WebDriver driver,String xpath) throws InterruptedException {
		
		try {
		for (int i = 0; i < 10; i++) {
					
			int size=driver.findElements(By.xpath(xpath)).size();
			if(size>0) {
				break;
			}else {
				Thread.sleep(1000);
				System.out.println(i);
				continue;
			}
		}
		} catch (Exception e) {

		}
		
	}
	
	public String screenShot()
	{
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	}
	
	
	public void scrollToEle(WebDriver driver,WebElement ele)
	{
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ele);
	}
	
}

