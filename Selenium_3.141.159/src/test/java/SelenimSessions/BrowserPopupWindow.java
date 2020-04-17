package SelenimSessions;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserPopupWindow {

	public static void main(String[] args) throws InterruptedException {
		String projectPath =System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/Drivers/ChromeDriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://www.popuptest.com/goodpopups.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[contains(text(), 'Good PopUp #3')]")).click();
		Thread.sleep(2000);
		Set <String> handler = driver.getWindowHandles();
		Iterator <String> it = handler.iterator();
		String parent = it.next();
		System.out.println("parent"+parent);
		String child = it.next();
		System.out.println("child"+child);
		driver.switchTo().window(child);
		Thread.sleep(1000);
		System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(parent);
		System.out.println(driver.getTitle());
		driver.quit();

	}

}
