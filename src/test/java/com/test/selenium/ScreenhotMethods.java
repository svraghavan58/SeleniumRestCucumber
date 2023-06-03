package com.test.selenium;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenhotMethods extends BrowMethods{
	
	public void getScreenShot(String fileName)
	{
		try
		{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(fileName));
		}
		catch(Exception e)
		{
		e.printStackTrace();
		
		}
	}
	public byte[] getScreenShots()
	{
		byte[] b=null;
		try
		{
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			 b=FileUtils.readFileToByteArray(src);
			
		}
		 catch(Exception e)
		{
			 e.printStackTrace();
		}
		return b;
	}

}
