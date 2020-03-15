package com.inetbanking.tecases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObject.LoginPage;
import com.inetbanking.pageObject.NewCustomerPage;

public class TC_AddCustomer_001 extends BaseClass {

	
	
	String email=randomString()+"@yahoo.com";
	
	@Test
	public void addCustomer() throws InterruptedException
	{
		LoginPage lp= new LoginPage(driver);
		lp.setUserName(user_id);
		logs.info("user id entered");
		lp.setPwd(password);
		logs.info("password entered");
		lp.clickLoginBtn();
	logs.info("Login buuton clicked");
		NewCustomerPage custN= new NewCustomerPage(driver);
		
		custN.clickNewCustomer();
		custN.setUserName("Rajen ku sahoo");
		custN.selectGender("female");
		custN.selectDOB("09","01", "1999");
		custN.setAddress("hig 198  Block k6 ");
		custN.setCity("bhubaneswar");
		custN.setState("Odisha");
		custN.setPinNUm("751019");
		custN.setMobNum("9988877711");
		custN.setEmail(email);
		custN.setPwd("1234567");
		Thread.sleep(5000);
		custN.clickSubmit();
		Thread.sleep(10000);
		logs.info("create customer information submitted");
		
		boolean res= driver.getPageSource().contains("Customer Registered Successfully!!!");
		System.out.println("result is :::"+res);
		if (res==true)
		{
			Assert.assertTrue(true);
			
		}
		else
				//System.out.println("Test failed");
			{
			try {
				captureScreen(driver, "AddCustomer");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("screen captured");
			logs.info("screen captured");
			logs.info("test failed");
			logs.debug("test add customer failed due to wrong message");
			Assert.assertTrue(false);
			}
		
		}
	
	
	
	
	
	
}
