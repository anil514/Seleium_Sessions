package SelenimSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HtmlUnitDriver {

	public static void main(String[] args) {
		String projectPath =System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/Drivers/ChromeDriver/chromedriver.exe");
//		 WebDriver driver = new HtmlUnitDriver();	
//		 driver.manage().deleteAllCookies();
//		 driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
//		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		 driver.get("https://ui.cogmento.com/");
//		 driver.manage().window().maximize();
//		 System.out.println("Before Login: "+driver.getTitle());
//		 driver.findElement(By.name("email")).sendKeys("potla2714@gmail.com");
//		 driver.findElement(By.name("password")).sendKeys("Anil@514");
//		 driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']")).click();
//		 System.out.println("After Login:  "+driver.getTitle());
	}

}
