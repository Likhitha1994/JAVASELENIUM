package regressionscripts;

import generic.Excel;
import generic.Generic_Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.Test;

import pom.LoginPage;

public class Invaild extends Generic_Test
{
	@Test
	public void Login() throws EncryptedDocumentException, InvalidFormatException, IOException 
	{
		String username9 = Excel.getData("Sheet1", 1, 1);
		String password9 = Excel.getData("Sheet1", 1, 0);
		String etitle = Excel.getData("Sheet1", 1, 2);
		System.out.println("fetched");
		test=reports.createTest("InvalidLogin","authetincation");
		//Assert.fail();
		//test=reports.createTest("INValidlogin", "Checking for Authentication"); 
		
		LoginPage lp = new LoginPage(driver);
		//lp.clicklog();
		test.info("test started");
		lp.setUsername(username9);
		test.pass("User Entered UserName");
		lp.setPassword(password9);
		test.pass("User Entered Passsword");
		lp.Login();
		test.pass("User clicked on login");
		test.info("test ended");
		String atitle = driver.getTitle();
		Assert.assertEquals(atitle, etitle);
		Assert.fail();//manually failing the test case
		System.out.println(etitle);
	}
}
