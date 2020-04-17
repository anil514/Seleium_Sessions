package com.air.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.air.testbase.TestBase;

public class FlightsPage extends TestBase{
	@FindBy(xpath = "//div[@class = 'css-1dbjc4n r-14lw9ot r-6t5ypu r-zmljjp r-1txwhvf r-cdmcib r-1phboty r-kicko2 r-t12b5v r-1mbl9jf r-1mwlp6a r-1g40b8q']/div/input")
	WebElement fromTxt; 
	
	@FindBy(xpath = "//div[@class = 'css-1dbjc4n r-14lw9ot r-pm2fo r-1dpl46z r-1txwhvf r-cdmcib r-1phboty r-ou6ah9 r-notknq r-1mbl9jf r-1mwlp6a r-1g40b8q']/div/input")
	WebElement toTxt; 
	
	@FindBy(xpath = "//div[@id = 'aa-web-search-button']")
	WebElement searchBtn; 
	
	public FlightsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public SelectFlightsPage searchFlights(String FromTxt, String ToTxt) {
		//driver.findElement(By.xpath("//")).sendKeys("");
		fromTxt.sendKeys(FromTxt);
		toTxt.sendKeys(ToTxt);
		searchBtn.submit();
		return new SelectFlightsPage();
	}
	

}
