package com.test.selenium;

import org.openqa.selenium.Alert;

public class AlertMethods extends BrowMethods{
	public Alert switchAlert()
	{
		Alert alert=driver.switchTo().alert();
		return alert;
	}
	public void acceptAlert()
	{
		switchAlert().accept();
	}
	public void rejectAlert()
	{
		switchAlert().dismiss();
	}
	public String getAlertText()
	{
		return switchAlert().getText();
	}
	public void sendValues(String values)
	{
		switchAlert().sendKeys(values);
	}

}
