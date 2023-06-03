package com.test.selenium;

import org.openqa.selenium.WebElement;

public class FrameMethods extends BrowMethods{
	
	public void switchFrame(WebElement element)
	{
		driver.switchTo().frame(element);
	}
	public void switchFrame(int index)
	{
		driver.switchTo().frame(index);
	}
	public void switchFrame(String frameName)
	{
		driver.switchTo().frame(frameName);
	}
	public void switchParentFrame()
	{
		driver.switchTo().parentFrame();
	}
	public void comeOutOfFrame()
	{
		driver.switchTo().defaultContent();
	}

}
