package SelenimSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class BasicAuthenticationPopUp {

	public static void main(String[] args) {
		String projectPath =System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/Drivers/ChromeDriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//formate:--->http://username:password@url
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		String message = driver.findElement(By.cssSelector("p")).getText();
		System.out.println(message);
		Assert.assertEquals(message, "Congratulations! You must have the proper credentials.");
		driver.close();

	}

}
