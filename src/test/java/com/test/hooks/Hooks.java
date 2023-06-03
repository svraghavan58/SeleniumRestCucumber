package com.test.hooks;

import com.test.selenium.ScreenhotMethods;

import io.cucumber.java.*;

public class Hooks {
	
	@Before
	public void beforeMethod()
	{
		System.out.println("Before MEthod");
	}
	@After
	public void afterMethod()
	{
		System.out.println("After Method");
	}
	@Before(order=1)
	public void beforeMethod1()
	{
		System.out.println("Before MEthod1");
		
	}
	@After(order=1)
	public void afterMethod1()
	{
		System.out.println("After Method1");
	}
	@BeforeStep
	
	public void beforeStep()
	{
		System.out.println("before Step");
	}
	@AfterStep
	public void afterStep(Scenario scenario)
	{
		System.out.println("after Step");
		ScreenhotMethods sm=new ScreenhotMethods();
		if(scenario.isFailed())
		{
			scenario.attach(sm.getScreenShots(), "img/png", null);
			
		}
	}
}
