package com.test.selenium;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import com.test.util.XMLUtils;

public class ElementMethods extends BrowMethods{
	
	public WebElement getElement(String fileName,String elementName,String attributeName)
	{
		WebElement element=null;
		XMLUtils xu=new XMLUtils();
		
		String locatorType=xu.getXMLValueAttribute(fileName, elementName, "locatorType");
		String locatorValue=xu.getXMLValueAttribute(fileName, elementName, "locatorValue");
		
		switch(locatorType)
		{
		case "id":
		{
			element=driver.findElement(By.id(locatorValue));
			break;
		}
		case "name":
		{
			element=driver.findElement(By.name(locatorValue));
			break;
		}
		case "className":
		{
			element=driver.findElement(By.className(locatorValue));
			break;

		}
		case "tagName":
		{
			element=driver.findElement(By.tagName(locatorValue));
			break;
		}
		case "linkText":
		{
			element=driver.findElement(By.linkText(locatorValue));
			break;
		}
		case "partialLinkText":
		{
			element=driver.findElement(By.partialLinkText(locatorValue));
			break;
		}
		case "xpath":
		{
			element=driver.findElement(By.xpath(locatorValue));
			break;
		}
		case "cssSelector":
		{
			element=driver.findElement(By.cssSelector(locatorValue));
			break;
		}
		default:
		{
			System.out.println("please enter correct value");
			break;
		}
		
		}
		return element;
	}
	
	public String getInnerText(WebElement element)
	{
		return element.getText();
	}
	public String getAttributeValue(WebElement element,String attribute)
	{
		return element.getAttribute(attribute);
	}
	public String getCssProperty(WebElement element,String property)
	{
		return element.getCssValue(property);
	}
	public boolean verifyElementDisplayed(WebElement element)
	{
		return element.isDisplayed();
	}
	public boolean verifyElementEnabled(WebElement element)
	{
		return element.isEnabled();
	}
	public boolean verifyElementSelected(WebElement element)
	{
		
		return element.isSelected();
	}
	public int getElementHeight(WebElement element)
	{
		Dimension d=element.getSize();
		return d.getHeight();
		
		
	}
	public int getElementWidth(WebElement element)
	{
		Dimension d=element.getSize();
		return d.getWidth();
	}
	public int getElementX(WebElement element)
	{
		Point p=element.getLocation();
		return p.getX();
	}
	public int getElementY(WebElement element)
	{
		Point p=element.getLocation();
		return p.getY();
	}

	public void clearElement(WebElement element)
	{
		element.clear();
	}
	public void enterValue(WebElement element,String value)
	{
		element.sendKeys(value);
	}
	public void enterValue(WebElement element,Keys key)
	{
		element.sendKeys(key);
		//key.chord(Keys.ALT,Keys.CONTROL,Keys.COMMAND)
	}
	public void clickElement(WebElement element)
	{
		element.click();
	}
	public void submitElement(WebElement element)
	{
		element.submit();
	}
	
}
