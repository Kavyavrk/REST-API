package practice.responseValidation;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class VerifyResponseHeaderTest
{
	@Test
	public void verifyHeader()
	{
		Response res = given().get("http://49.249.28.218:8091/projects");
		res.then().log().all();
		long time = res.time();//by default milliseconds
		long timesec = res.timeIn(TimeUnit.SECONDS);//seconds
		System.out.println(time);
		System.out.println(timesec);
		res.then().assertThat().time(Matchers.lessThan(900L));//Matchers belongs to 
		res.then().assertThat().time(Matchers.greaterThan(300L));
		res.then().assertThat().time(Matchers.both(Matchers.lessThan(900L)).and(Matchers.greaterThan(300L)));
		}
}
