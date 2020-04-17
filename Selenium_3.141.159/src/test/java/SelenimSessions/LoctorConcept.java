package SelenimSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoctorConcept {

	public static void main(String[] args) {
		String projectPath =System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/Drivers/ChromeDriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://login.yahoo.com/");
		//driver.findElement(By.xpath("//input[@id='login-username']")).sendKeys("Anil");
		driver.findElement(By.cssSelector("input[id='login-username']")).sendKeys("Anil");
		//xpath -> //input[contains(@class, 'text')]
		////input[contains(text(),'text')]
		driver.close();

	}

}
