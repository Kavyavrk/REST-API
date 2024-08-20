package types.of.parameter;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class FormParameter
{
	@Test
	public void sampleTest()
	{
		given()
		.formParam("teamSize", 10)//softcoding of data ***we can also use dataProvider to pass the data
		.log().all()
		.when().post("http://49.249.28.218:8091/project")
		.then().log().all();
	}
}
