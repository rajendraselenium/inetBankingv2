package com.inetbanking.tecases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.Test;

import com.inetbanking.utilities.XLUtils;

public class TC_DryTest_001 extends BaseClass {
	
	
	
	
	@Test
	public void dryTest()
	{
		try {
		String xlPath=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/UserLogindata.xlsx"; 
		
			System.out.println("read excel data"+ XLUtils.getCellData(xlPath, "Sheet1", 1, 1));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}


}
