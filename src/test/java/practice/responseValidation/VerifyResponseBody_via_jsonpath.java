package practice.responseValidation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;

import io.restassured.response.Response;

public class VerifyResponseBody_via_jsonpath
{
	@Test
	public void sampleTest1()
	{
		Response res = given().get("http://49.249.28.218:8091/projects-paginated");//we use response whwn you want to capture the data
		res.then().log().all();
		
		res.then().assertThat().body("numberOfElements", Matchers.greaterThanOrEqualTo(20));
		res.then().assertThat().body("pageable.sort.unsorted", Matchers.equalTo(true));
		res.then().assertThat().body("content[0].projectId", Matchers.equalTo("NH_PROJ_8694"));
		ArrayList<String> list = res.jsonPath().get("content.projectId");
		System.out.println(list);
		/*int data = res.jsonPath().get("numberOfElements");// whenever we use restassured jsonpath . is not required
															// automatically it will put .
		System.out.println(data);
		Boolean dta1 = res.jsonPath().get("pageable.sort.unsorted");
		System.out.println(dta1);
		String dta2 = res.jsonPath().get("content[0].projectId");
		System.out.println(dta2);*/
	}
}
