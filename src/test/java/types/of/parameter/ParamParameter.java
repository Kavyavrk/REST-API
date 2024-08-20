package types.of.parameter;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class ParamParameter
{
	@Test
	public void sampleTest()
	{
		given()
		.param("teamSize", 10)//softcoding of data ***we can also use dataProvider to pass the data
		.log().all()
		.when().get("http://49.249.28.218:8091/project")// get acts like query param because it attached to the request body
		.then().log().all();
	}
}
