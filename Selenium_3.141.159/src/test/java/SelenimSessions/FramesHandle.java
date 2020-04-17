package SelenimSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesHandle {

	public static void main(String[] args) {
		String projectPath =System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/Drivers/ChromeDriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		List<WebElement> list = driver.findElements(By.tagName("iframe"));
		System.out.println(list.size());
		driver.switchTo().frame("captcha-recaptcha");
		driver.switchTo().defaultContent();
		driver.close();
		

	}

}
