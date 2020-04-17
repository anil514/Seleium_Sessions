package SelenimSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebTable {

	public static void main(String[] args) throws InterruptedException {
		String projectPath =System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/Drivers/ChromeDriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://ui.cogmento.com/");
		driver.findElement(By.name("email")).sendKeys("potla2714@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Anil@514");		 	
		WebElement btn = driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']"));
		btn.click();
		driver.findElement(By.xpath("//span[contains(text(), 'Contacts')]")).click();
		Thread.sleep(2000);
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("history.go(0)");
		driver.findElement(By.xpath("//td[contains(text(), 'ANI 27')]/preceding-sibling::td//div[@class='ui fitted read-only checkbox']"))
		.click();
		
		//td[contains(text(), 'ANI 27')]/parent::tr//preceding-sibling::tr//div[@class='ui fitted read-only checkbox']
		//td[contains(text(), 'ANI 27')]/preceding-sibling::td//div[@class='ui fitted read-only checkbox']
		
		//td[contains(text(),'ANI 27')]

	}

}
