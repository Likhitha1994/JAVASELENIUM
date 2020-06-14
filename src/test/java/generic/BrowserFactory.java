package generic;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory implements Auto_const
{
	//creating map structre private statc(this is made non static) map<> = new HashMap<>(); to get key and value pair
	// so beforee it was static(since staticis single copy and nonstatic is multiple copy) i make nonstatic
	private Map<String,WebDriver> drivers = new HashMap<String,WebDriver>();// using ap to get key values
	//method is also made nonstatic
	public WebDriver getBrowser(String browserName)
	{
		WebDriver driver = null;
		switch (browserName) 
		{
		case "chrome":
			driver = drivers.get("chrome");
			if(driver ==null)
				System.setProperty(chrome_Key, chrome_value);
				driver = new ChromeDriver();
				drivers.put("chrome", driver);//adding  data to hashmap from chrome
			break;
		case "firefox":
			driver = drivers.get("firefox");
			if(driver ==null)
				System.setProperty(gecko_Key, gecko_value);
				driver = new FirefoxDriver();
				drivers.put("firefox", driver);//adding  data to hashmap from chrome
			break;
		default:
			System.out.println("no such browser");
			break;
		}
	return driver;				
	}
}
