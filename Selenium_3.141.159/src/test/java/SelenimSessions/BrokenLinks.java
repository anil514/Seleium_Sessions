package SelenimSessions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		String projectPath =System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/Drivers/ChromeDriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		System.out.println(driver.getTitle());
		System.out.println("After Login:"+driver.getTitle());
		//links are available with //a tag
		List<WebElement>list = driver.findElements(By.tagName("a"));
		list.addAll(driver.findElements(By.tagName("img")));
		List<WebElement>activeList = new ArrayList<WebElement>();
		System.out.println(list.size());
		
		for(int i =0; i<list.size(); i++) {
			//doest have href attribute
			if(list.get(i).getAttribute("href")!=null && (! list.get(i).getAttribute("href").contains("javascript"))) {
				activeList.add(list.get(i));
			}
		}
		System.out.println(activeList.size());
		//check the href url with httpconnection api. 
		//check link working or not
		//new URL class
		//New URL(String) --->String =activeList.get(j).getAttribute("href")
		//cast with HttpURLConnection  api
		//200 -Ok
		//404 - not found
		//500 - internal server error
		//400 - Bad request
		for(int j =0; j<activeList.size(); j++) {
			HttpURLConnection con = (HttpURLConnection)new URL(activeList.get(j).getAttribute("href")).openConnection();
			con.connect();
			String response = con.getResponseMessage(); //ok
			con.disconnect();
			//System.out.println("After ALL:"+activeList.size());
			System.out.println(activeList.get(j).getAttribute("href")+"--->"+response);			
		}
	}

}
