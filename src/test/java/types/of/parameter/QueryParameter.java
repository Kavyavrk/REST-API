package types.of.parameter;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class QueryParameter
{
	@Test
	public void sampleTest()
	{
		given()
		.queryParam("project?teamSize", 10)//softcoding of data ***we can also use dataProvider to pass the data
		.when().get("http://49.249.28.218:8091/project")
		//.when().get("http://49.249.28.218:8091/project?teamSize=10")//hardcoding the data
		.then().log().all();
	}
}
