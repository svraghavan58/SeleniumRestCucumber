package com.test.util;

import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GeneralUtils {
	
	public void getBrokenLinks(String linkName)
	{
		try
		{
			URL url=new URL(linkName);
			HttpURLConnection hc=(HttpURLConnection) url.openConnection();
			hc.setConnectTimeout(5000);
			hc.connect();
			hc.getResponseCode();
			hc.getResponseMessage();
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void getBokenImage(String imgName)
	{
		try
		{
			HttpClient client=HttpClientBuilder.create().build();
			HttpGet request=new HttpGet(imgName);
			HttpResponse response=client.execute(request);
			response.getStatusLine().getStatusCode();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void getLocalTime()
	{
		try
		{
			DateTimeFormatter df=DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss");
			LocalDateTime now=LocalDateTime.now();
			df.format(now);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void addMinutes()
	{
		try
		{
			SimpleDateFormat sd=new SimpleDateFormat("HH:mm");
			String s="09:30";
			Date d=sd.parse(s);			
			Calendar cal=Calendar.getInstance();
			cal.setTime(d);
			cal.add(Calendar.MINUTE, 30);
			sd.format(cal.getTime());
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public boolean switchToCorrectWindow(String title,List<String> list)
	{
		System.setProperty("webdriver.chrome.driver", "chrome.xex");
		WebDriver driver=new ChromeDriver();
		Set<String> str=driver.getWindowHandles();
		List<String> win=new ArrayList(str);
		for(String e:win)
		{
			String t=driver.switchTo().window(e).getTitle();
			if(t.equals(title))
			{
				return true;
			}
		}
		
		
		return false;
	}
	public boolean webTableHandling(String value)
	{
		System.setProperty("webdriver.chrome.driver", "chrome.xex");
		WebDriver driver=new ChromeDriver();
		WebElement tableElement=driver.findElement(By.tagName("table"));
		List<WebElement> rowElement=tableElement.findElements(By.tagName("tr"));
		for(WebElement row:rowElement)
		{
			List<WebElement> colsElement=row.findElements(By.tagName("td"));
			for(WebElement cols:colsElement)
			{
				if(cols.getText().equals(value))
				{
					return true;
				}
			}
		}
		return false;
	}
}
