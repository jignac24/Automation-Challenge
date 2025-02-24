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
	
	private By cards = By.className(".category-cards");
	public By formsBtn = By.cssSelector(".category-cards > div:nth-child(2)");
	public By formsCard = (By.xpath("//h5[text()='Forms']"));
	
	
	public WebElement getFormsBtn() {
		return driver.findElement(formsCard);
	}
	
	public WebElement getCards() {
		return driver.findElement(cards);
	}

}
