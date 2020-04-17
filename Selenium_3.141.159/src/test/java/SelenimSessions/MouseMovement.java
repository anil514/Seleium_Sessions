package SelenimSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseMovement {

	public static void main(String[] args) throws InterruptedException {
		String projectPath =System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/Drivers/ChromeDriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.spicejet.com/");
		driver.manage().window().setPosition(new Point(-2000, 0));
		driver.manage().window().maximize();
		//Dimension d = new Dimension(1000, 670);
		//driver.manage().window().setSize(d);
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.id("highlight-addons"))).build().perform();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Hot Meals")).click();
		act.moveToElement(driver.findElement(By.id("Login")))
		.moveToElement(driver.findElement(By.xpath("//a[text()='SpiceClub Members']"))).build().perform();
		driver.findElement(By.linkText("Member Login")).click();
		driver.close();
		
		

	}

}
