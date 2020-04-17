package SelenimSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandleCalendarWithJS {

	public static void main(String[] args) {
		String projectPath =System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/Drivers/ChromeDriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.spicejet.com/");
		driver.findElement(By.className("ui-datepicker-trigger")).click();;
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		//js.executeScript("arguments[0].setAttribute('value','30-12-2017')");
		js.executeScript("document.getElementById('ui-datepicker-div').style.display='block';");
		Select select8 = new Select(driver.findElement(By.className("ui-state-default")));
		select8.selectByVisibleText("10/03");

	}

}
