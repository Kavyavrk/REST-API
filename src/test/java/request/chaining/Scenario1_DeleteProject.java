package request.chaining;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoclass.util.ProjectPOJO;

public class Scenario1_DeleteProject
{
	//create an object to POJO class
	@Test
	public void postDataToServer()
	{
		Random r= new Random();
		int ran = r.nextInt(5000);
		ProjectPOJO pobj=new ProjectPOJO("Aby_"+ran, "Created", 0, "Deepak");
		
		// Api-1 ==>add a project inside the server
		Response res = given().contentType(ContentType.JSON).body(pobj).when()
				.post("http://49.249.28.218:8091/addProject");
		res.then().assertThat().statusCode(201).log().all();
		
		//capture data(projectName) from the response
		String projectId = res.jsonPath().get("projectId");
		System.out.println(projectId);
		
		//Api-2 ===>delete the project
		given().delete("http://49.249.28.218:8091/project/"+projectId)
		.then().log().all();
		
	}
}
