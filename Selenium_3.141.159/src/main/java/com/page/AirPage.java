package com.page;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.ByAngularButtonText;
import com.paulhammant.ngwebdriver.ByAngularModel;
import com.paulhammant.ngwebdriver.NgWebDriver;

public class AirPage {
	
	public static WebDriver driver;
	public String projectPath =System.getProperty("user.dir");
	
	
	
	
	
	
	public AirPage() {
		System.setProperty("webdriver.chrome.driver", projectPath+"/Drivers/ChromeDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//jsDriver = (JavascriptExecutor)driver;
		//ngWebDriver = new NgWebDriver(jsDriver);
		driver.get("https://www.airasia.com/en/gb");
		//ngWebDriver.waitForAngularRequestsToFinish();
		
	}
	
	public String SearchFlights(String FromTxt, String ToTxt) {
		WebElement fromTxt = driver.findElement(By.xpath("//div[@class = 'css-1dbjc4n r-14lw9ot r-6t5ypu r-zmljjp r-1txwhvf r-cdmcib r-1phboty r-kicko2 r-t12b5v r-1mbl9jf r-1mwlp6a r-1g40b8q']/div/input"));
		WebElement toTxt = driver.findElement(By.xpath("//div[@class = 'css-1dbjc4n r-14lw9ot r-pm2fo r-1dpl46z r-1txwhvf r-cdmcib r-1phboty r-ou6ah9 r-notknq r-1mbl9jf r-1mwlp6a r-1g40b8q']/div/input"));
		fromTxt.clear();
		fromTxt.sendKeys(FromTxt);
		toTxt.sendKeys(ToTxt);
		ByAngularButtonText go = ByAngular.buttonText("Search");
		driver.findElement(go).click();
		return driver.getTitle();
		
	}

}
