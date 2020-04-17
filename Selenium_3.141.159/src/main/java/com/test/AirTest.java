package com.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.page.AirPage;


public class AirTest extends AirPage {
	AirPage airPage;


	
	@BeforeMethod
	public void setUp() {
		airPage = new AirPage();
	}
	
	@Test
	public void Airtest() {
		airPage.SearchFlights("Hyderabad (HYD)", "Bengaluru (BLR)");
	}
}
