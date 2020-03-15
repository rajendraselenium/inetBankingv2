package com.inetbanking.tecases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObject.LoginPage;
import com.inetbanking.utilities.XLUtils;

import junit.framework.Assert;

public class TC_LoginDDT_002 extends BaseClass
{

	
	@Test(dataProvider="LoginData")
	public void loginDDt(String uid,String pwd) throws InterruptedException
	{
		//System.out.println("user id is "+uid);
	//System.out.println("user password is"+ pwd);
//	Thread.sleep(5000);
		LoginPage lp= new LoginPage(driver);
		//System.out.println("user id is "+uid);
		//System.out.println("user password is"+ pwd);
		//Thread.sleep(5000);
		lp.setUserName(uid);
		logs.info("Login userid entered");
		lp.setPwd(pwd);
		logs.info("login password entered");
		lp.clickLoginBtn();
		Thread.sleep(5000);
		if (isAlertPresent()==true)
		{ 
			
			logs.info("Login failed");
			System.out.println("capture screen shot");

			try {
				captureScreen(driver, "LoginDDT");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			
			Assert.assertTrue(false);

		}
		else
		{   
			Assert.assertTrue(true);
			logs.info("login successful");
			lp.clickLogOutBtn();
			Thread.sleep(5000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			
		}
		
		
		
		
		
		
		
		
	}
	 
	@DataProvider(name="LoginData")
	public String[][] getData() 
	{ 
		
		try {
		String xlPath=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/UserLogindata.xlsx"; 
		int rowCount;
		
			rowCount = XLUtils.getRowCount(xlPath, "Sheet1");
			int colCount=XLUtils.getCellCount(xlPath, "Sheet1", 0);
		
		
		String loginData[][]= new String [rowCount][colCount];
		//String loginData[][]= new String [2][2];

		/*loginData[0][0]="rajendra";
		loginData[0][1]="12XX99WW00";
		loginData[0][0]="Googal";
		loginData[0][0]="55YY7788VV";*/
		
		for (int i=1;i<=rowCount;i++)
		{
			for (int j=0;j<colCount; j++)
			{
				loginData[i-1][j]=XLUtils.getCellData(xlPath, "Sheet1", i, j);
			}
		}
		
		//return loginData;*/
		
		return loginData;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} return null;
		
	}
	}
