package com.sample.crud.withbdd;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleTestForPartiallyUpdate
{
	@Test
	public void putDataIntoServer()
	{
		JSONObject jsonobj=new JSONObject();
		jsonobj.put("projectName", "Apple_0110");
		
		given()
		.contentType(ContentType.JSON)
		.body(jsonobj.toJSONString())
		.when()
		.patch("http://49.249.28.218:8091/project/NH_PROJ_6858")
		.then()
		.assertThat().statusCode(200).log().all();
	}
}
