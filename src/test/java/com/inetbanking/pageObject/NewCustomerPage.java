package com.inetbanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomerPage  {

	
	WebDriver ldriver;

	
	public NewCustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
	}
	
	
	@FindBy(xpath="//*[a= 'New Customer']")
	WebElement newCustomer;
	@FindBy(name="name")
	WebElement custNmae;
	@FindBy(xpath="//input[@value='m']" )
	WebElement genderM;
	@FindBy(xpath="//input[@value='f']" )
	WebElement genderF;
	
	@FindBy(xpath="//input[@id='dob']" )
	WebElement dob;
	@FindBy(xpath="//textarea[@name='addr']")
	WebElement address;
	@FindBy(xpath="//input[@name='city']" )
	WebElement cityName;
	//@FindBy(xpath="//inpt[@name='state']")
	//WebElement state;
	@FindBy(xpath="//input[@name='pinno']" )
	WebElement pinNum;
	@FindBy(xpath="//input[@name='telephoneno']" )
	WebElement mobNumber;
	@FindBy(xpath="//input[@name='emailid']" )
	WebElement emailId;
	@FindBy(xpath="//input[@name='password']" )
	WebElement password;
	@FindBy(name="state" )
	WebElement state;
	@FindBy(xpath="//input[@name='sub']")
	WebElement submitBtn;
	@FindBy(xpath="//input[@name='res']" )
	WebElement resetBtn;
	

	public void clickNewCustomer()
	
	{
		newCustomer.click();
		
	}
	
	public void setUserName(String name)
	
	{
		custNmae.sendKeys(name);
	}
	
	public void selectGender(String gender)
	{
		if( gender.equalsIgnoreCase("male"))
		genderM.click();
		else
		genderF.click();	
			
	}
	public void selectDOB(String dd,String mm, String yyyy)
	{
		dob.sendKeys(dd);
		dob.sendKeys(mm);
		dob.sendKeys(yyyy);
	}
	
	public void setAddress(String addr)
	{
		address.sendKeys(addr);
	}
	
	public void setCity(String city)
	{
		cityName.sendKeys(city);
	}
	public void setState(String stateName)
	{
		state.sendKeys(stateName);
	}
	
	public void setPinNUm(String pin)
	{
		pinNum.sendKeys(String.valueOf(pin));
	}
	public void setMobNum(String mob)
	{
		mobNumber.sendKeys(mob);
	}
	
	public void setEmail(String email)
	{
		emailId.sendKeys(email);
	}
	public void setPwd(String pwd)
	{
		password.sendKeys(pwd);
	}
	public void clickSubmit()
	{
		submitBtn.click();
	}
	public void clickReset()
	{
		resetBtn.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
