package com.inetbanking.testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

import junit.framework.Assert;

public class TC_AddCustomerTest_003 extends BaseClass{

	@Test
	public void addNewCustomer() throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickSubmit();
		
		Thread.sleep(2000);
		
		AddCustomerPage cp = new AddCustomerPage(driver);
		
		cp.clickNewCustLink();
		
		cp.setCustName("Pawan");
		cp.setGender("male");
		cp.setDOB("21", "05", "2021");
		
		Thread.sleep(2000);
		cp.setAddress("Andheri");
		cp.setCity("Mumbai");
		cp.setState("Maharashtra");
		cp.setPin("400056");
		cp.setMobile("97866121");
		cp.setEmail(randomString()+"@gmail.com");
		cp.setPassword("abcde");
		
		//Thread.sleep(2000);
		
		cp.clickNewCustSubmit();
		
		Thread.sleep(2000);
		
		if(driver.getPageSource().contains("Customer Registered Successfully!!!"))
		{
			Assert.assertTrue(true);
			System.out.println("Test case passed");
		}
		else
		{
			Assert.assertTrue(false);
			
		}
		
	}
	
	
}
