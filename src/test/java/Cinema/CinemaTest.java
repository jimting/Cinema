package Cinema;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CinemaTest {

	private WebDriver driver;		
	@Test				
	public void testEasy() {	
		driver.get("http://140.121.196.23:4107/");  
		String title = driver.getTitle();				 
		Assert.assertTrue(title.contains("Cinema - Home")); 		
	}	
	@Before
	public void beforeTest() {	
	    driver = new FirefoxDriver();  
	}		
	@After
	public void afterTest() {
		driver.quit();			
	}		

}
