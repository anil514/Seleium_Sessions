package SelenimSessions;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;

import com.screenshot.base.CustomListener;
import com.screenshot.base.ScreenshotBase;

@Listeners(CustomListener.class)
public class ScreenshotTest extends ScreenshotBase {
	
	@BeforeMethod
	public void setUp() {
		initialization();
	}
	
	@Test
	public void Test1() {
		Assert.assertEquals(false, true);
	}
	
	@Test
	public void Test2() {
		Assert.assertEquals(false, true);
	}
	
	@Test
	public void Test3() {
		Assert.assertEquals(false, true);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
