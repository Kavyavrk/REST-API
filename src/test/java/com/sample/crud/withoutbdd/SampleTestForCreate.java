package com.sample.crud.withoutbdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleTestForCreate
{
	@Test
	public void postDataIntoServer()
	{
		JSONObject jsonobj=new JSONObject();
		jsonobj.put("createdBy", "deepak");
		jsonobj.put("projectName", "Orange_01");
		jsonobj.put("status", "Created");
		jsonobj.put("teamSize", 0);
		
		RequestSpecification reqspec = RestAssured.given();
		reqspec.contentType(ContentType.JSON);
		reqspec.body(jsonobj.toJSONString());
		Response res = reqspec.post("http://49.249.28.218:8091/addProject");
		res.then().log().all();
		res.then().assertThat().statusCode(201);
	}
}
