package SelenimSessions;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {

	public static void main(String[] args) {
		String projectPath =System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/Drivers/ChromeDriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://www.popuptest.com/goodpopups.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		List<WebElement>list = driver.findElements(By.xpath("//a[contains(text(), 'Good PopUp') and not (contains(text(), 'Good PopUp #2'))]"));
		int length = list.size();
		System.out.println(length);
		//driver.findElement(By.xpath("//a[not(contains(text(), 'Good PopUp #3')]")).click();
		for(int i =0; i<length; i++) {
			list.get(i).click();
			Set<String>handle = driver.getWindowHandles();
			Iterator<String>it = handle.iterator();
			String parent = it.next();
			System.out.println("parent: "+parent);
			String child = it.next();
			System.out.println("child: "+child);
			driver.switchTo().window(child);
			String title = driver.getTitle();
			System.out.println("title: "+title);
			driver.close();
			driver.switchTo().window(parent);
		}
		driver.close();

	}

}
