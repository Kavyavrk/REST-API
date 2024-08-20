package practicePostrequestTypes;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoclass.util.ProjectPOJO;

public class PostReq_Via_POJOclass
{
	
	@Test
	public void postDataToServer()
	{
		// create an object to POJO class
		Random r = new Random();
		int ran = r.nextInt(5000);
		ProjectPOJO pobj = new ProjectPOJO("Aby_" + ran, "Created", 0, "Deepak");

		given()
		.contentType(ContentType.JSON)
		.body(pobj)
		.when()
		.post("http://49.249.28.218:8091/addProject")
		.then()
		.assertThat().statusCode(201).log().all();
	}
}
