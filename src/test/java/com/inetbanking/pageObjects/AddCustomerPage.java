package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	WebDriver ldriver;

public AddCustomerPage(WebDriver rdriver)
{
	ldriver = rdriver;
	PageFactory.initElements(ldriver, this);
}

@FindBy(css="a[href='addcustomerpage.php']")
WebElement newCustomer;

@FindBy(css="input[name='name']")
WebElement customerName;

@FindBy(css="input[value='m']")
WebElement genderMale;

@FindBy(css="input[value='f']")
WebElement genderFemale;

@FindBy(css="input[name='dob']")
WebElement dob;

@FindBy(css="textarea[name='addr']")
WebElement address;

@FindBy(css="input[name='city']")
WebElement city;

@FindBy(css="input[name='state']")
WebElement state;

@FindBy(css="input[name='pinno']")
WebElement pin;

@FindBy(css="input[name='telephoneno']")
WebElement mobile;

@FindBy(css="input[name='emailid']")
WebElement email;

@FindBy(css="input[name='password']")
WebElement password;

@FindBy(css="input[name='sub']")
WebElement submit;

public void clickNewCustLink()
{
	newCustomer.click();
}

public void setCustName(String cname)
{
	customerName.sendKeys(cname);
}

public void setGender(String gend)
{
	if(gend.equalsIgnoreCase("male"))
	{
		genderMale.click();
	}
	else
	{
		genderFemale.click();
	}
}

public void setDOB(String dd, String mm, String yyyy)
{
	dob.sendKeys(dd);
	dob.sendKeys(mm);
	dob.sendKeys(yyyy);
}

public void setAddress(String addr)
{
	address.sendKeys(addr);
}

public void setCity(String cit)
{
	city.sendKeys(cit);
}

public void setState(String st)
{
	state.sendKeys(st);
}

public void setPin(String pi)
{
	pin.sendKeys(pi);
}

public void setMobile(String mob)
{
	mobile.sendKeys(mob);
}

public void setEmail(String em)
{
	email.sendKeys(em);
}

public void setPassword(String pass)
{
	password.sendKeys(pass);
}

public void clickNewCustSubmit()
{
	submit.click();
}



}
