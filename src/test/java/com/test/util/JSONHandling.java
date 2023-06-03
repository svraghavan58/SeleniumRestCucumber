package com.test.util;

import org.json.simple.JSONObject;

public class JSONHandling {
	
	public String addJSONValue(String jsonKey,String jsonValue)
	{
		JSONObject js=new JSONObject();
		js.put(jsonKey, jsonValue);
		return js.toJSONString();
	}
	public String getJSONValue(String fileName,String jsonKey)
	{
		JSONObject js=new JSONObject();
		return (String) js.get(jsonKey);
		
	}
	

}
