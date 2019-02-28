package Cinema;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CinemaTest {

	private WebDriver driver;		
	private JavascriptExecutor js;
	@Before
	public void beforeTest() 
	{	
		//設定要用什麼瀏覽器來測試
		System.setProperty("webdriver.chrome.driver","src/lib/chromedriver");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--headless");
		driver = new ChromeDriver(chromeOptions);
		js = (JavascriptExecutor) driver;
	}		
	
	@Test	
	//test index's title
	public void testIndexTitle() 
	{	
		driver.get("http://140.121.196.23:4107/index.html");
		String title = driver.getTitle();			
		Assert.assertTrue(title.contains("Cinema - Home")); 		
	}
	/*
	@Test
	//測試是否拿到所有電影資料
	public void testGetMovieList()
	{
		//拿到變數 movieData 
		driver.get("http://140.121.196.23:4107/index.html");
		
		Object result = js.executeScript("return movieData");
		System.out.print(driver.getPageSource());
	}*/
	
	@Test
	//test shop's title
	public void testShopTitle()
	{
		driver.get("http://140.121.196.23:4107/shop.html");
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
