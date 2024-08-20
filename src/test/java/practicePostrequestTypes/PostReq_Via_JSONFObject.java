package practicePostrequestTypes;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostReq_Via_JSONFObject
{
	@Test
	public void postDataIntoServer()
	{
		JSONObject jsonobj=new JSONObject();
		jsonobj.put("createdBy", "deepak");
		jsonobj.put("projectName", "Orange_02");
		jsonobj.put("status", "Created");
		jsonobj.put("teamSize", 0);
		
		given()
		.contentType(ContentType.JSON)
		.body(jsonobj.toJSONString())
		.when()
		.post("http://49.249.28.218:8091/addProject")
		.then()
		.assertThat().statusCode(201).log().all();
	}
}
