package com.test.selenium;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class RobotMethods {
	
	public void keyUp(int key)
	{
		try
		{
		Robot robot=new Robot();
		robot.keyPress(key);
		//robot.keyPress(KeyEvent.VK_CONTROL);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void keyDown(int key)
	{
		try
		{
			Robot robot=new Robot();
			robot.keyRelease(key);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void mousePress(int key)
	{
		try
		{
			Robot robot=new Robot();
			robot.mousePress(key);
			//robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public void mouseRelease(int key)
	{
		try
		{
		Robot robot=new Robot();
		robot.mouseRelease(key);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void mouseMove(int x,int y)
	{
		try
		{
			Robot robot=new Robot();
			robot.mouseMove(x,y);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void moveMouseWheel(int wheelAmt)
	{
		try
		{
			Robot robot=new Robot();
			robot.mouseWheel(wheelAmt);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void getScreenshot(String fileName)
	{
		try
		{
			Robot robot=new Robot();
			Rectangle rect=new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
			BufferedImage img=robot.createScreenCapture(rect);
			ImageIO.write(img, "jpeg", new File(fileName));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void uploadFile(String fileName)
	{
		try
		{
			Clipboard clipboard=Toolkit.getDefaultToolkit().getSystemClipboard();
			StringSelection sel=new StringSelection(fileName);
			clipboard.setContents(sel,null);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
