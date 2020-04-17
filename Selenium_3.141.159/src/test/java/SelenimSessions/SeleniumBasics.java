package SelenimSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumBasics {

	public static void main(String[] args) {
		String projectPath =System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver", projectPath+"/Drivers/GeckoDriver/geckodriver.exe");	
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.google.com");
		driver.close();
		System.setProperty("webdriver.chrome.driver", projectPath+"/Drivers/ChromeDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://www.facebook.com");
		String name = driver.getTitle();
		System.out.println(name);
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getPageSource());
		if(name.equals("Facebook – log in or sign up")) {
			System.out.println("correct");
		}else {
			System.out.println("not correct");
		}
		driver.quit();

	}

}
