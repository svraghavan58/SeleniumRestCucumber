package com.test.util;

import java.io.*;

public class FileHandling {
	public void writeToFile(String fileName,String message)
	{
		File file=new File(fileName);
		try
		{
		if(!file.exists())
		{
			file.createNewFile();
		}
		FileWriter fw=new FileWriter(file,true);
		BufferedWriter bw=new BufferedWriter(fw);
		bw.write(message);
		bw.write("\n");
		bw.close();
		fw.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public void readFromFile(String fileName)
	{
		File file=new File(fileName);
		String fileValue=null;
		try
		{
			FileReader fr=new FileReader(file);
			BufferedReader br=new BufferedReader(fr);
			while((fileValue=br.readLine())!=null)
			{
				System.out.println(fileValue);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	

}
