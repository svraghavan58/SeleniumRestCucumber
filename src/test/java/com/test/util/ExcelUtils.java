package com.test.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	public Workbook workbook;
	public Sheet sheet;
	public Cell cell;
	
public Sheet openSheet(String fileName,String sheetName)
{
	File file=new File(fileName);
	String extension=fileName.substring(fileName.indexOf("."));
	try
	{
		FileInputStream fis=new FileInputStream(file);
		if(extension.contains(".xlsx"))
		{
			workbook=new XSSFWorkbook(fis);
		}
		else
		{
			workbook=new HSSFWorkbook(fis);
		}
		sheet=workbook.getSheet(sheetName);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return sheet;
}

public int getTotalRows(String fileName,String sheetName)
{
	return openSheet(fileName,sheetName).getPhysicalNumberOfRows();
}
public String getStringValue(String fileName,String sheetName,int row,int cols)
{
	return openSheet(fileName,sheetName).getRow(row).getCell(cols).getStringCellValue();
}
public void writeToSheet(String fileName,String sheetName,int row,int cols,String message)
{
	try
	{
		cell=openSheet(fileName,sheetName).getRow(row).createCell(cols);
		cell.setCellValue(message);
		File file=new File(fileName);
		FileOutputStream fos=new FileOutputStream(file);
		workbook.write(fos);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
}
