package com.gcr.scripts;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import com.gcr.commands.ActionDriver;
import com.gcr.config.StartBrowser;
import com.gcr.reuse.CommonFunctions;

public class TC5_DragDrop extends StartBrowser{
	@Test
	public void Drag_Drop() throws Exception {
		ActionDriver dr = new ActionDriver();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://dhtmlx.com/docs/products/dhtmlxTree");
		dr.waitFOrEle(driver,"(//*[@class='js-iframe active'])[1]");
		driver.switchTo().frame(driver.findElement(By.xpath("(//*[@class='js-iframe active'])[1]")));
		Thread.sleep(10000);
		Actions act = new Actions(driver);
		dr.waitFOrEle(driver,"//span[text()='Bestsellers']");
		WebElement myhome=driver.findElement(By.xpath("//*[text()='All Books']/following::span[text()='Bestsellers']"));
		dr.scrollToEle(driver,myhome);
		WebElement src=driver.findElement(By.xpath("//span[text()='Bestsellers']"));
		WebElement dst = driver.findElement(By.xpath("//li[text()='Zend Framework in Action']"));
		act.dragAndDrop(src, dst).perform();

		
		Thread.sleep(5000);
	}
}
