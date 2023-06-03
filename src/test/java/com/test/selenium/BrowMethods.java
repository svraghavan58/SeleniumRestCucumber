package com.test.selenium;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowMethods {
	
	public static WebDriver driver;
	
	public WebDriver openBrowser(String browser)
	{
		switch(browser)
		{
		case "chrome":
		{
			System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver_win32\\chromedriver.exe");
			ChromeOptions c=new ChromeOptions();
			c.addArguments("--RemoteAcceptOrigin");			
			driver=new ChromeDriver(c);
			break;
			
		}
		case "edge":
		{
			System.setProperty("webdriver.edge.driver", "D:\\Softwares\\edgedriver_win64\\msedgedriver.exe");
			EdgeOptions e=new EdgeOptions();
			e.addArguments("--RemoteAcceptOrigin");
			driver=new EdgeDriver(e);
			break;		
		}
		default:
		{
			System.out.println("please enter proper browser name");
			break;
		}
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		return driver;
	}
	
	public void openBrowser()
	{
		System.setProperty("webdriver.edge.driver", "D:\\Softwares\\edgedriver_win64\\msedgedriver.exe");
		ChromeOptions c=new ChromeOptions();
		c.addArguments("--Incognito");
		c.setAcceptInsecureCerts(true);
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(ChromeOptions.CAPABILITY, c);
		c.merge(cap);
	}

	public void openUrl(String url)
	{
		driver.get(url);
	}
	public String getCurrUrl()
	{
		return driver.getCurrentUrl();
	}
	public String getPgSource()
	{
		return driver.getPageSource();
	}
	public String getPgTitle()
	{
		return driver.getTitle();
	}
	public void maximizeBrowser()
	{
		driver.manage().window().maximize();
	}
	public void minimizeBrowser()
	{
		driver.manage().window().minimize();
	}
	public void closeBrowser()
	{
		driver.close();
	}
	public void quitBrowser()
	{
		driver.quit();
	}
	public void navigateUrl(String url)
	{
		driver.navigate().to(url);
	}
	public void navigateBack()
	{
		driver.navigate().back();
	}
	public void navigateForward()
	{
		driver.navigate().forward();
	}
	public void navigateRefresh()
	{
		driver.navigate().refresh();
	}
	
}
