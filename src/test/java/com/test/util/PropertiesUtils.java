package com.test.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesUtils {
	
	public String getPropValue(String fileName,String property)
	{
		File file=new File(fileName);
		Properties prop=new Properties();
		String propValue=null;
		try
		{
			FileInputStream fis=new FileInputStream(file);
			prop.load(fis);
			propValue=prop.getProperty(property);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return propValue;
	}

}
