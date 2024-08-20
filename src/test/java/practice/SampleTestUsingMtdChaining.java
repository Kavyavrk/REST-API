package practice;

import org.testng.annotations.Test;

import  static io.restassured.RestAssured.*;

public class SampleTestUsingMtdChaining 
{
	@Test
	public void getRequesttest()
	{
		//get("https://reqres.in/api/users?page=2").prettyPrint();//method Chaining
		get("https://reqres.in/api/users?page=2").then().log().all();
	}
}
