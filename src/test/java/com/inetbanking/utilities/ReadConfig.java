package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig()
	{
		try {
		File src = new File("./Configuration/config.properties");
		
		FileInputStream fis = new FileInputStream(src);
		
		pro = new Properties();
		
		pro.load(fis);
		
		}
		catch(Exception e)
		{
			System.out.println("The exception is: "+e.getMessage());
		}
	}
	
	public String getApplicationURL()
	{
		return pro.getProperty("baseURL");
	}
	
	public String getUsername()
	{
		return pro.getProperty("username");
	}

	public String getPassword()
	{
		return pro.getProperty("password");
	}
	
	public String getChromePath()
	{
		
		return pro.getProperty("chromepath");
	}
	
	public String getFirefoxPath()
	{
		
		return pro.getProperty("firefoxpath");
		
	}
	
}
