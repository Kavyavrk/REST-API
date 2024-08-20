package practice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SampleTest 
{
	@Test
	public void sampleRequestTest()
	{
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(response.prettyPrint());//display response
	}
}

