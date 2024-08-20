package request.chaining;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoclass.util.EmployeePojo;
import pojoclass.util.ProjectPOJO;

public class Scenario2_AddEmployeeToProject
{
	//create an object to POJO class
		@Test
		public void postDataToServer()
		{
			Random r = new Random();
			int ran = r.nextInt(5000);
			ProjectPOJO pobj = new ProjectPOJO("Airtel_" + ran, "Created", 0, "Deepak");

			// Api-1 ==>add a project inside the server
			Response res = given().contentType(ContentType.JSON).body(pobj).when()
					.post("http://49.249.28.218:8091/addProject");
			res.then().assertThat().statusCode(201).log().all();

			// capture data(projectName) from the response
			String projectName = res.jsonPath().get("projectName");
			System.out.println(projectName);

			// Api-2 ===>add employee to same Project
			// String designation, String dob, String email, String empName, double
			// experience,
			// String mobileNo, String project, String role, String username
			EmployeePojo emp = new EmployeePojo("Architect", "19/08/19944", "deepak@gmail.com", "Aby_" + ran, 18,
					"7876899087", projectName, "ROLE_EMPLOYEE", "Aby_" + ran);
			given().contentType(ContentType.JSON).body(emp).when().post("http://49.249.28.218:8091/employees").then()
					.assertThat().statusCode(201).log().all();
		}
}
