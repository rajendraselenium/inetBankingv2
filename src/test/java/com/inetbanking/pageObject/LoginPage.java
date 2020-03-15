package com.inetbanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rDriver)
	{
		ldriver=rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	
	@FindBy (name="uid")
    WebElement  we_txtUsedID;
	@FindBy(name="password")
	WebElement we_txtPassword;
	@FindBy (name="btnLogin")
	WebElement we_btnLogin;
	@FindBy (name="btnReset")
	WebElement we_btnReset;
	@FindBy(xpath="//ul[@class='menusubnav']/li[15]")
	WebElement we_btnLogOut;
	
	
	
	
	//Action methods
	
	public void  setUserName (String userid)
	{
		we_txtUsedID.sendKeys(userid);
	}
	
	public void  setPwd (String pwd)
	{
		we_txtPassword.sendKeys(pwd);
	}
	
	
	public void  clickLoginBtn ()
	{
		we_btnLogin.click();;
	}
	
	public void  clickResetBtn ()
	{
		we_btnLogin.click();;
	}
	
	public void  clickLogOutBtn ()
	{
		we_btnLogOut.click();;
	}
	

	
}
