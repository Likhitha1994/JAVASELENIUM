package generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileManager {
	Properties pro;
	public FileManager()
	{
		
		try {
			FileInputStream fis = new FileInputStream("./Configuration.Properties");
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("invalid path");
		}
		
	}
	public String getUrl() {
		String url = pro.getProperty("QAtest1");//fetching value from configuration properties to avoid hardcoding
		if(url==null)
		{
			throw new RuntimeException("invalid url");
		}
		return url;
	}

	public long getImplicitlyWait() {
		String implicitlywait = pro.getProperty("iw");//fetching value from configuration properties
		if(implicitlywait==null)
		{
			throw new RuntimeException("invalid time");
		}
		return Long.parseLong(implicitlywait);
		
	}
}
