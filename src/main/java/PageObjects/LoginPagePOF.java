package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPagePOF {
	
	WebDriver driver;
	public LoginPagePOF(WebDriver driver)
	{
		//this.driver refers to the driver created on the class and = driver refers to the driver that is passed from the test Classes
		this.driver= driver;
		//need pagefactory.initelements to initializes the elements
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="#email")
	WebElement username;
	
	@FindBy(css="#pass")
	WebElement password;
	
	@FindBy(css="input[value='Iniciar sesión']")
	WebElement LoginButton;
	
	@FindBy(xpath="//div[@id='reg_pages_msg']/a")
	WebElement CrearCtaLink;
	
	public WebElement username()
	{
		return username;
	}
	public WebElement password()
	{
		return password;
	}
	public WebElement LoginButton()
	{
		return LoginButton;
	}
	public WebElement CrearCtaLink()
	{
		return CrearCtaLink;
	}
	

}
