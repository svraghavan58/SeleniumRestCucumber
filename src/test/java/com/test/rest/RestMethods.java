package com.test.rest;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class RestMethods {
	
	public void openURI(String uri)
	{
		RestAssured.baseURI=uri;
	}
	public RequestSpecification defineRequest(Header header)
	{
		
		RequestSpecification request=RestAssured.given().header(header);
		return request;
	}
	
	public RequestSpecification defineRequestForBasicAuthentication(String name,String value)
	{
		RequestSpecification request=RestAssured.given().auth().basic(name, value);
		
		
		return request;
	}
	public RequestSpecification defineRequestForqueryParam(String paramName,String paramValue)
	{
		RequestSpecification request=RestAssured.given().queryParam(paramName, paramValue);
		return request;
	}
	public RequestSpecification defineRequestforBodyParam(JSONObject js)
	{
		RequestSpecification request=RestAssured.given().body(js.toJSONString());
		return request;
	}
	public Response getResponse(RequestSpecification request)
	{
		Response response=request.when().get();
		System.out.println(response.asPrettyString());
		return response;
	}
	public ResponseBody getReponsebody(Response response)
	{
		ResponseBody body=response.getBody();
		return body;
	}
	public void getResponseCode(Response response)
	{
		response.getStatusCode();
	}
	public void getReponseMessage(Response response)
	{
		response.getStatusLine();
	}
	public void verifyResponseCode(Response response,int code)
	{
		response.then().assertThat().statusCode(code);
	}
	public String getJsonValue(String path,Response response)
	{
		JsonPath js=response.jsonPath();
		return js.getString(path);
		//path=data.id(0);
		
	}
	public List getJsonValueList(String path,Response response)
	{
		JsonPath js=response.jsonPath();
		return js.getList(path);
	}
	public void verifyValue(String path,Response response,String value)
	{
		response.then().assertThat().body(path, Matchers.equalTo(value));
		//response.getTime();
		
	}

	public void getHeaderValue(String header,Response response)
	{
		response.getHeader(header);
	}
	public Map<String,String> getHeadersValue(Response response)
	{
		LinkedHashMap<String,String> hm=new LinkedHashMap<String,String>();
		Headers headers=response.getHeaders();
		for(Header header:headers)
		{
			hm.put(header.getName(), header.getValue());
		}
		return hm;
	}
	public void verifySchemaJson(String fileName,Response response)
	{
		response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath(fileName));
	}
}
