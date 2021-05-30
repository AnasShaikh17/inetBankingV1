package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass
{
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String uname, String pwd) throws IOException, InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(uname);
		lp.setPassword(pwd);
		lp.clickSubmit();
		
		
		if(checkAlert())
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.info("Wrong credentials");
			Assert.assertTrue(false);
			
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Right credentials");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
		
	}
	
	
	public boolean checkAlert()
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		String path = "./src/test/java/com/inetbanking/testData/LoginDetails.xlsx";
		
		int rowcount = XLUtils.getRowCount(path, "Sheet1");
		
		int colcount = XLUtils.getCellCount(path, "Sheet1",1);
		
		String logindata[][]=new String[rowcount][colcount];
		
		for(int i=1;i<=rowcount;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
				
			}
		}
		
		return logindata;
		
	}
}
