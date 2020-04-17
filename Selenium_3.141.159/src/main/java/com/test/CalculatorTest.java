package com.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.page.CalculatorPage;

public class CalculatorTest extends CalculatorPage{
	CalculatorPage calculatorPage;
	
	@BeforeMethod
	public void setUp() {
		calculatorPage = new CalculatorPage();
	}
	
	@Test(priority =1)
	public void sum() {
		String res = calculatorPage.doSum("20", "30");
		Assert.assertEquals(res, "50");
	}
	@Test (priority = 2)
	public void sub() {
		String res = calculatorPage.doSub("30", "20");
		Assert.assertEquals(res, "10");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
