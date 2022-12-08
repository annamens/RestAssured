package dataDrivenApiTest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class DataDrivenTest {

	@Test
	public void postNewEmployees() {
		
		String jsonString = "{\"name\":\"srinivas\",\"salary\":\"50k\",\"age\":\"26\"}";

		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/create";

		RequestSpecification httpRequest = RestAssured.given();

		httpRequest.contentType(ContentType.JSON);

		// Adding body as string
		httpRequest.body(jsonString);

		// Calling POST method
		Response response = httpRequest.post();

		// Let's print response body.
		response.prettyPrint();

		ValidatableResponse vr = response.then();

		// Check status code
		vr.statusCode(200);

		// It will check if status line is as expected
		vr.statusLine("HTTP/1.1 200 OK");

	}

}
