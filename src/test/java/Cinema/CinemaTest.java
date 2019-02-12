package Cinema;

import java.nio.file.Path;
import java.nio.file.Paths;

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
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();

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
		Path sampleFile = Paths.get("index.html");
		driver.get(sampleFile.toUri().toString());
		//driver.get("main/resources/static/index.html");  
		String title = driver.getTitle();				 
		Assert.assertTrue(title.contains("Cinema - Home")); 		
	}
	
	@After
	public void afterTest() 
	{
		driver.quit();			
	}		

}
