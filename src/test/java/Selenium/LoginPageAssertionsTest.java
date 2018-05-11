package Selenium;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.AssertJUnit;
import java.io.IOException;
import PageObjects.LoginPagePOF;
import Resources.Base;

public class LoginPageAssertionsTest extends Base{
	
	private static Logger log=LogManager.getLogger(HomePageTest.class.getName());
	
	@BeforeTest
	public void Init() throws IOException
	{
		driver = InitializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	
	@Test
	public void ProfileAssertions() throws IOException
	{
		LoginPagePOF l = new LoginPagePOF(driver);
		AssertJUnit.assertEquals(l.CrearCtaLink().getText(), "Crea una página");
		log.info("frase existente");
		
	}
	@AfterTest
	public void CloseDriver()
	{
		driver.close();
		driver=null;
	}

}
