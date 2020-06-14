package generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Base_Page 
{
	public WebDriver driver;
	public Base_Page(WebDriver driver)//declaration//its a constructor it cant be voild
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void verifytitle(String title, int seconds)
	{
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.titleContains(title));
	}
	
	public void verifyElement(WebElement element, int seconds)
	{
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
