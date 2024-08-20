package com.sample.crud.withoutbdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleTestForCompleteUpdate
{
	@Test
	public void putDataIntoServer()
	{
		JSONObject jsonobj=new JSONObject();
		jsonobj.put("projectName", "Apple_0110");
		
		RequestSpecification reqspec = RestAssured.given();
		reqspec.contentType(ContentType.JSON);
		reqspec.body(jsonobj.toJSONString());
		Response res = reqspec.put("http://49.249.28.218:8091/project/NH_PROJ_6828");
		res.then().log().all();
		res.then().assertThat().statusCode(200);
	}
}
