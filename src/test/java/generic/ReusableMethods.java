package generic;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ReusableMethods 
{
	public void mouseHover(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	public void rightClick(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	public void selectByPosition(WebElement element, int index)
	{
		Select s = new Select(element);
		s.selectByIndex(index);;
	}
	public List<String> selectAllOptions(WebElement element)
	{
		Select s = new Select(element);
		List<WebElement> options = s.getOptions();
		List<String> l =  new ArrayList<String>();
		for(WebElement we: options)
		{
			l.add(we.getText());
		}
		return l;
	}
	
}
