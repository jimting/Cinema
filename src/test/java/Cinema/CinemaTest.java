package Cinema;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CinemaTest {

	private WebDriver driver;		
		
	@Before
	public void beforeTest() 
	{	
		//設定要用什麼瀏覽器來測試
		System.setProperty("webdriver.gecko.driver","src/lib/geckodriver");
		driver = new FirefoxDriver();
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
