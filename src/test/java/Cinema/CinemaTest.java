package Cinema;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		driver.get("http://140.121.196.23:4107/");
		String title = driver.getTitle();			
		Assert.assertTrue(title.contains("Cinema - Home")); 		
	}
	/*
	@Test
	//測試是否拿到所有電影資料
	public void testGetMovieList()
	{
		//拿到變數 movieData 
		// Use the timeout when navigating to a webpage
		driver.get("http://140.121.196.23:4107/");
		waitForPageLoaded();
		WebElement element = driver.findElement(By.id("MovieListModal"));
		//Object result = js.executeScript("return movieData");
		System.out.println("data:"+element.getText());
		System.out.println(driver.getPageSource());
		
		
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
		//driver.quit();			
	}	
	
	public void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }
}
