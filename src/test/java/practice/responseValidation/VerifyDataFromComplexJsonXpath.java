package practice.responseValidation;

import static io.restassured.RestAssured.given;

import java.util.Iterator;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.response.Response;

public class VerifyDataFromComplexJsonXpath
{
	@Test
	public void sampleTest()
	{
		Response res = given().get("http://49.249.28.218:8091/projects-paginated");//we use response whwn you want to capture the data
		res.then().log().all();
		List<String> list=JsonPath.read(res.asString() , "content[*].projectName");
		//System.out.println(list);
		for(String data:list)
		{
			System.out.println(data);
		}
		List<String> list1=JsonPath.read(res.asString() , ".content[*].[?(@.projectName=='appolo22')].projectId");
		String actualProjectId=list1.get(0);
		Assert.assertEquals(actualProjectId,"NH_PROJ_8694");
		///why are you extract data
		// ans:1)extract first Projectid
		//2)DB validation
		//3)request Chaining
	}
}
