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
	public void beforeTest() {	
	    driver = new FirefoxDriver();  
	}		
	
	@Test				
	public void testEasy() {	
		driver.get("main/resources/static/index.html");  
		String title = driver.getTitle();				 
		Assert.assertTrue(title.contains("Cinema - Home")); 		
	}
	
	@After
	public void afterTest() {
		driver.quit();			
	}		

}
