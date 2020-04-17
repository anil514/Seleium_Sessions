package TestNg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoogleTest {
	static WebDriver driver;
	@BeforeTest
	public void setUp() {
		String projectPath =System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/Drivers/ChromeDriver/chromedriver.exe");
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://www.popuptest.com/goodpopups.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@Test(priority=1, groups="title")
	//@Test(enabled=false, expectedExceptions = NumberFormatException.class )
	public void getTitle() {
		System.out.println(driver.getTitle());
		//int i = 9/0;
		String a = "100A";
		Integer.parseInt(a);
	}
	@Test(priority=2, groups="title", dependsOnMethods="getTitle")
	public void getTest() {
		System.out.println("Test1");
	}
	@Test(priority=4, groups="rev", invocationCount=10)
	public void getTest2() {
		System.out.println("test2");
	}
	@Test(priority=3, groups="rev", timeOut=2000)
	public void getTest3() {
		System.out.println("test3");
		int i =0;
		while(i==1) {
			System.out.println(i);
		}
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
