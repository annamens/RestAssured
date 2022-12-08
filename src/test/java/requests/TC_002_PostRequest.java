package requests;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.internal.path.json.mapping.JsonObjectDeserializer;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_002_PostRequest {
	
	@Test
	public void postRequest() {
		//specify base URI
		RestAssured.baseURI= "http://localhost:3333";
		RequestSpecification httpRequest = RestAssured.given();
		//request payload sending along with post request
		JSONObject requestParams = new JSONObject();
		requestParams.put("email", "abc@gmail.com");
		requestParams.put("first_name", "ABC");
		requestParams.put("last_name", "XYZ");
		requestParams.put("mobile", "12345");
		
		httpRequest.header("Accept", "application/json","Content Type", "application/json");
		httpRequest.body(requestParams.toJSONString()); // attach above data to the request
		
		//response object
		Response response = httpRequest.request(Method.POST,"/student");
		//print response
		String res = response.getBody().asString();
		System.out.println(res);
		
		System.out.println(response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 201);
	}

}
