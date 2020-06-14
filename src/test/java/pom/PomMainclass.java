package pom;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import generic.Excel;
import generic.Generic_Test;

public class PomMainclass extends Generic_Test
{
	@Test
	public void Login() throws EncryptedDocumentException, InvalidFormatException, IOException 
	{
		String username9 = Excel.getData("Sheet1", 1, 0);
		String password9 = Excel.getData("Sheet1", 1, 1);
		System.out.println("fetched");
		LoginPage lp = new LoginPage(driver);//creating object for LoginPage to pass data from excel
		//lp.clicklog();
		lp.setUsername(username9);
		lp.setPassword(password9);
		lp.Login();
	}

}
