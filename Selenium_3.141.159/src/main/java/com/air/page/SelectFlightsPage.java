package com.air.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.air.testbase.TestBase;

public class SelectFlightsPage extends TestBase{
	@FindBy(xpath = "//div//h2[@id= 'origin-destination-label-desc']")
	WebElement departName;
	
	public SelectFlightsPage() {
		PageFactory.initElements(driver, this);
	}
	
  public String getDepartDetails() {
		return departName.getText();
	}

}
