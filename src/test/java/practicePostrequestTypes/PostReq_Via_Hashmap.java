package practicePostrequestTypes;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostReq_Via_Hashmap
{
	@Test
	public void postDataIntoServer()
	{
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("createdBy", "deepak");
		map.put("projectName", "Orange_05");
		map.put("status", "Created");
		map.put("teamSize", 0);
		
		given()
		.contentType(ContentType.JSON)
		.body(map)
		.when()
		.post("http://49.249.28.218:8091/addProject")
		.then()
		.assertThat().statusCode(201).log().all();
	}
}
