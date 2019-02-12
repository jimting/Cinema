package Cinema;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CinemaTest {

	private WebDriver driver;		
		
	@Before
	public void beforeTest() 
	{	
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();

		// Tell the Java bindings to use Marionette.
		// This will not be necessary in the future,
		// when Selenium will auto-detect what remote end
		// it is talking to.
		capabilities.setCapability("marionette", true);

		driver = new RemoteWebDriver(capabilities);
	    //driver = new FirefoxDriver();  
	}		
	
	@Test				
	public void testEasy() 
	{	
		driver.get("main/resources/static/index.html");  
		String title = driver.getTitle();				 
		Assert.assertTrue(title.contains("Cinema - Home")); 		
	}
	
	@After
	public void afterTest() 
	{
		driver.quit();			
	}		

}
