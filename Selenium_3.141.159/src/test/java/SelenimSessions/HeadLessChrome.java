package SelenimSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadLessChrome {

	public static void main(String[] args) {
		String projectPath =System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/Drivers/ChromeDriver/chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("window-size-1366, 768");
		opt.addArguments("headless");		
		WebDriver driver = new ChromeDriver(opt);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://ui.cogmento.com/");
		System.out.println(driver.getTitle());
		driver.findElement(By.name("email")).sendKeys("potla2714@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Anil@514");		 
		driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']")).click();
		System.out.println("After Login:"+driver.getTitle());
		

	}

}
