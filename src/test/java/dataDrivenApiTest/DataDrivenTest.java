package dataDrivenApiTest;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class DataDrivenTest {

	@Test(dataProvider = "empdataprovider")
	public void postRequest(String fname, String lname, String mobile) {
		// specify base URI
		RestAssured.baseURI = "http://localhost:3333/student";
		RequestSpecification httpRequest = RestAssured.given();

//			String requestParams = "{\"first_name\":\"srinivas\",\"last_name\":\"50k\",\"mobile\":\"7745675\"}";
		JSONObject requestParams = new JSONObject();
		requestParams.put("first_name", fname);
		requestParams.put("last_name", lname);
		requestParams.put("mobile", mobile);

		httpRequest.contentType(ContentType.JSON);
		httpRequest.body(requestParams.toString()); // attach above data to the request

		// response object
		Response response = httpRequest.post();
		// print response
		response.prettyPrint();
		String res = response.getBody().asString();
//		System.out.println(res);

		System.out.println(response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 201);
	}

	@DataProvider(name = "empdataprovider")
	String[][] getEmpData() throws IOException {
		
		//Read data from Excel file
		String path = System.getProperty("user.dir") + "\\src\\test\\java\\dataDrivenApiTest\\empData.xlsx";
		int rownum=XLUtils.getRowCount(path, "sheet1");
		int colnum=XLUtils.getCellCount(path, "sheet1", 1);
		String empdata[][]= new String[rownum][colnum];
		
		for(int i =1; i<=rownum;i++) {
			for(int j=0; j<colnum;j++) {
				empdata[i-1][j]=XLUtils.getCellData(path, "sheet1", i, j);
				
			}
		}
		
//		String emp[][] = { { "Nikhil", "chekuri", "8464089" }, { "srinivas", "annameni", "12345" },
//				{ "suresh", "kumar", "96666485" }, };
		return empdata;
	}

}