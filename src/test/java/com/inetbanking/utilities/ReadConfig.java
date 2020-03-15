package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	public Properties prop;
	
	public ReadConfig() 
	{
		File src= new File ("./Configurations\\config.properties");
		
		try {
			
			FileInputStream fis = new FileInputStream(src);
			prop=new Properties();// i took 2 days to find this issue as i have not initiated.
			prop.load(fis);
			
			}
		
			catch (Exception e)
			{
			System.out.println("exception is "+e.getMessage());
			}
	 		}
	
		public String getURL()
		{
			String url =prop.getProperty("baseURL");
			return  url;
		}
		public String getUserName()
		{
			String username =prop.getProperty("user_id");
			return  username;
		}
		public String getPassword()
		{
			String pwd =prop.getProperty("password");
			return  pwd;
		}
		
		public String chromePath()
		{
			String chromepath =prop.getProperty("chromePath");
			return  chromepath;
		}
		
	}
	
	
