package com.sample.crud.withoutbdd;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SampleTestForDelete
{
	@Test
	public void getDataFromServer()
	{
		Response res=RestAssured.delete("http://49.249.28.218:8091/project/NH_PROJ_6820");
		//System.out.println(res.prettyPrint());//display the response in the form of json
		//System.out.println(res.asString());//display the response in the form of string
		
		//to put validation, in response there is a method called then()
		//res.then().assertThat().statusCode(200);
		
		//to display the complete response header information there is a method called then().log().all()
		res.then().log().all();
		
	}
}
