package requests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC_001_GetRequest {
	
	@Test
	public void getStudentDetails() {
		//Get requests
		RestAssured.baseURI="http://localhost:3333/student";
		RequestSpecification httpRequest =  RestAssured.given();
		Response response =httpRequest.request(Method.GET, "/2");
		String responseBody= response.body().asString();
		System.out.println(responseBody);
		
		int statusCode =response.statusCode();
		Assert.assertEquals(statusCode, 200);
		System.out.println(statusCode);
		
		String statusLine= response.statusLine();
		System.out.println(statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
		
	}

}
