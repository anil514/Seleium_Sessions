package SelenimSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarSelect {

	public static void main(String[] args) {
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
		driver.findElement(By.xpath("//span[contains(text(), 'Calendar')]")).click();
		String date = "12-March-2020";
		String dateArr[] = date.split("-");  //{12,March,2020}
		String day = dateArr[0];
		String month = dateArr[1];
		String year = dateArr[2];				
		//div[6]//div[2]//div[1]//div[1]
		//div[6]//div[2]//div[1]//div[2]
		//div[@class='rbc-month-row']/div[1]/div[1]
		String beforePath = "//div[@class='rbc-month-row']//div[";
		String afterPath = "]//div[";
		final int weekDays = 7;		
		boolean flag = false;
		for(int rowNum =2; rowNum<=7; rowNum++) {
			for(int colNum = 1; colNum<=weekDays; colNum++) {
				String dayVal = driver.findElement(By.xpath(beforePath+rowNum+afterPath+colNum+"]")).getText();
				System.out.println(dayVal);
				if(dayVal.equals(day)) {
					driver.findElement(By.xpath(beforePath+rowNum+afterPath+colNum)).click();
					flag = true;
					break;
				}
			}
			if(flag) {
				break;
			}
			
		}

	}

}
