package com.gcr.scripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.gcr.config.StartBrowser;


public class TC4_Asserts extends StartBrowser{

	@Test

	public void Soft_Assert() {
		
		SoftAssert assertion = new SoftAssert();
		System .out.println("Before Assert");
		assertion.assertEquals("Hello","Hellos");
		System .out.println("After Assert");
		assertion.assertAll();
		
	
	}
	
}
