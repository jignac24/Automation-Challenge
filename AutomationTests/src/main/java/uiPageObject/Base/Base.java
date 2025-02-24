package uiPageObject.Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	public WebDriver driver;
	public Properties property;
	
	
	public WebDriver initializeDriver() throws IOException
	{
		// String browserName = property.getProperty("browser");
		String browserName = "Chrome";
		if(browserName.equals("Chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browserName.equals("Firefox")){
			driver = new FirefoxDriver();
		}
		else {
			System.out.println(browserName + " is not a valid browser");
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		return driver;
		
		
	}
	
	public Properties loadConfig() throws IOException 
	{
		property = new Properties();
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/java/resource/config.properties");

		property.load(file);
		return property;
	}

}
