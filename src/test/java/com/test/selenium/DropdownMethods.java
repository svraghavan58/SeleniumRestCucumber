package com.test.selenium;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownMethods {
	
	public Select getSelect(WebElement element)
	{
	Select select =new Select(element);
	return select;
	}
	
	public void selectDeselectValue(WebElement element,String deselectSelectMethod,String value)
	{
		switch(deselectSelectMethod)
		{
		case "selectByValue":
		{
			getSelect(element).selectByValue(value);
			break;
		}
		case "selectByVisibleText":
		{
			getSelect(element).selectByVisibleText(value);
			break;
		}
		case "selectByIndex":
		{
			int index=Integer.parseInt(value);
			getSelect(element).selectByIndex(index);
			break;
		}
		case "deselectByValue":
		{
			getSelect(element).deselectByValue(value);
			break;
		}
		case "deselectByVisibleText":
		{
			getSelect(element).deselectByVisibleText(value);
			break;
		}
		case "deselectByIndex":
		{
			int index=Integer.parseInt(value);
			getSelect(element).deselectByIndex(index);
			break;
		}	
		}

	}
 public List<WebElement> getAllOptions(WebElement element)
 {
	return getSelect(element).getOptions();
	 
 }
 public List<WebElement> getSelectedOptions(WebElement element)
 {
	 return getSelect(element).getAllSelectedOptions();
 }
 public WebElement getFirstSelectedOpt(WebElement element)
 {
	 return getSelect(element).getFirstSelectedOption();
 }
 public boolean verifyMultiple(WebElement element)
 {
	 return getSelect(element).isMultiple();
 }
 public void deselectAllValue(WebElement element)
 {
	 getSelect(element).deselectAll();
 }

}
