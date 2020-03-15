package com.inetbanking.tecases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObject.LoginPage;

public class TC_Login_001 extends BaseClass {

	
	@Test
	public void loginTest() 
	{
		//driver.get("http://demo.guru99.com/v4");
				logs.debug("URL opened");
				logs.info("open browser");

		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user_id);
		logs.debug("user name entered");
		lp.setPwd(password);
		logs.debug("password entered");

		lp.clickLoginBtn();
		logs.debug("loging button clicked");
		logs.info("login done");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sTitle= driver.getTitle();
		if(sTitle.equals("Guru99 Bank Manager44 HomePage"))
				{
			Assert.assertTrue(true);
			logs.debug("Login test passed");

				}
		else
		{ 
			System.out.println("call screen capture");
			try {
				captureScreen(driver, "loginTest");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("screen captured");
			logs.debug(" Login test failed");
			logs.info("fail");
			Assert.assertTrue(false);
			

		}
	}
}
