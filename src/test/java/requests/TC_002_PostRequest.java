package requests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class TC_002_PostRequest {
	
	@Test
	public void postNewEmployees() {

		JSONObject jsonString = new JSONObject();
		jsonString.put("name", "Harsha");
		jsonString.put("salary", "65000");
		jsonString.put("age", "26");
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/create";

		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.contentType(ContentType.JSON);
		// Adding body as string
		httpRequest.body(jsonString.toString());
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
