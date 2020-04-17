package SelenimSessions;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.*;


public class DownloadFileConcept {
	WebDriver driver;
	File folder;

	@BeforeMethod
	public void setUp() {
		//some random geneartes this UUID
		folder = new File(UUID.randomUUID().toString());
		folder.mkdir(); // it return booalen, that file got generate or not
		String projectPath =System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/Drivers/ChromeDriver/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		//settings for, when click on download there is no popup, please display any popups
		prefs.put("profile.default_content_settings.popups", 0); 
		//it provide default directory path
		prefs.put("download.default.directory", folder.getAbsolutePath());
		options.setExperimentalOption("prefs", prefs);
		DesiredCapabilities dc = DesiredCapabilities.chrome();
		dc.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(dc);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		for(File file : folder.listFiles()) {
			file.delete();
		}
		folder.delete();
	}
	
	@Test
	public void dowloadTest() throws InterruptedException {
		driver.get("https://the-internet.herokuapp.com/download");
		driver.findElement(By.linkText("some-file.txt")).click();
		Thread.sleep(2000);
		File listOfFiles[] = folder.listFiles();
		//make sure directory is not empty
	//	Assert.assertEquals(listOfFiles.length, is(not(0)));
		//Assert.assertTrue(listOfFiles.length>0);
		for(File file : listOfFiles) {
			//make sure that download file is not empty
			//Assert.assertEquals(listOfFiles.length, is(not(0)));
			Assert.assertTrue(file.length()>0);
		}
	}
	

}
