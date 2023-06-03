package com.test.util;

import java.io.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLUtils {

	public String getXMLValue(String fileName,String baseTagName, String childTagName)
	{
		String xmlValue=null;
		File file=new File(fileName);
		try
		{
		//	FileInputStream fis=new FileInputStream(file);
			DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
			DocumentBuilder db=dbf.newDocumentBuilder();
			Document doc=db.parse(file);
			doc.getDocumentElement().normalize();
			doc.getDocumentElement().getNodeName();
			NodeList list=doc.getElementsByTagName(baseTagName);
			for(int i=0;i<list.getLength();i++)
			{
				Node node=list.item(i);
				if(node.getNodeType()==Node.ELEMENT_NODE)
				{
					Element element=(Element) node;
					xmlValue=element.getElementsByTagName(childTagName).item(0).getTextContent();
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return xmlValue;
		
	}
	public String getXMLValueAttribute(String fileName,String baseTagName,String attributeName)
	{
		File file=new File(fileName);
		String xmlValue=null;
		
		try
		{
			DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
			DocumentBuilder db=dbf.newDocumentBuilder();
			Document doc=db.parse(file);
			NodeList list=doc.getElementsByTagName(baseTagName);
			for(int i=0;i<list.getLength();i++)
			{
				Node node=list.item(i);
				if(node.getNodeType()==Node.ELEMENT_NODE)
				{
					Element element=(Element) node;
					xmlValue=element.getAttribute(attributeName);
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return xmlValue;
	}
}
