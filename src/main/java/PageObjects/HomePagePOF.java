package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePagePOF {
	
	WebDriver driver;
	public HomePagePOF(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath="//div[@id='u_0_a']/div/div/div/a")
	WebElement ProfileButton;
	@FindBy(xpath="//a[@action='cancel']")
	WebElement cancelNotification;
	@FindBy(xpath="//*[@id=\"u_0_a\"]/div[1]/div[1]/div/a/span/span\n")
	WebElement Name;
	@FindBy(xpath="//*[@id=\"u_0_a\"]")
	WebElement NavBar;
	@FindBy(xpath="//*[@id=\"userNavigationLabel\"]")
	WebElement NavLabel;
	@FindBy(xpath="//div[@id=\"BLUE_BAR_ID_DO_NOT_USE\"]/div/div/div/div/div/ul/li[12]")
	WebElement LogoutButton;
	
	public WebElement ProfileButton()
	{
		return ProfileButton;
	}
	public WebElement cancelNotification()
	{
		return cancelNotification;
	}
	public WebElement Name()
	{
		return Name;
	}
	public WebElement NavBar()
	{
		return NavBar;
	}
	
	public WebElement NavLabel()
	{
		return NavLabel;
	}
	public WebElement LogoutButton()
	{
		return LogoutButton;
	}

}
