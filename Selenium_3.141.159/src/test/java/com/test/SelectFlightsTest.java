package com.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.air.page.FlightsPage;
import com.air.page.SelectFlightsPage;
import com.air.testbase.TestBase;

public class SelectFlightsTest extends TestBase{
	FlightsPage flightsPage;
	SelectFlightsPage selectFlightsPage;
	public SelectFlightsTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		flightsPage = new FlightsPage();
	}
	
	@Test
	public void selectFlightsDepartName() {
		flightsPage.searchFlights("Hyderabad (HYD)", "Bengaluru (BLR)");
		System.out.println(selectFlightsPage.getDepartDetails());
	}
	
	

}
