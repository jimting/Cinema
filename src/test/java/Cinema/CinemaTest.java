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
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--headless");
		driver = new ChromeDriver(chromeOptions);
	}		
	
	@Test				
	public void testIndexTitle() 
	{	
		//看看首頁的Title文字是否正確
		driver.get("file:///var/lib/tomcat8/.jenkins/workspace/Cinema/src/main/resources/static/index.html");
		String title = driver.getTitle();			
		Assert.assertTrue(title.contains("Cinema - Home")); 		
	}
	
	@Test
	public void testShopTitle()
	{
		//看看shop的Title文字是否正確
		driver.get("file:///var/lib/tomcat8/.jenkins/workspace/Cinema/src/main/resources/static/shop.html");
		String title = driver.getTitle();			
		Assert.assertTrue(title.contains("Cinema - Shop")); 		
	}
	
	@After
	public void afterTest() 
	{
		//結束測試
		driver.quit();			
	}		

}
