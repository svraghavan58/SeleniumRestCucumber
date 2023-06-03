package com.test.selenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JavaScriptMethods extends BrowMethods{
	
	public void clickelement(WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",element);
	}

	public void moveToElement(WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",element);
	}
	public void clickElement(String id)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("document.findElementById('"+id+"').click();");
	}
	public void clickElementByName(String name)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("document.findElementByName('"+name+"').click();");
	}
}
