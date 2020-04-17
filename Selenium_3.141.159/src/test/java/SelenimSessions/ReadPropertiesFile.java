package SelenimSessions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadPropertiesFile {
	static WebDriver driver;

	public static void main(String[] args) throws IOException {
		String projectPath =System.getProperty("user.dir");
		 
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream(projectPath+"/src/test/java/config.properties");
		prop.load(ip);
		System.out.println(prop.getProperty("name"));
		System.out.println(prop.getProperty("age"));
		String url = prop.getProperty("URL");
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", projectPath+"/Drivers/ChromeDriver/chromedriver.exe");
		  driver = new ChromeDriver();	
		}else if(browserName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath+"/Drivers/GeckoDriver/geckodriver.exe");
			  driver = new FirefoxDriver();
		}else if(browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver", projectPath+"/Drivers/GeckoDriver/internetexplorerdriver.exe");
			  driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);
		driver.findElement(By.xpath(prop.getProperty("reg_xpath"))).click();
		driver.findElement(By.xpath(prop.getProperty("fn_xpath"))).sendKeys("firstName");
		driver.findElement(By.xpath(prop.getProperty("ln_xpath"))).sendKeys("lastName");
		driver.findElement(By.xpath(prop.getProperty("e_xath"))).sendKeys("email");
	}

}
