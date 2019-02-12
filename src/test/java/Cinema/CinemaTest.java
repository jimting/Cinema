package Cinema;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CinemaTest {

	private WebDriver driver;		
		
	@Before
	public void beforeTest() 
	{	
		//設定要用什麼瀏覽器來測試
		System.setProperty("webdriver.chrome.driver","src/lib/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		driver = new ChromeDriver(options);
	}		
	
	@Test				
	public void testTitle() 
	{	
		//看看首頁的Title文字是否正確
		driver.get("http://140.121.196.23:4107/");
		String title = driver.getTitle();			
		System.out.print("Title:"+title);
		Assert.assertTrue(title.contains("Cinema - Home")); 		
	}
	
	@After
	public void afterTest() 
	{
		//結束測試
		driver.quit();			
	}		

}
