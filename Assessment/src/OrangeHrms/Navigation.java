package OrangeHrms;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Navigation {
	WebDriver driver;
	String baseURL = "https://opensource-demo.orangehrmlive.com/";
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/usr/bin/psdriver");
		driver = new ChromeDriver();
		driver.get(baseURL);
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	}
	
	@Test
	public void getTitle() throws InterruptedException {
		List<WebElement> links = driver.findElements(By.xpath("//div[@id='social-icons']/a"));
		for(int i=0;i<links.size();i++) {
			driver.navigate().to(links.get(i).getAttribute("href"));
			String title = driver.getTitle();
			System.out.println(title);
			Thread.sleep(3000);
			driver.navigate().back();
		}
	}
}