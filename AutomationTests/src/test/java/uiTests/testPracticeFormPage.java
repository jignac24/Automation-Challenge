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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import uiPageObject.HomePage;
import uiPageObject.PracticeFormPage;
import uiPageObject.Base.Base;

public class testPracticeFormPage extends Base
{
	public WebDriver driver;
	public Actions actions;	
	HomePage homepage;
	PracticeFormPage practicePage;
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();		
		driver.get("https://demoqa.com/");
		
	}

	@Test
	public void fillForm() 
	{
		homepage = new HomePage(driver);
		practicePage = new PracticeFormPage(driver);
		
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Locate "Forms" card
        WebElement formsCard = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h5[text()='Forms']")));
        // Scroll into view before clicking
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", formsCard);
        // Wait for it to be clickable        
        wait.until(ExpectedConditions.elementToBeClickable(formsCard)).click();      
        
        // Clicking on Practice Form   
        find_locator(practicePage.practiceform).click();
        
        //Filling the form
        practicePage.find_element(practicePage.firstname).sendKeys("testing");
        practicePage.find_element(practicePage.lastname).sendKeys("last");
        practicePage.find_element(practicePage.useremail).sendKeys("test@gmail.com");
        practicePage.select_radio("Male");
        
        
        
	  
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
	}
}
