package com.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.air.testbase.TestBase;
import com.air.page.FlightsPage;

public class AirAsiaTest extends TestBase {
	FlightsPage flightsPage;
	
	public AirAsiaTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		flightsPage = new FlightsPage();
	}
	
	@Test
	public void FlightsTest() throws InterruptedException {
		flightsPage.searchFlights("Hyderabad (HYD)", "Bengaluru (BLR)");
		Thread.sleep(5000);
		
		
	}
	
	

}
