package Selenium;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import PageObjects.HomePagePOF;
import PageObjects.LoginPagePOF;
import Resources.Base;

public class HomePageTest extends Base{
	
	private static Logger log=LogManager.getLogger(HomePageTest.class.getName());
	
	@BeforeTest
	public void Init() throws IOException
	{
		driver = InitializeDriver();
		driver.get(prop.getProperty("url"));
	}
	@Test
	public void Login() 
	{
		String username= prop.getProperty("username");
		String password= prop.getProperty("password");
		
		LoginPagePOF LoginPage = new LoginPagePOF(driver);
		
		LoginPage.username().sendKeys(username);
		LoginPage.password().sendKeys(password);
		LoginPage.LoginButton().click();
		log.info("Successful login");
	}
	
	@Test
	public void openProfile()
	{
		
		HomePagePOF HomePage = new HomePagePOF(driver);
		HomePage.cancelNotification().click();
		log.info("in home page");
		AssertJUnit.assertEquals(HomePage.Name().getText(), "Melissa");
		AssertJUnit.assertTrue(HomePage.NavBar().isDisplayed());
		HomePage.ProfileButton().click();
		log.info("In profile page");
	}
	
	@AfterTest
	public void CloseDriver()
	{
		driver.close();
		driver=null;
	}
	

}
