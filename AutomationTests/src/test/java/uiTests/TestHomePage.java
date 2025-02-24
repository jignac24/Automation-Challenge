package uiTests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import uiPageObject.HomePage;
import uiPageObject.Base.Base;

public class TestHomePage extends Base
{
	public WebDriver driver;
	public Actions actions;	
	HomePage homepage;
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();		
		driver.get("https://demoqa.com/");
		
	}
	
	@Test
	public void testHomePageTitle()
	{		
		homepage = new HomePage(driver);
		String page_title = homepage.get_title();		
		Assert.assertEquals(page_title, "DEMOQA", "Incorrect Page Title");
		
	}
	
	@Test
	public void testFormsCard() throws InterruptedException 
	{
		homepage = new HomePage(driver);
		actions = new Actions(driver);
		
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Locate "Forms" card
        WebElement formsCard = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h5[text()='Forms']")));
        // Scroll into view before clicking
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", formsCard);
        // Wait for it to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(formsCard)).click();
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
	}
}
