package SelenimSessions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootstrapDropDown {

	public static void main(String[] args) {
		String projectPath =System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/Drivers/ChromeDriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.findElement(By.xpath("//button[@class='multiselect dropdown-toggle btn btn-default']")).click();
		List<WebElement> list = driver.findElements(By.xpath("//ul[contains(@class, 'multiselect-container dropdown-menu')]//li//a//label"));
		System.out.println(list.size());
		for(int i =0; i<list.size(); i++) {
			System.out.println(list.get(i).getText());
			//list.get(i).click();
			if(list.get(i).getText().equals("Java")) {
				list.get(i).click();
				break;
			}
		}

	}

}
