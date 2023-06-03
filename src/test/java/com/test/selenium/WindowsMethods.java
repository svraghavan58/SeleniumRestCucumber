package com.test.selenium;

import java.util.Set;

public class WindowsMethods extends BrowMethods {
	
	public String getWindowName()
	{
		return driver.getWindowHandle();
	}
	public Set<String> getAllWindows()
	{
		return driver.getWindowHandles();
	}
	
	public void switchWindow(String windowName)
	{
		driver.switchTo().window(windowName);
	}

}
