package generic;

import java.io.File;
import java.io.IOException;
//import java.sql.Date;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class GenericSS {

	public static String caputureimg(WebDriver driver, String testName)throws IOException {
		
		//String path=("D://photos/.png");
		Date d = new Date();//import from util package
		String d1 = d.toString();
		String date = d1.replace(":", "-");
		String path1 = System.getProperty("user.dir")+"./photo/"+date+testName+".png";
		TakesScreenshot ts = (TakesScreenshot)driver;
		File scr = ts.getScreenshotAs(OutputType.FILE);
		//File dst = new File(path+date+"testName"+".png");//concatinate TestName
		File dst = new File(path1);
		FileHandler.copy(scr, dst);
		return path1;
	
	}

}
