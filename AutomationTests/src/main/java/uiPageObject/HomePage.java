package uiPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage 
{
	public WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String get_title() {
		return driver.getTitle();
	}
	
	private By formsBtn = By.xpath("(//div[@class='card mt-4 top-card'])[2]");
	// ".category-cards > div:nth-child(2)"	
	private By cards = By.className(".category-cards");
	
	public WebElement getFormsBtn() {
		return driver.findElement(formsBtn);
	}
	
	public WebElement getCards() {
		return driver.findElement(cards);
	}

}
