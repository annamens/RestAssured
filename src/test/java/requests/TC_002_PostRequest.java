package requests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_002_PostRequest {

	@Test
	public void postRequest() {
		// specify base URI
		RestAssured.baseURI = "http://localhost:3333/student";
		RequestSpecification httpRequest = RestAssured.given();

		String requestParams = "{\"first_name\":\"srinivas\",\"last_name\":\"50k\",\"mobile\":\"7745675\"}";

		httpRequest.contentType(ContentType.JSON);
		httpRequest.body(requestParams); // attach above data to the request

		// response object
		Response response = httpRequest.post();
		// print response
		String res = response.getBody().asString();
		System.out.println(res);

		System.out.println(response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 201);
	}

}
