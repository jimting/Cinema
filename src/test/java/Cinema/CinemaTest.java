package Cinema;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.json.JSONArray;
import org.json.JSONException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
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
	@Test
	//測試是否拿到所有電影資料
	public void testGetMovieList()
	{
		//拿到變數 movieData 並確認電影資料
		// Use the timeout when navigating to a webpage
		driver.get("http://140.121.196.23:4107/");
		//等個幾秒 讓頁面Ajax loading好
		waitForPageLoaded();
		try {
			//拿到了
			JSONArray movieData = new JSONArray((String)js.executeScript("return JSON.stringify(movieData);"));
			
			//如果第3筆資料的電影名稱是 "妖貓傳" ，就通過
			Assert.assertTrue(movieData.getJSONObject(3).getString("MovieName").contains("妖貓傳"));
		
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/*
	
	@Test	
	//測試購買新電影
	public void testOrderNewMovie() 
	{	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://140.121.196.23:4107/");
		//等個幾秒 讓頁面Ajax loading好
		waitForPageLoaded();
		
		//這裡要購買第三部電影 妖貓傳 ID是 : 5c35ddefa3f01c41d8bb4174
		//先點擊電影列表
		System.out.println(driver.getPageSource());
		driver.findElement(By.xpath("//button[@data-target='#MovieListModal']")).click();
		//再點擊妖貓傳的選擇框框
		driver.findElement(By.xpath("//input[@value=\"5c35ddefa3f01c41d8bb4174\"]")).click();
		
		//呼叫購買function
		js.executeScript("return checkMovie();");
		//拿到alert訊息
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println("Alert訊息 : "+alertText);
		Assert.assertTrue(!alertText.contains("error")); 		
	}
	*/
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
