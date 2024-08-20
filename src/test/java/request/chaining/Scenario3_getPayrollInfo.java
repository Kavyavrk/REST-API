package request.chaining;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

public class Scenario3_getPayrollInfo
{
	@Test
	public void sampleTest()
	{
		// Api1 ===>get Authentication(to get the tokenId)
		/*Before getting the token Id from developer we need to get the protocol information
		 *  whenever we use oauth2 protocol developers should give clientId,cliebt secret and grant_type*/
		 Response res = given()
		.formParam("client_id", "ninza-client")
		.formParam("client_secret", "gPQBf1Yxew5OMccMhzos1GefIyiSnXzM")
		.formParam("grant_type", "client_credentials")
		.when().post("http://49.249.28.218:8180/auth/realms/ninza/protocol/openid-connect/token");
		res.then().log().all();
		
		//capture the token from response
		String token = res.jsonPath().get("access_token");

		// Api2 ==>get payroll info
		given()
		.auth().oauth2(token)//without this token server is not going to response
		.get("http://49.249.28.218:8091/admin/payrolls")
		.then().log().all();
	}
}
