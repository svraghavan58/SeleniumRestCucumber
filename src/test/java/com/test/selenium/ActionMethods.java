package com.test.selenium;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionMethods extends BrowMethods{

	public void moveElement(WebElement element)
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(element).build().perform();
		
	}
	public void dragAndDropElement(WebElement source,WebElement target)
	{
		Actions actions=new Actions(driver);
		actions.dragAndDrop(source, target);
		
	}
	
}
