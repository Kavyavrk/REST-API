package types.of.parameter;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class QueryParameter2
{
	@Test
	public void sampleTest()
	{
		given()
		//.pathParam("projectId","NH_PROJ_8704")
		.when().get("http://49.249.28.218:8091/project?projectId=NH_PROJ_8704")
		.then().log().all();
	}
}
