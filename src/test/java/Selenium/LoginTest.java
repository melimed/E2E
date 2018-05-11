package Selenium;

import org.testng.annotations.Test;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
//import org.testng.annotations.DataProvider;
import PageObjects.HomePagePOF;
import PageObjects.LoginPagePOF;
import Resources.Base;

public class LoginTest extends Base{
	
	private static Logger log=LogManager.getLogger(LoginTest.class.getName());
	
	@BeforeTest
	public void Init() throws IOException
	{
		driver = InitializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	/*@Test(dataProvider = "getData")
	public void Login(String username, String password) 
	{
		//si se usan mas de una serie de datos hay q abrir el browser por cada set
		//driver.get(prop.getProperty("url"));
		
		LoginPagePOF LoginPage = new LoginPagePOF(driver);
		
		LoginPage.username().sendKeys(username);
		LoginPage.password().sendKeys(password);
		LoginPage.LoginButton().click();
		log.info("Successfull login");
	}*/
	
	
	@Test
	public void Login() 
	{
		String username= prop.getProperty("username");
		String password= prop.getProperty("password");
		
		LoginPagePOF LoginPage = new LoginPagePOF(driver);
		
		LoginPage.username().sendKeys(username);
		LoginPage.password().sendKeys(password);
		LoginPage.LoginButton().click();
		log.info("Successfull login");
	}
	
	/*@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[2][2];
		data[0][0]="melimed2@hotmail.com";
		data[0][1]="Melimed4@";
		
		data[1][0]="melimed2@gmail.com";
		data[1][1]="Melimed4@";
		
		return data;
	}*/
	@AfterTest
	public void CloseDriver() throws InterruptedException
	{
		HomePagePOF HomePage = new HomePagePOF(driver);
		HomePage.cancelNotification().click();
		HomePage.NavLabel().click();
		HomePage.LogoutButton().click();
		driver.close();
		driver=null;
	}
	

}
