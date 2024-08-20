package types.of.parameter;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathParameter
{
	@Test
	public void sampleTest()
	{
		given()
		.pathParam("projectId","NH_PROJ_8704")
		.when().get("http://49.249.28.218:8091/project/{projectId}")
		.then().log().all();
	}
}
