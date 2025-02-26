package uiPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PracticeFormPage 
{
	public WebDriver driver;
	
	public PracticeFormPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	public By practiceform = By.cssSelector("div[class='element-list collapse show'] span[class='text']");
	//span[normalize-space()='Practice Form']
	public By firstname = (By.id("firstName"));
	public By lastname = (By.id("lastName"));
	public By useremail = (By.id("userEmail"));
	public By gender = (By.cssSelector("div[id='genterWrapper'] div[class='col-md-9 col-sm-12'] div:nth-child(1)"));
	public By mobile = (By.id("userNumber"));
	public By dob = (By.id("dateOfBirthInput"));
	public By subject = (By.id("subjectsContainer"));
	public By hobby = (By.id("hobbies-checkbox-2")); // 
	public By fileUpload = (By.className("form-control-file"));
	public By address = (By.id("currentAddress"));
	public By state = (By.id("state"));
	public By city = (By.id("city"));
	public By submitButton = (By.cssSelector("#submit"));
	public By selectMonth = (By.cssSelector(".react-datepicker__month-select"));
	public By selectYear = (By.cssSelector(".react-datepicker__year-select"));
		
	
	public WebElement find_element(By element) {
		return driver.findElement(element);
	}
	
	public void set_date(String date) {
		
		WebElement dateField = driver.findElement(dob);

        // Use JavaScript to set the date
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value', date)", dateField);

	}
	
	public void select_DOB(int day) 
	{
		
		// Click on the date picker
		driver.findElement(dob).click();

        // Select the year
        WebElement yearDropdown = driver.findElement(selectYear);
        Select selectYear = new Select(yearDropdown);
        selectYear.selectByVisibleText("1995");

        // Select the month
        WebElement monthDropdown = driver.findElement(selectMonth);
        Select selectMonth = new Select(monthDropdown);
        selectMonth.selectByVisibleText("December");

        // Select the date
        String dateXPath = String.format("//div[contains(@class, 'react-datepicker__day') and text()='%d']", day);
        driver.findElement(By.xpath(dateXPath)).click();    

	}
	
	public WebElement select_checkbox(String hobby) {
        // Parameterized hobby selection checkbox
        
        String hobbyXPath = String.format("//label[normalize-space()='%s']", hobby);
        WebElement hobbyCheckbox = driver.findElement(By.xpath(hobbyXPath));
        return hobbyCheckbox;
        // hobbyCheckbox.click();
	}
	
	public void select_radio(String gender)
	{      
        
        String genderLocator = String.format("//label[normalize-space()='%s']", gender);
        System.out.println("Gender is " + genderLocator);        
        WebElement radio = driver.findElement(By.xpath(genderLocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", radio);       

        // return radio;
        radio.click();
	}

}
