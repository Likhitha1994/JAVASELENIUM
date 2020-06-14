package pom;

import generic.Base_Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends Base_Page
{
	//declartion
	
	//@FindBy(xpath ="")
	//private WebElement profile;
	
	//@FindBy(xpath ="")
	//private WebElement log;
	
	@FindBy(xpath="//input[@class='_2zrpKA _1dBPDZ']")
	private WebElement username;
	
	@FindBy(xpath = "//input[@type='password']")
	private WebElement password;
	
	@FindBy(xpath = "//button[@class='_2AkmmA _1LctnI _7UHT_c']")
	private WebElement login;
	
	//initialization
	public LoginPage(WebDriver driver) {
		super(driver);//calling the generic constructor from base_page
	}

	//utilization
	//public void clicklog() 
	//{
	//	verifyElement(log, 5);
	//	log.click();
	//}
	public void setUsername(String Username1) 
	{
		verifyElement(username, 5);
		username.sendKeys(Username1);//whatever data present in Username9 from Pom
	}
	public void setPassword(String Password1) 
	{
		verifyElement(password, 5);
		password.sendKeys(Password1);;
	}
	public void Login() 
	{
		verifyElement(login, 5);
		login.click();
		
	}
	//utilization
	//public void MouseoverONProfile(WebDriver driver)
	//{
		//verifyElement(profile, 5);
		//Actions act = new Actions(driver);
		//act.moveToElement(profile).perform();
	//}

}
