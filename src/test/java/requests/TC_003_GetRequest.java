package requests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_003_GetRequest {
	
	@Test
	public void postRequest() {
		//specify base URI
		RestAssured.baseURI="http://localhost:3333/student";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		Response response =httpRequest.request(Method.GET,"");
		
		System.out.println(response.getBody().asString());
		
		System.out.println(response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
