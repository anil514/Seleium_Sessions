package SelenimSessions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomXpath {

	public static void main(String[] args) {
		String projectPath =System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/Drivers/ChromeDriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.ebay.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//get the all links list and test
		List<WebElement>linkList = driver.findElements(By.tagName("a"));
		System.out.println(linkList.size());
		for(int i =0; i<linkList.size(); i++) {
			String linkText = linkList.get(i).getText();
			System.out.println(linkText);
		}
		
		//driver.findElement(By.xpath("//input[@class='gh-tb ui-autocomplete-input']")).sendKeys("java");
		driver.findElement(By.xpath("//input[contains(@class, 'gh-tb ui-autocomplete-input')]")).sendKeys("Anil");
		
		
		//for dynamic changes....id=test_123, id=test_8767, id=test_986
		//driver.findElement(By.xpath("//input[contains(@id, 'test_')]"));
		//driver.findElement(By.xpath("//input[start-with(@id, 'test_')]"));
		
		//for dynamic changes....id=test_123_t, id=test_8767_t, id=test_986_t
		//driver.findElement(By.xpath("//input[end-with(@id, '_t')]"));
		
		//linktext
		driver.findElement(By.xpath("//li[@class='saved']//a[contains(text(),'Saved')]")).click();
		//Thread.sleep(1000);
		
		
		driver.close();

	}

}
