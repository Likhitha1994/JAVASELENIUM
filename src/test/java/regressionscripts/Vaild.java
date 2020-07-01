package regressionscripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import pom.LoginPage;
import generic.Excel;
import generic.Generic_Test;

public class Vaild extends Generic_Test
{
	@Test
	public void Login() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		String username9 = Excel.getData("Sheet1", 1, 0);
		String password9 = Excel.getData("Sheet1", 1, 1);
		System.out.println("fectched");
		LoginPage lp = new LoginPage(driver);
		//lp.clicklog();
		lp.setUsername(username9);
		lp.setPassword(password9);
		lp.Login();
		System.out.println("entered new data");
	}
}
