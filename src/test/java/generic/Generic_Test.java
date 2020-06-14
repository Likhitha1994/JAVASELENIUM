package generic;

import java.io.IOException;
//import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.jmx.LoggerDynamicMBean;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;



public class Generic_Test implements Auto_const  
{
	public WebDriver driver;
	public static ExtentHtmlReporter htmlReporter;//to set the path where to create report
	public static ExtentReports reports;// to generate report
	public static  ExtentTest test;
	FileManager fm = new FileManager();
	BrowserFactory bff = new BrowserFactory();// since the getBrowser in BrowserFactory is made nonstatic create object
	Logger log=Logger.getLogger(Generic_Test.class);
	@BeforeSuite
	public void setUp() //before suite(report generation) condition will applicable to all the test cases
	{
		//htmlReporter=new ExtentHtmlReporter("./reports/E.html");
		htmlReporter=new ExtentHtmlReporter("./reports/i.html");
		reports =new ExtentReports();
		reports.attachReporter(htmlReporter);
	}
	@Parameters({"browser"})
	@BeforeMethod
	public void openAppn(@Optional("chrome")String browser)//@optionalparameter is used using to specifiy testcase with out xml.application
	//for specific  testcase without xml
	{
		if(browser.equals("chrome"))
		{
			//BasicConfigurator.configure();
			log.info("STARTING BROWSER");
			//System.setProperty(chrome_Key, chrome_value);
			//driver = new ChromeDriver();
			//driver.get("");
			driver =bff.getBrowser("chrome");
			//Assert.fail();
			driver.get(fm.getUrl());
			/*driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			driver.get(Filemanager.getappurl());*/	
		}
		else if(browser.equals("firefox"))
		{
			driver =bff.getBrowser("firefox");
			driver.get(fm.getUrl());//call the method throught reference variable
			//driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		}
			
	}
	
	@AfterMethod
	public void closeAppn(ITestResult res) throws IOException//ItestResult is an listener interface(doubt y it is interface)
	{
		System.out.println(res.getStatus());//using variable res we use inbuilt method getstatus as 1pass 2 fail
		if(ITestResult.FAILURE==res.getStatus())
		{
			String testName = res.getName();//getname inbuld method id used to the name of testcase
			test.fail("test script failed", MediaEntityBuilder.createScreenCaptureFromPath(new GenericSS().caputureimg(driver,testName)).build());
			test.assignAuthor("Likhitha G");
			test.assignCategory("Regression testing");
			reports.setSystemInfo("ASUS","Windows 7");
			//GenericSS.caputureimg(driver, testName);//classname.method name from GenericSS since
		}
		else if(ITestResult.SKIP==res.getStatus())
		{
			String testName = res.getName();
			test.skip("test script failed", MediaEntityBuilder.createScreenCaptureFromPath(new GenericSS().caputureimg(driver,testName)).build());
			 
		}
			
		driver.quit();
		log.info("CLOSING BROWSER");
	}
	@AfterSuite
	public void tearDown() //save the generated report
	{
		
		reports.flush();
		
	}
	
}
