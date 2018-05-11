package Resources;

import java.io.File;
import java.io.FileInputStream;
import org.apache.commons.io.FileUtils;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	//define webdriver object once
	public static WebDriver driver;
	public Properties prop = new Properties();
	public WebDriver InitializeDriver() throws IOException {
		
		FileInputStream file = new FileInputStream("/Users/Melissa/eclipse-workspace/E2EProject/src/main/java/Resources/data.properties");
		prop.load(file);
		String browser = prop.getProperty("browser");
		
		if(browser.contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "/Users/Melissa/Documents/Selenium-eclipse-files/Drivers/chromedriver");
			driver = new ChromeDriver();
		}
		else if(browser.contains("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","/Users/Melissa/Documents/Selenium-eclipse-files/Drivers/geckoriver");
			driver = new FirefoxDriver();
		}
		else
		{
			//explorer
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//return the driver with all the properties set(kind of driver, implicit wait)
		return driver;
	}
	public void getScreenshot(String result) throws IOException {
		
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("/Users/Melissa/Downloads/"+result+"screenshot.png"));
    }

}
