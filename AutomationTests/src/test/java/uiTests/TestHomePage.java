package uiTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
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
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		actions = new Actions(driver);
		
	}
	
	@Test
	public void testCardsVisible() throws InterruptedException 
	{
		HomePage homepage = new HomePage(driver);

		driver.get("https://demoqa.com/");
		String page_title = homepage.get_title();		
		Assert.assertEquals(page_title, "DEMOQA", "Incorrect Page Title");
		actions.moveToElement(homepage.getFormsBtn()).perform();
		actions.click();	
		Thread.sleep(15);
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
	}
}
